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
                    + "\n 1. Realizar reserva."
                    + "\n 2. ver mi reserva."
                    + "\n 3. Salir."
            );

            option = Inputs.inputInterger();

            switch (option){
                case 1:
                    reservationService.createReservation(true, user);
                    break;
                case 2:
                    reservationService.showReservationByUser(user.getUserName());
                    break;
                case 3:
                    reservationService.cancelReservation(user.getUserName());
                    break;
                case 4:
                    //salir
                    break;
                default:
                    System.out.println("Ingrese una opcion correta!");
                    Thread.sleep(2000);
                    break;

            }
        }while (option != 4);
    }
}
