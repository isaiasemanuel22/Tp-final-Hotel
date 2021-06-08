package com.company.controller;

import com.company.models.User;

public class MenuRecepcionista {
    private User user;
    public MenuRecepcionista(User user) {
        this.user = new User();
    }

    public void mainMenu() {
        System.out.println(" RECEPCIONISTA");
        System.out.println(" Bienvenido " + user.getUserName());
    }
}
