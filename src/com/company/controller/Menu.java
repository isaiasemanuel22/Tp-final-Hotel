package com.company.controller;
import com.company.models.User;
import com.company.services.ReservationService;
import com.company.services.RoomService;
import com.company.services.UserService;

import java.io.IOException;
public class Menu {
    private UserService userService = new UserService();
    private RoomService roomService = new RoomService();
    private ReservationService reservationService = new ReservationService();
    public Menu() throws IOException {
    }

    public void initProgram() throws IOException, InterruptedException {
        User userRequest = new User();
        roomService.updateRoomStatus();
        reservationService.actullyReservations();
        do {
            Session session = new Session();
            userRequest = session.mainMenu();
            if(userRequest != null) {
                if (!userRequest.isBanned())
                    view(userRequest);
                else {
                    System.out.println("\n El usuario esta baneado!");
                    Thread.sleep(3000);
                }
            }
        }while (userRequest != null);

    }

    public void view(User user) throws IOException, InterruptedException {
        if(user!=null) {
            switch (user.getUserType()) {
                case ADMIN -> {
                    MenuAdmin menuAdmin = new MenuAdmin(user);
                    menuAdmin.mainMenu(user);
                }
                case RECEPCIONISTA -> {
                    MenuRecepcionista menu = new MenuRecepcionista(user);
                    menu.mainMenu();
                }
                case PASAJERO -> {
                    MenuGuest menu = new MenuGuest(user);
                    menu.mainMenu();
                }
            }
        }
    }
}
