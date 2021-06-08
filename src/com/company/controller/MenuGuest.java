package com.company.controller;

import com.company.models.User;
import com.company.services.ReservationService;
import com.company.services.RoomService;
import com.company.utils.Inputs;

import java.io.IOException;

public class MenuGuest {
    private User user;
    RoomService roomService = new RoomService();
    ReservationService reservationService = new ReservationService();

    public MenuGuest(User user) throws IOException {
        this.user = user;
    }

    public void mainMenu(){
        int option;
        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println(" "+user.getUserType());
            System.out.println("\n Bienvenido " + user.getUserName()
                    + "\n\n1. Realizar reserva"
                    + "\n2. Salir"
            );

            option = new Inputs().inputInterger();

            switch (option){
                case 1:
                    System.out.println("\nIngresa numero de habitacion");
                    Integer roomNumber = new Inputs().inputInterger();
                    boolean isAvailable = roomService.chekAvailability(roomNumber);
                    if (isAvailable){
                        System.out.print(" Ingrese el nombre: ");
                        user.setUserName(new Inputs().inputString());

                        System.out.print("\n Ingrese el apellido: ");
                        user.setLastName(new Inputs().inputString());

                        System.out.print("\n Ingrese el DNI: ");
                        user.setDNI(new Inputs().inputString());

                        reservationService.createReservation();
                    }else {
                        System.out.println("\nLa habitacion no se encuentra disponible");
                    }
                    break;
                case 2:
                    //This case does nothing :D, it serves to close the program.
                    break;
                default:
                    System.out.println("Ingrese una opcion correta!");
                    option = 1;
            }
        }while (option>0 && option<2);
    }
}
