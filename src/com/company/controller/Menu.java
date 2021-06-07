package com.company.controller;

import com.company.models.User;

public class Menu {

    public Menu() {
    }

    public void init(User user){
        switch (user.getUserType()){
            case ADMIN -> {
                MenuAdmin menuAdmin = new MenuAdmin(user);
                menuAdmin.mainMenu();
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
