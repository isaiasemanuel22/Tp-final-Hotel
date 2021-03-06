package com.company.controller;

import com.company.models.Room;
import com.company.models.RoomType;
import com.company.models.User;
import com.company.models.UserType;
import com.company.services.ReservationService;
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
    private ReservationService reservationService = new ReservationService();
    private MenuAdmin menuAdmin = new MenuAdmin();
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
                    break;
                case 5:
                    menuAdmin.banUser();
                    break;
                case 6:
                    menuAdmin.unbanUser();
                    break;
                case 7:
                    //This case does nothing :D, it serves to close the program.
                    break;
                default:
                    System.out.println("Ingrese una opcion correta!");
                    Thread.sleep(2000);
            }
        } while (option > 0 && option < 7);
    }


    public void menuRooms() throws InterruptedException {
        int option;
        do {
            System.out.println("\n\n\n\n\n\n");
            System.out.println("HABITACIONES");
            System.out.println(
                    "\n\n 1. Asignar Pasajeros."
                    + "\n 2. Liberar Habitacion por Usuario."
                    + "\n 3. Liberar Habitacion por numero de habitacion."
                    + "\n 4. Ver Habitaciones libres."
                    + "\n 5. Ver Habitaciones ocupadas."
                    + "\n 6. Ver todas las habitaciones."
                    + "\n 7. Ver reservas."
                    + "\n 8. Volver."
            );

            option = Inputs.inputInterger();
            switch (option) {
                case 1:
                    System.out.print(" Ingrese el nombre de usuario del pasajero: ");
                    User userSearch = userService.searchByUserName(Inputs.inputString());
                    reservationService.createReservation(false, userSearch);
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
                    roomService.showUnavailableRooms();
                    break;
                case 6:
                    roomService.showRooms();
                    break;
                case 7:
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                    reservationService.showReservations();
                    System.out.println("\n\n");
                    break;
                case 8:
                    //This case does nothing :D, it serves to close the program.
                    break;
                default:
                    System.out.println("Ingrese una opcion correta!");
                    Thread.sleep(2000);
            }
        } while (option != 8);
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

    public void vacateRoomByRoom(){
        System.out.print(" Numero de habitacion: ");
        Room roomSearch = roomService.getRoom(Inputs.inputInterger());
        if(roomSearch!= null &&  !roomSearch.isAvailable()){
            User usersearch = userService.getUserByRoom(roomSearch.getRoomNumber());
            userService.vacate(usersearch);
            roomService.vacate(roomSearch.getRoomNumber());
        }
    }
}

