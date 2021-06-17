package com.company.controller;

import com.company.models.User;
import com.company.models.UserType;
import com.company.services.UserService;
import com.company.utils.Inputs;

import java.io.IOException;

public class Session {

    private User user = new User();
    private UserService userService = new UserService();

    public Session() throws IOException {
    }

    public User mainMenu() throws InterruptedException {
        int option;
        User requestUser = null;
        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("" +
                    "\n1. Iniciar sesion."
                    + "\n2. Salir"
            );
            option = Inputs.inputInterger();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

            switch (option) {
                case 1:
                    requestUser = signIn();
                    if(requestUser != null){
                        option = 2;
                    }
                    break;
                case 2:
                    //This case does nothing :D, it serves to close the program.
                    requestUser = null;
                    break;
                case 99:
                    userService.createUser(true);
                    break;
                default:
                    System.out.println("Ingrese una opcion correta!");
                    Thread.sleep(3000);
            }
        }while (option != 2);

        return requestUser;
    }

    private User signIn() throws InterruptedException {
        System.out.print(" Ingrese el nombre de usuario: ");
        String userName = Inputs.inputString();
        User requestedUser = userService.searchByUserName(userName);

        if (requestedUser != null) {
            System.out.print(" Ingrese la contraseña: ");
            String inputPassword = Inputs.inputString();

            if (!inputPassword.equals(requestedUser.getPassword())) {
                System.out.println(" Contraseña Incorrecta!");
                requestedUser = null;
                Thread.sleep(3000);
            }
        } else {
            System.out.println("\n El usuario no existe!");
            Thread.sleep(3000);
        }
        return requestedUser;
    }

}
