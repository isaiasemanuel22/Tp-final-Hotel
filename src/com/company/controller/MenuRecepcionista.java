package com.company.controller;

import com.company.models.Room;
import com.company.models.RoomType;
import com.company.models.User;
import com.company.models.UserType;
import com.company.services.RoomService;
import com.company.services.RoomTypeService;
import com.company.services.UserService;
import com.company.utils.Inputs;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class MenuRecepcionista {
    private User user;
    private UserService userService = new UserService();
    private RoomService roomService = new RoomService();
    private RoomTypeService roomTypeService = new RoomTypeService();
    public MenuRecepcionista(User user) throws IOException {
        this.user = user;
    }

    public void mainMenu() throws InterruptedException {
        int option;
        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("RECEPCIONISTA");
            System.out.println("\n Bienvenido " + user.getName() + " " + user.getLastName()
                    + "\n\n 1. Mostrar Pasajeros."
                    + "\n 2. Crear Pasajero."
                    + "\n 3. Modificar Pasajero"
                    + "\n 4. Habitaciones."
                    + "\n 5. Dar de baja un pasajero"
                    + "\n 6. Dar de alta un pasajero."
                    + "\n 7. Mostrar Pasajeros Activos."
                    + "\n 8. Cerrar sesion."
            );

            option = Inputs.inputInterger();
            switch (option) {
                case 1:
                    userService.passenger();
                    break;
                case 2:
                    userService.createUser(false);
                    break;
                case 3:
                    updatePassenger();
                    break;
                case 4:
                    menuRooms();
                case 5:
                    bannedPassenger(true);
                    break;
                case 6:
                    bannedPassenger(false);
                    break;
                case 7:
                    userService.passengerActivos();
                    break;
                case 8:
                    //This case does nothing :D, it serves to close the program.
                    break;
                default:
                    System.out.println("Ingrese una opcion correta!");
                    Thread.sleep(2000);
            }
        } while (option > 0 && option < 8);
    }


    public void menuRooms() throws InterruptedException {
        int option;
        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("HABITACIONES");
            System.out.println(
                    "\n\n 1. Asignar Pasajeros."
                    + "\n 2. Liberar Habitacion por Usuario."
                    + "\n 3. Liberar Habitacion por numero de habitacion."
                    + "\n 4. Ver Habitaciones libres."
                    + "\n 5. Ver todas las habitaciones."
                    + "\n 6. Volver."
            );

            option = Inputs.inputInterger();
            switch (option) {
                case 1:
                    createReservation();
                    break;
                case 2:
                    vacateRoomByUser();
                    break;
                case 3:
                    vacateRoomByRoom();
                    break;
                case 4:
                    roomService.showAvailableRooms();
                    break;
                case 5:
                    roomService.showRooms();
                    break;
                case 6:
                    //This case does nothing :D, it serves to close the program.
                    break;
                default:
                    System.out.println("Ingrese una opcion correta!");
                    Thread.sleep(2000);
            }
        } while (option != 6);
    }

    public void roomXpassenger(){
        System.out.println("Nombre del pasajero: ");
        User useSearch = userService.searchByUserName(Inputs.inputString());
        if( useSearch!= null &&  useSearch.getUserType() == UserType.PASAJERO){
            roomService.showAvailableRooms();
            System.out.println("Indique la habitacion deseada: ");
            int room = Inputs.inputInterger();
            if(roomService.chekAvailability(room)){
                userService.roomXPassenger(room , useSearch);
                roomService.occupyRoom(room);
            }
        }
    }

    public void updatePassenger() throws InterruptedException {
            int option = 0;
            do {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
                System.out.print("\n\n Ingrese el nombre de usuario a modificar: ");
                User useSearch = userService.searchByUserName(Inputs.inputString());
                if( useSearch.getUserType() == UserType.PASAJERO) {
                    userService.showUserDetails(useSearch);
                    System.out.print("0. salir");
                    System.out.print(" Ingrese el campo que quiera modificar: ");
                    option = Inputs.inputInterger();       
                    if(option<0 || option>10) {
                        System.out.println("\n Elija una opcion correcta!");
                        Thread.sleep(3000);
                    }
                    else
                        userService.updateUser(useSearch, option);
                }

            }while (option != 0);

    }

    public void vacateRoomByUser(){
        System.out.println("Nombre del pasajero ");
        User useSearch = userService.searchByUserName(Inputs.inputString());
        if(useSearch != null &&  useSearch.getUserType() == UserType.PASAJERO){
            int room = useSearch.getRoomID();
            if(!roomService.chekAvailability(room)){
                useSearch.setRoomID(0);
                userService.vacate(useSearch);
                roomService.vacate(room);
            }
        }
    }

    public void bannedPassenger(boolean action){
        User useSearch = userService.searchByUserName(Inputs.inputString());
        if(useSearch!= null && useSearch.getUserType() == UserType.PASAJERO){
            if(action){
                useSearch.ban();
            }
            else{
                useSearch.unban();
            }
            userService.bannedPassenger(useSearch);
        }
    }

    public void vacateRoomByRoom(){
        System.out.println("Numero de habitacion: ");
        Room roomSearch = roomService.getRoom(Inputs.inputInterger());
        if(roomSearch!= null &&  !roomSearch.isAvailable()){
            User usersearch = userService.getUserByRoom(roomSearch.getRoomNumber());
            usersearch.setRoomID(0);
            userService.vacate(usersearch);
            roomService.vacate(roomSearch.getRoomNumber());
        }
    }

    public void createReservation(){
        System.out.println("Nombre del pasajero: ");
        User useSearch = userService.searchByUserName(Inputs.inputString());
        if(useSearch!= null &&  useSearch.getUserType() == UserType.PASAJERO){
            roomTypeService.showRoomTypes();
            System.out.println("Seleccione un tipo de habitacion: ");
            RoomType roomType = roomTypeService.getByIndex(Inputs.inputInterger());
            roomService.showByTypeRoom(roomType);
            Room roomSearch = null;
            int room = 0;
            do{
                System.out.println("Numero de habitacion: ");
                room = Inputs.inputInterger();
                roomSearch = roomService.getByNum_TypeRoom(room ,roomType);
                if(roomSearch == null){
                    System.out.println("Ingrese una habitacion correspondiente");
                    System.out.println("Enter para continuar / 0 para salir");
                    room = Inputs.inputInterger();
                }
            }while (roomSearch == null || room != 0);
            if(room != 0) {
                System.out.println("Ingrese la fecha para reservar");
                int year = anio();
                int mont = month(year);
                int day = day(mont, year);

                LocalDate start = LocalDate.of(year, mont, day);

                System.out.println("Cuentos dias desea quedarse?: ");

                LocalDate end = start.plusDays(Inputs.inputInterger());

            }
        }
    }

    public int anio() {
        int anio = 0;
        boolean succefull = false;
        do{
            System.out.println("Ingrese anio ");
            anio = Inputs.inputInterger();
            if(anio >= LocalDate.now().getYear()){
                succefull=true;
            }

        }while (!succefull);
        return anio;
    }
    public int month(int anio) {
        int month = 0;
        boolean succefull = false;

        do{
            System.out.println("Ingrese mes ");
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

    public int day(int month , int anio) {
        int day = 0;
        boolean succefull = false;
        do{
            System.out.println("Ingrese mes ");
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

