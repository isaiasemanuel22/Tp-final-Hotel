package com.company.controller;

import com.company.models.User;
import com.company.services.RoomService;
import com.company.services.UserService;
import com.company.utils.Inputs;

import java.io.IOException;

public class MenuRecepcionista {
    private User user;
    private UserService userService = new UserService();
    private RoomService roomService = new RoomService();
    public MenuRecepcionista(User user) throws IOException {
        this.user = new User();
    }

    public void mainMenu() throws InterruptedException {
        int option;
        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("ADMINISTRADOR");
            System.out.println("\n Bienvenido " + user.getName() + " " + user.getLastName()
                    + "\n\n 1. Mostrar Pasajeros."
                    + "\n 2. Crear Pasajero."
                    + "\n 3. Modificar Pasajero"
                    + "\n 4. Asignar Pasajero a una habitacion."
                    + "\n 5. Dar de baja un pasajero."
                    + "\n 6. Dar de alta un pasajero."
                    + "\n 7. Cerrar sesion."
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
                    roomXpassenger();
                case 7:
                    //This case does nothing :D, it serves to close the program.
                    break;
                default:
                    System.out.println("Ingrese una opcion correta!");
                    Thread.sleep(2000);
            }
        } while (option > 0 && option < 7);
    }

    public void roomXpassenger(){
        roomService.showAvailableRooms();
    }



}

