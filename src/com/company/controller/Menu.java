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

    public void initProgram() throws IOException { login(); }

    public void login() throws IOException {
        int option;
        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\n1. Iniciar sesion."
                    +"\n2. Salir"
            );
            option = Inputs.inputInterger();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");

            switch (option) {
                case 1 -> {
                    System.out.print(" Ingrese el nombre de usuario: ");
                    String userName = Inputs.inputString();
                    User user = userService.searchUser(userName);
                    if (user != null) {
                        System.out.print("\n Ingrese la contraseña: ");
                        String password = Inputs.inputString();

                        if (password.equals(user.getPassword())) {

                            switch (user.getUserProfile()) {
                                case Administrador -> administrador(user);
                                case Pasajero -> pasajero(user);
                                case Recepcionista -> recepcionista(user);
                            }
                        } else {
                            System.out.println("\n Contraseña Incorrecta! Presione cualquier tecla para continuar" + new Scanner(System.in).nextLine());
                            option = 0;
                        }
                    } else {
                        System.out.println("\n El usuario no existe! Presione cualquier tecla para continuar" + new Scanner(System.in).nextLine());
                        option = 0;
                    }
                }
                case 2 -> System.out.println("Saliendo...");
                case 9 -> createUser(true);
                default -> {
                    System.out.println("Ingrese una opcion correta! Presione cualquier tecla para continuar" + new Scanner(System.in).nextLine());
                    option = 1;
                }
            }
        }while (option != 3);
    }

    private void administrador(User user) throws IOException {
        int option;
        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("ADMINISTRADOR");
            System.out.println("\n Bienvenido " + user.getName() + " " + user.getLastName()
                    + "\n1. Mostrar usuarios,"
                    + "\n2. Buscar usuario."
                    + "\n3. Crear usuario."
                    + "\n4. Modificar Usuario."
                    + "\n5. Salir."
            );
            option = Inputs.inputInterger();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");

            switch (option) {
                case 1 -> System.out.println("mostrar usuarios");
                case 2 -> System.out.println("buscar usuario");
                case 3 -> createUser(true);
                case 4 -> System.out.println("modificar usuario");
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Ingrese una opcion Correcta");
            }

        }while (option != 5);
    }

    private void recepcionista(User user){
        System.out.println(" RECEPCINISTA");
        System.out.println(" Bienvenido " + user.getName()+" "+user.getLastName());

    }
    private void pasajero(User user){
        System.out.println("Pasajero");
        System.out.println(" Bienvenido " + user.getName()+" "+user.getLastName());
    }

    public void createUser(boolean accessRermission) throws IOException {
        User user = new User();

        if (accessRermission) {
            int option;
            do {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                        + "1. " + UserProfile.Administrador
                        + "\n2. " + UserProfile.Pasajero
                        + "\n3. " + UserProfile.Recepcionista
                        + "\n Elige que tipo de usario: "
                );

                option = Inputs.inputInterger();
                switch (option) {
                    case 1 -> user.setUserProfile(UserProfile.Administrador);
                    case 2 -> user.setUserProfile(UserProfile.Pasajero);
                    case 3 -> user.setUserProfile(UserProfile.Recepcionista);
                    default -> System.out.println("Ingrese una opcion correta!");
                }
            } while (option > 3 || option < 1);


            System.out.print(" Ingrese el nombre: ");
            user.setName(Inputs.inputString());

            System.out.print("\n Ingrese el apellido: ");
            user.setLastName(Inputs.inputString());

            System.out.print("\n Ingrese el DNI: ");
            user.setDNI(Inputs.inputString());

            System.out.print("\n Ingrese la direccion: ");
            user.setAdress(Inputs.inputString());

            System.out.print("\n Ingrese el telefono: ");
            user.setPhone(Inputs.inputString());

            System.out.print("\n Ingrese el email: ");
            user.setEmail(Inputs.inputString());

            System.out.print("\n Ingrese el genero: ");
            user.setGenre(Inputs.inputString());

            System.out.print("\n Ingrese el nombre de usuario: ");
            user.setUserId(Inputs.inputString());

            System.out.print("\n Ingrese la contraseña: ");
            user.setPassword(Inputs.inputString());
            userService.addUser(user);
        }else{
            System.out.println("No tiene permiso de acceso");
        }
    }

    public void showUsers() throws IOException {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        new UserService().showUsers();
    }

    public void updateUser() throws IOException {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\n\n Ingrese la ID del usuario a modificar: ");
        userService.showUserDetails(userService.getUserByID(new Inputs().inputInterger().longValue()));
    }

    // GUIs de reservaciones

    public void reservationMainMenu() {

    }

    public Reservation requestExpectedReservation() {

        /*
        tipo de habitacion
        fechas
         */
        Reservation newReservation = new Reservation();
        return null;
    }

    public RoomType requestRoomType() {
        // me traigo todos los tipos de habitacion
        // tomo la opcion
        // la retorno
        return null;
    }


}
