package com.company.controller;

import com.company.models.User;
import com.company.models.UserType;
import com.company.services.UserService;
import com.company.utils.Inputs;

public class MenuAdmin {

    private User user;
    private UserService userService = new UserService();

    public MenuAdmin(User user) {
        this.user = user;
    }

    public void mainMenu(){
        int option;
        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("ADMINISTRADOR");
            System.out.println("\n Bienvenido " + user.getUserName()
                    + "\n\t1. Administrar usuarios"
            );

            option = new Inputs().inputInterger();
            switch (option){
                case 1:
                    usersMenu();
                default:
                    System.out.println("Ingrese una opcion correta!");
                    option = 1;
            }
        }while (option>0 && option<5);
    }

    public void usersMenu(){

        int option;

        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("ADMINISTRADOR");
            System.out.println("\n Bienvenido " + user.getUserName()
                    + "\n\n1. Administrar usuarios "
                    + "\n2. Crear usuario."
                    + "\n3. Modificar Usuario."
                    + "\n4. Buscar usuario."
                    + "\n5. Salir."
            );

            option = new Inputs().inputInterger();
            switch (option){
                case 1:
                    showUsers();
                    break;
                case 2:
                    createUser();
                    break;
                case 3:
                    //updateUser();
                    break;
                case 4:
                    searchUser();
                    break;
                case 5:
                    //This case does nothing :D, it serves to close the program.
                    break;
                default:
                    System.out.println("Ingrese una opcion correta!");
                    option = 1;
            }
        }while (option>0 && option<5);
    }

    public void createUser(){

        UserService service = new UserService();
        User user = new User();

        int option;
        do {
            System.out.println("\n\n\n"
                    + "1. " + UserType.ADMIN
                    + "\n2. " + UserType.RECEPCIONISTA
                    + "\n3. " + UserType.PASAJERO
                    + "\n Elige que tipo de usario: "
            );

            option = new Inputs().inputInterger();
            switch (option) {
                case 1:
                    user.setUserType(UserType.ADMIN);
                    break;
                case 2:
                    user.setUserType(UserType.RECEPCIONISTA);
                    break;
                case 3:
                    user.setUserType(UserType.PASAJERO);
                    break;
                default:
                    System.out.println("Ingrese una opcion correta!");
                    break;
            }
        } while (option > 3 || option < 1);

        System.out.print("\n Ingrese el nombre de usuario: ");
        user.setUserId(new Inputs().inputString());

        System.out.print("\n Ingrese la contraseña: ");
        user.setPassword(new Inputs().inputString());

        service.addUser(user);
    }

    public void showUsers() {

    }

    public void updateUser() throws InterruptedException {
        int option;
        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
            System.out.print("\n\n Ingrese la ID del usuario a modificar: ");
            User userToUpdate = userService.getUserByID(new Inputs().inputInterger().longValue());
            userService.showUserDetails(userToUpdate);
            System.out.print(" Ingrese el campo que quiera modificar: ");
            option =new Inputs().inputInterger();
            if(option<1 || option>9) {
                System.out.println("\n Elija una opcion correcta!");
                Thread.sleep(3000);
            }
        }while (option<1 || option>9);
    }

    public void searchUser()  {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\n\n Ingrese la ID del usuario: ");
        userService.showUserDetails(userService.getUserByID(new Inputs().inputInterger().longValue()));
    }
}
