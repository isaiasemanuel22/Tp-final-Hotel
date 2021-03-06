package com.company.controller;

import com.company.models.User;
import com.company.models.UserType;
import com.company.services.UserService;
import com.company.utils.Inputs;

import java.io.IOException;

public class MenuAdmin {

    private User user;
    private UserService userService = new UserService();

    public MenuAdmin(User user) throws IOException {
        this.user = user;
    }

    public MenuAdmin() throws IOException {

    }

    public void mainMenu (User user) throws IOException, InterruptedException {
        int option;
        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("ADMINISTRADOR");
            System.out.println("\n Bienvenido " + user.getName() + " " + user.getLastName()
                    + "\n\n 1. Mostrar usuarios."
                    + "\n 2. Crear usuario."
                    + "\n 3. Modificar Usuario."
                    + "\n 4. Buscar usuario."
                    + "\n 5. Dar de baja un usuario."
                    + "\n 6. Dar de alta un usuario."
                    + "\n 7. Habitaciones."
                    + "\n 8. Cerrar sesion."
            );

            option = Inputs.inputInterger();
            switch (option) {
                case 1:
                    userService.showUsers();
                    break;
                case 2:
                    userService.createUser(true);
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    searchUser();
                    break;
                case 5:
                    banUser();
                    break;
                case 6:
                    unbanUser();
                    break;
                case 7:
                    new MenuRecepcionista(user).menuRooms();
                    break;
                case 8:
                    //This case does nothing :D, it serves to close the program.
                    break;
                default:
                    System.out.println("Ingrese una opcion correta!");
                    Thread.sleep(2000);
                    break;
            }
            userService.saveAll();
        } while (option != 8);
    }

    public void updateUser() throws InterruptedException, IOException {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\n\n Ingrese el nombre de usuario a modificar: ");
        User userToUpdate = userService.searchByUserName(Inputs.inputString());

        if(userToUpdate != null) {
            int option;
            do {
                userService.showUserDetails(userToUpdate);
                System.out.println(" 0. salir");
                System.out.print(" Ingrese el campo que quiera modificar: ");
                option = Inputs.inputInterger();

                if (option < 0 || option > 10) {
                    System.out.println("\n Elija una opcion correcta!");
                    Thread.sleep(3000);
                } else {
                    userService.updateUser(userToUpdate, option);
                    option = 0;
                }
            } while (option != 0);
        }
        else {
            System.out.println("\n El usuario no existe! Por favor ingrese uno nuevamente.");
            Thread.sleep(3000);
        }
    }

    public void searchUser() throws IOException, InterruptedException {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\n\n Ingrese la nombre de usuario: ");
        User userToShow = userService.searchByUserName(Inputs.inputString());
        if(userToShow != null){
            userService.showUserDetails(userToShow);
        }
        else
            System.out.println(" El usuario no existe");
        Thread.sleep(3000);
    }

    public void banUser() throws InterruptedException {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\n\n Ingrese el nombre de usuario: ");
        User userToBan = userService.searchByUserName(Inputs.inputString());
        if(userToBan != null){
            System.out.println(" El usuario a sido dado de baja");
            userToBan.ban();
        }
        else
            System.out.println(" El usuario no existe");
        Thread.sleep(3000);
    }

    public void unbanUser() throws InterruptedException {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\n\n Ingrese el nombre de usuario: ");
        User userToBan = userService.searchByUserName(Inputs.inputString());
        if(userToBan != null){
            System.out.println(" El usuario a sido dado de alta");
            userToBan.unban();
        }
        else
            System.out.println(" El usuario no existe");
        Thread.sleep(3000);
    }
}
