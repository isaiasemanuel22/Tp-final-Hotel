package com.company.services;

import com.company.controller.Menu;
import com.company.models.*;
import com.company.repository.ReservationRepository;
import com.company.utils.Inputs;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ReservationService {
    private ReservationRepository repository = ReservationRepository.getInstance();
    private UserService userService = new UserService();
    private RoomTypeService roomTypeService = new RoomTypeService();
    private RoomService roomService = new RoomService();

    public ReservationService() throws IOException {
    }

    public void createReservation(boolean isUser, User userSearch) throws InterruptedException {
        if(userSearch!= null &&  userSearch.getUserType() == UserType.PASAJERO){
            if(repository.getReservationByUsername(userSearch.getUserName()) == null){
                ArrayList<Integer> roomsAvailables = new ArrayList<>();
                RoomType roomType = null;
                Room room = null;

                LocalDate start = selectedDate();

                System.out.print(" Cuentos dias desea quedarse? ");
                LocalDate end = start.plusDays(Inputs.inputInterger());

                do {
                    roomTypeService.showRoomTypes();
                    roomType = selectedRoomType();
                    roomsAvailables = showRoomsAvailablesByDateAndType(start, end, roomType.getRoomType());
                    if(roomsAvailables.isEmpty()) {
                        System.out.println(" No hay habitacion disponibles , para este tipo de habitacion ");
                    }

                }while (roomsAvailables.isEmpty());

                room = selectedRoom(roomsAvailables , roomType);

                repository.getReservations().add(new Reserva(userSearch.getUserName(), room.getRoomNumber(), start.toString(), end.toString()));
                saveAllReservations();
                roomService.updateRoomStatus();
            }else{
                System.out.println(" Ya posee una reserva pendiente ");
                Thread.sleep(2000);
            }

        }
    }


    public RoomType selectedRoomType() throws InterruptedException {
        int roomTypeNum;
        do {
            System.out.print("\n Seleccione un tipo de habitacion: ");
            roomTypeNum = Inputs.inputInterger();
            if (roomTypeNum < 1 || roomTypeNum > 8) {
                System.out.println("\n Ingrese una tipo de habitacion correcta!");
                Thread.sleep(3000);
            }
        }while (roomTypeNum < 1 || roomTypeNum > 8);

        return roomTypeService.getByIndex(roomTypeNum);
    }

    public LocalDate selectedDate(){
        System.out.println("\n\n Ingrese la fecha para reservar");
        int year = anio();
        int mont = month(year);
        int day = day(mont, year);
        return  LocalDate.of(year, mont, day);
    }

    public Room selectedRoom(ArrayList<Integer> roomsAvailables , RoomType roomType) throws InterruptedException {
        Room roomSearch = null;
        do {
            System.out.print("\n Numero de habitacion: ");
            int room = Inputs.inputInterger();
            if (roomsAvailables.contains(room))
                roomSearch = roomService.getByNum_TypeRoom(room, roomType);
            else {
                System.out.println("\n Ingrese una habitacion correcta!");
                Thread.sleep(3000);
            }
        } while (roomSearch == null);
        return roomSearch;
    }

    public ArrayList<Integer> showRoomsAvailablesByDateAndType(LocalDate start, LocalDate end, Type roomType){
        ArrayList<Integer> rooms = new ArrayList<>();
        for (Room aux: roomService.getAllRooms()) {
            if (aux.getRoomType() == roomType && isAvailableDate(start, end, aux.getRoomNumber())) {
                System.out.println(aux.room());
                rooms.add(aux.getRoomNumber());
            }
        }
        return rooms;
    }

    /*
    public boolean isAvailableDate(LocalDate start, LocalDate end, Integer room){
        boolean isAvailable = true;
        for (Reserva aux: roomAllReservations(room)) {
            if(aux.getRoom() == room) {
                for (int i = 0; i <= LocalDate.parse(aux.getStart()).compareTo(LocalDate.parse(aux.getEnd())); i++) {
                    if (LocalDate.parse(aux.getStart()).plusDays(i) == end.minusDays(1) || LocalDate.parse(aux.getStart()).plusDays(i) == start)
                        isAvailable = false;
                }
                if(LocalDate.parse(aux.getStart()).isAfter(start) && LocalDate.parse(aux.getEnd()).isBefore(end))
                    isAvailable = false;
            }
        }
        return isAvailable;
    }                                   PEDORRADA BY OCTA XD
    */

    public boolean isAvailableDate(LocalDate start, LocalDate end, Integer room){
        boolean isAvailable = true;
        for (Reserva aux: roomAllReservations(room)) {
            if(aux.getRoom().equals(room)){
                System.out.println(room);
                if(  ! isAvailable(start , end , LocalDate.parse(aux.getStart()) , LocalDate.parse(aux.getEnd()))){
                    isAvailable = false;
                }
            }
        }
        return isAvailable;
    }

    public  boolean isAvailable (LocalDate start , LocalDate end , LocalDate auxStart , LocalDate auxEnd ){
        return entreFechas(start,end,auxStart,auxEnd) &&
                dentroDeReserva(start,end,auxStart,auxEnd) &&
                fueraDeReserva(start,end,auxStart,auxEnd) &&
                fechasIguales(start,end,auxStart,auxEnd);
    }

    public boolean fechasIguales(LocalDate start , LocalDate end , LocalDate auxStart , LocalDate auxEnd ){
        boolean available = false;
        if( !auxStart.isEqual(start)){
            if(!auxStart.isEqual(end)){
                if(!auxEnd.isEqual(start)){
                    if(!auxEnd.isEqual(end)){
                        available = true;
                    }
                }
            }
        }
        return available;

    }
    public boolean entreFechas (LocalDate start , LocalDate end , LocalDate auxStart , LocalDate auxEnd){
        boolean available = false;
        if(!(auxStart.isBefore(start) && auxEnd.isAfter(start))){
            if(!(auxStart.isBefore(end)) && auxEnd.isAfter(end)){
                available = true;
            }
        }
        return available;
    }

    public boolean dentroDeReserva (LocalDate start , LocalDate end , LocalDate auxStart , LocalDate auxEnd ){
        boolean available = false;
        if( ! (auxStart.isBefore(start) && auxEnd.isAfter(end) )){
            available = true;
        }
        return available;
    }

    public boolean fueraDeReserva (LocalDate start , LocalDate end , LocalDate auxStart , LocalDate auxEnd ){
        boolean available = false;
        if(! (auxStart.isAfter(start) && auxEnd.isBefore(end) )){
            available = true;
        }
        return available;
    }

    public ArrayList<Reserva> roomAllReservations(Integer room){
        ArrayList<Reserva> allReservations = new ArrayList<>();
        for (Reserva aux: repository.getReservations())
            if (aux.getRoom() == room)
                allReservations.add(aux);
        return allReservations;
    }

    private int anio() {
        int anio = 0;
        boolean succefull = false;
        do{
            System.out.print("\n Ingrese año: ");
            anio = Inputs.inputInterger();
            if(anio >= LocalDate.now().getYear())
                succefull=true;
        }while (!succefull);
        return anio;
    }
    private int month(int anio) {
        int month = 0;
        boolean succefull = false;

        do{
            System.out.print(" Ingrese mes: ");
            month = Inputs.inputInterger();
            if(month == LocalDate.now().getMonthValue()){
                if(month >= LocalDate.now().getMonthValue() && month < 13){
                    succefull=true;
                }
            }
            if(month > 0 && month < 13){
                succefull=true;
            }

        }while (!succefull);
        return month;
    }

    private int day(int month , int anio) {
        int day = 0;
        boolean succefull = false;
        do{
            System.out.print(" Ingrese dia: ");
            day = Inputs.inputInterger();
            System.out.println(month);
            System.out.println(LocalDate.now().getMonthValue());
            if(anio == LocalDate.now().getYear() && month == LocalDate.now().getMonthValue()){

                if(day >= LocalDate.now().getDayOfMonth()){
                    if(day <= LocalDate.now().lengthOfMonth()) { //fecha actual hasta fin de mes
                        succefull = true;
                    }else {
                        System.out.println("El dia no puede ser superior a" + LocalDate.now().lengthOfMonth());
                    }
                }else{
                    System.out.println("El dia no puede ser anterior a hoy");
                }
            }else {
                LocalDate date = LocalDate.of(anio , month , 1);
                if(day > 0 ){
                    if(day < date.lengthOfMonth()){
                        succefull = true;
                    }else {
                        System.out.println("El dia no puede ser superior a: "  + date.lengthOfMonth());
                    }
                }else {
                    System.out.println("El dia no puede ser menor a 0");
                }//todas las fechas de un mes
            }
        }while (!succefull);
        return day;
    }

    public void saveAllReservations(){
        repository.saveAll();
    }

    public ArrayList<Reserva> getAllReservations(){
        return repository.getReservations();
    }

    public void showReservations(){
        for (Reserva aux: repository.getReservations()) {
            System.out.println(aux.toString());
        }
    }



    public void actullyReservations() {
        for (Reserva reservation : repository.getActives()) {
            if (LocalDate.parse(reservation.getEnd()).isEqual(LocalDate.now())) {
                reservation.inactive();
            }
        }
        saveAllReservations();
    }

    public void showReservationByUser(String userName){
        Reserva reserva = repository.getReservationByUsername(userName);
        if(reserva != null){
            System.out.println(reserva.toString());
        }else{
            System.out.println(" No posee reservas activas ");
        }
    }

    public void cancelReservation(String username){
        System.out.println(repository.getReservationByUsername(username).toString());
        int option ;
        boolean salir = false;
        do {
            System.out.println(" Esta por eliminar la reserva. ¿Esta seguro?.");
            System.out.println(" 1. Si");
            System.out.println(" 2. No");
            option = Inputs.inputInterger();
            switch (option) {
                case 1 -> {
                    System.out.println(repository.cancelReservation(username).toString());
                    salir = true;
                }
                case 2 -> salir = true;
                default -> System.out.println(" Ingrese una opcion correcta");
            }
        }while (!salir);

    }
}
