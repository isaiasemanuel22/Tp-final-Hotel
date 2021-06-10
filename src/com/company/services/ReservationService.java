package com.company.services;

import com.company.controller.Menu;
import com.company.models.*;
import com.company.repository.ReservationRepository;
import com.company.utils.Inputs;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ReservationService {
    private ReservationRepository repository = ReservationRepository.getInstance();
    private UserService userService = new UserService();
    private RoomTypeService roomTypeService = new RoomTypeService();
    private RoomService roomService = new RoomService();

    public ReservationService() throws IOException {
    }

    public void createReservation() throws InterruptedException {
        System.out.print(" Nombre del pasajero: ");
        User useSearch = userService.searchByUserName(Inputs.inputString());
        if(useSearch!= null &&  useSearch.getUserType() == UserType.PASAJERO){
            roomTypeService.showRoomTypes();
            RoomType roomType = null;
            int roomTypeNum;
            do {
                System.out.print("\n Seleccione un tipo de habitacion: ");
                roomTypeNum = Inputs.inputInterger();
                if (roomTypeNum < 1 || roomTypeNum > 8) {
                    System.out.println("\n Ingrese una tipo de habitacion correcta!");
                    Thread.sleep(3000);
                }
            }while (roomTypeNum < 1 || roomTypeNum > 8);

            System.out.println(" Ingrese la fecha para reservar");
            int year = anio();
            int mont = month(year);
            int day = day(mont, year);
            LocalDate start = LocalDate.of(year, mont, day);
            System.out.println(" Cuentos dias desea quedarse?: ");
            LocalDate end = start.plusDays(Inputs.inputInterger());
            roomType = roomTypeService.getByIndex(roomTypeNum);

            ArrayList<Integer> roomsAvailables = roomService.showRoomsAvailablesByDateAndType(start, end, roomType.getRoomType());

            Room roomSearch = null;
            do{
                System.out.print("\n Numero de habitacion: ");
                int room = Inputs.inputInterger();
                if (roomsAvailables.contains(room))
                    roomSearch = roomService.getByNum_TypeRoom(room, roomType);
                else  {
                    System.out.println("\n Ingrese una habitacion correcta!");
                    Thread.sleep(3000);
                }
            }while (roomSearch == null);

            repository.getReservations().add(new Reserva(useSearch.getUserName(), roomSearch.getRoomNumber(), start, end));
        }
    }

    public int getDays(Reserva reserva){
        int days=1;
        LocalDate star = reserva.getStart();
        LocalDate end = reserva.getEnd();
        while(star != end){
            star = star.plusDays(1);
            days++;
        }
        return days;
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
            System.out.print("Ingrese año: ");
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
            System.out.println("Ingrese mes: ");
            month = Inputs.inputInterger();
            if(anio == LocalDate.now().getYear()){
                if(month >= LocalDate.now().getMonthValue() + 1 && month < 13){
                    succefull=true;
                }
            }
            if(month > 0 && month < 13){
                succefull=true;
            }

        }while (!succefull);
        return month - 1;
    }

    private int day(int month , int anio) {
        int day = 0;
        boolean succefull = false;
        do{
            System.out.print("Ingrese dia: ");
            day = Inputs.inputInterger();
            if(anio == LocalDate.now().getYear() && month == LocalDate.now().getMonthValue()){
                if(day >= LocalDate.now().getDayOfMonth() && day <= LocalDate.now().lengthOfMonth()){ //fecha actual hasta fin de mes
                    succefull = true;
                }
            }else {
                LocalDate date = LocalDate.of(anio , month , 1);
                if(day > 0 && day < date.lengthOfMonth()){  //todas las fechas de un mes
                    succefull=true;
                }
            }
        }while (!succefull);
        return day;
    }
}
