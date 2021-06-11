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

    public void mainMenu() throws InterruptedException {
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
                    reservationService.createReservation(true, user);
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
