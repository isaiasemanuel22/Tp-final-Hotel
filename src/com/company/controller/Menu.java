package com.company.controller;

import com.company.models.Reservation;
import com.company.models.RoomType;
import com.company.models.User;
import com.company.models.UserProfile;
import com.company.utils.Inputs;
import com.company.services.RoomService;
import com.company.services.RoomTypeService;
import com.company.services.UserService;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private UserService userService = new UserService();
    private RoomTypeService roomTypeService = new RoomTypeService();
    private RoomService roomService = new RoomService();

    public Menu() throws IOException {
    }

    public void initProgram() throws IOException, InterruptedException { login(); }

    public void login() throws IOException, InterruptedException {
        int option;
        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\n1. Iniciar sesion."
                    +"\n2. Registrarse."
                    +"\n3. Salir"
            );
            option = new Inputs().inputInterger();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");

            switch (option) {
                case 1:
                    System.out.print(" Ingrese el nombre de usuario: ");
                    String userName = new Inputs().inputString();
                    Long userId = userService.searchUser(userName);

                    if (userId != 0) {
                        System.out.print("\n Ingrese la contraseña: ");
                        String password = new Inputs().inputString();

                        if (password.equals(userService.getUserByID(userId).getPassword())){
                            switch (userService.getUserByID(userId).getUserProfile()){
                                case Administrador:
                                    administrador(userService.getUserByID(userId));
                                    break;
                                case Pasajero:
                                    pasajero(userService.getUserByID(userId));
                                    break;
                                case Recepcionista:
                                    recepcionista(userService.getUserByID(userId));
                                    break;
                            }
                        }
                        else{
                            System.out.println("\n Contraseña Incorrecta!");
                            Thread.sleep(3000);
                            option=0;
                        }
                    }
                    else {
                        System.out.println("\n El usuario no existe!");
                        Thread.sleep(3000);
                        option=0;
                    }
                case 2:
                    createUser(false);
                    break;
                case 3:
                    //This case does nothing :D, it serves to close the program.
                    break;
                default:
                    System.out.println("Ingrese una opcion correta!");
                    Thread.sleep(3000);
                    option = 1;
            }
        }while (option>2 || option <1);
    }

    private void administrador(User user) throws IOException, InterruptedException {
        int option;
        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("ADMINISTRADOR");
            System.out.println("\n Bienvenido " + user.getName() + " " + user.getLastName()
                    + "\n\n1. Mostrar usuarios,"
                    + "\n2. Crear usuario."
                    + "\n3. Modificar Usuario."
                    + "\n4. Buscar usuario."
                    + "\n5. Salir."
            );

            option = new Inputs().inputInterger();
            switch (option){
                case 1:
                    userService.showUsers();
                    break;
                case 2:
                    createUser(true);
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    searchUser();
                    break;
                case 5:
                    //This case does nothing :D, it serves to close the program.
                    break;
                default:
                    System.out.println("Ingrese una opcion correta!");
                    Thread.sleep(3000);
                    option = 1;
            }
        }while (option>0 && option<5);
    }

    private void recepcionista(User user){
        System.out.println(" RECEPCINISTA");
        System.out.println(" Bienvenido " + user.getName()+" "+user.getLastName());

    }
    private void pasajero(User user){
        System.out.println("Pasajero");
        System.out.println(" Bienvenido " + user.getName()+" "+user.getLastName());
    }

    public void createUser(boolean accessRermission) throws IOException, InterruptedException {
        User user = new User();
        if (accessRermission){
            int option;
            do {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                        + "1. " + UserProfile.Administrador
                        + "\n2. " + UserProfile.Pasajero
                        + "\n3. " + UserProfile.Recepcionista
                        + "\n Elige que tipo de usario: "
                );

                option = new Inputs().inputInterger();
                switch (option) {
                    case 1:
                        user.setUserProfile(UserProfile.Administrador);
                        break;
                    case 2:
                        user.setUserProfile(UserProfile.Pasajero);
                        break;
                    case 3:
                        user.setUserProfile(UserProfile.Recepcionista);
                        break;
                    default:
                        System.out.println("Ingrese una opcion correta!");
                        Thread.sleep(3000);
                        break;
                }
            } while (option > 3 || option < 1);
        }
        else
            user.setUserProfile(UserProfile.Pasajero);

        System.out.print(" Ingrese el nombre: ");
        user.setName(new Inputs().inputString());

        System.out.print("\n Ingrese el apellido: ");
        user.setLastName(new Inputs().inputString());

        System.out.print("\n Ingrese el DNI: ");
        user.setDNI(new Inputs().inputString());

        System.out.print("\n Ingrese la direccion: ");
        user.setAdress(new Inputs().inputString());

        System.out.print("\n Ingrese el telefono: ");
        user.setPhone(new Inputs().inputString());

        System.out.print("\n Ingrese el email: ");
        user.setEmail(new Inputs().inputString());

        System.out.print("\n Ingrese el genero: ");
        user.setGenre(new Inputs().inputString());

        System.out.print("\n Ingrese el nombre de usuario: ");
        user.setUserId(new Inputs().inputString());

        System.out.print("\n Ingrese la contraseña: ");
        user.setPassword(new Inputs().inputString());
        userService.addUser(user);
    }

    public void showUsers() throws IOException {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        new UserService().showUsers();
    }

    public void updateUser() throws IOException, InterruptedException {
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

    public void searchUser() throws IOException {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\n\n Ingrese la ID del usuario: ");
        userService.showUserDetails(userService.getUserByID(new Inputs().inputInterger().longValue()));
    }
    
}
