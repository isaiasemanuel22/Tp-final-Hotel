package com.company.controller;

import com.company.models.User;
import com.company.services.UserService;
import com.company.utils.Inputs;

import java.io.IOException;

public class Session {

    private User user;
    private UserService userService = new UserService();

    public Session() throws IOException {
    }

    public User mainMenu(){
        int option;
        do {
            System.out.println("\n\n\n");
            System.out.println("" +
                    "\n1. Iniciar sesion."
                    +"\n2. Registrarse"
                    +"\n3. Salir"
            );
            option = Inputs.inputInterger();
            System.out.println("\n\n\n");

            switch (option) {
                case 1:
                    return signIn();
                case 2:

                    //return createUser(false);
                    break;
                case 3:
                    //This case does nothing :D, it serves to close the program.
                    break;
                default:
                    System.out.println("Ingrese una opcion correta!");
                    option = 1;
            }
        }while (option != 3);

        return null;
    }

    private User signIn(){

        System.out.print(" Ingrese el nombre de usuario: ");
        String userName = Inputs.inputString();
        User requestedUser = userService.searchByUserName(userName);

        if (requestedUser != null) {
            System.out.print("\n Ingrese la contraseña: ");
            String inputPassword = Inputs.inputString();

            if (inputPassword.equals(requestedUser.getPassword())) {
                return requestedUser;
            } else {
                System.out.println("\n Contraseña Incorrecta!");
                return null;
            }
        }
        else {
            System.out.println("\n El usuario no existe!");
        }
        return null;
    }

    public void create(){

        User newUser = new User();

        Inputs<String> newUserName = new Inputs<String>();
        newUserName.input("Ingrese nombre de usuario",newUserName);


    }
}
