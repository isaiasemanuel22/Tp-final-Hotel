package com.company.controller;

import com.company.models.User;
import com.company.services.UserService;
import com.company.utils.Inputs;

public class Session {

    private User user = new User();
    private UserService userService = new UserService();

    public User mainMenu() {
        int option;
        do {
            System.out.println("\n\n\n");
            System.out.println("" +
                    "\n1. Iniciar sesion."
                    + "\n2. Registrarse"
                    + "\n3. Salir"
            );
            option = new Inputs().inputInterger();
            System.out.println("\n\n\n");

            switch (option) {
                case 1:
                    return signIn();
                case 2:
                    return createUser();
                case 3:
                    //This case does nothing :D, it serves to close the program.
                    break;
                default:
                    System.out.println("Ingrese una opcion correta!");
                    option = 1;
            }
        } while (option > 2 || option < 1);
        return null;
    }

    private User createUser() {
        System.out.print(" Ingrese el nombre: ");
        user.setUserName(new Inputs().inputString());

        System.out.print("\n Ingrese el apellido: ");
        user.setLastName(new Inputs().inputString());

        System.out.print("\n Ingrese el DNI: ");
        user.setDNI(new Inputs().inputString());

        try {
            userService.register(user);
            System.out.println("El usuario se registro correctamente, por favor inicie sesion");
        } catch (Exception e) {
            System.out.println("Hubo un problema al registar el usuario por favor intente mas tarde.");
        }
        return null;
    }

    private User signIn() {

        System.out.print(" Ingrese el nombre de usuario: ");
        String userName = new Inputs().inputString();
        User requestedUser = userService.searchByUserName(userName);

        if (requestedUser != null) {
            System.out.print("\n Ingrese la contraseña: ");
            String inputPassword = new Inputs().inputString();

            if (inputPassword.equals(requestedUser.getPassword())) {
                return requestedUser;
            } else {
                System.out.println("\n Contraseña Incorrecta!");
                return null;
            }
        } else {
            System.out.println("\n El usuario no existe!");
        }
        return null;
    }

    public void create() {

        User newUser = new User();

        Inputs<String> newUserName = new Inputs<String>();
        newUserName.input("Ingrese nombre de usuario", newUserName);


    }
}
