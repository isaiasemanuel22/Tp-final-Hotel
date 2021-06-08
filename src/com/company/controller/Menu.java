package com.company.controller;

import com.company.models.User;
import com.company.models.UserProfile;
import com.company.services.ReservationService;
import com.company.services.RoomService;
import com.company.services.UserService;
import com.company.utils.Inputs;

import java.io.IOException;

public class Menu {

    private User user;
    private UserService userService = new UserService();
    private RoomService roomService = new RoomService();
    private ReservationService reservationService = new ReservationService();

    public Menu() throws IOException, InterruptedException {

    }

    public void initProgram() throws IOException, InterruptedException {
        User login = new User();
           do {
               Session session = new Session();
               login = session.mainMenu();
               selecteMain(login);
           }while (login != null);

    }



        private void administrador (User user) throws IOException, InterruptedException {
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

                option = Inputs.inputInterger();
                switch (option) {
                    case 1:
                        userService.showUsers();
                        break;
                    case 2:
                        createUser(false);
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
            } while (option > 0 && option < 5);
        }


        private void recepcionista (User user){
            System.out.println(" RECEPCIONISTA");
            System.out.println(" Bienvenido " + user.getName() + " " + user.getLastName());
        }

        private void pasajero (User user) throws InterruptedException {
            int option;
            System.out.println("Pasajero");
            System.out.println(" Bienvenido " + user.getName() + " " + user.getLastName());
            do {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("ADMINISTRADOR");
                System.out.println("\n Bienvenido " + user.getName() + " " + user.getLastName()
                        + "\n\n1. Realizar reserva"
                        + "\n2. Salir"
                );

                option = Inputs.inputInterger();

                switch (option) {
                    case 1:
                        System.out.println("\nIngresa numero de habitacion");
                        Integer roomNumber =  Inputs.inputInterger();
                        boolean isAvailable = roomService.chekAvailability(roomNumber);
                        if (isAvailable) {
                            System.out.print(" Ingrese el nombre: ");
                            user.setName(Inputs.inputString());

                            System.out.print("\n Ingrese el apellido: ");
                            user.setLastName( Inputs.inputString());

                            System.out.print("\n Ingrese el DNI: ");
                            user.setDNI(Inputs.inputString());

                            reservationService.createReservation();
                        } else {
                            System.out.println("\nLa habitacion no se encuentra disponible");
                        }
                        break;
                    case 2:
                        //This case does nothing :D, it serves to close the program.
                        break;
                    default:
                        System.out.println("Ingrese una opcion correta!");
                        Thread.sleep(3000);
                        option = 1;
                }
            } while (option > 0 && option < 2);
        }

        public void createUser( boolean accessRermission) throws InterruptedException, IOException {

            if (accessRermission) {
                User user = new User();
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
                    System.out.println("acceso denegado");
            }
        }

        public void showUsers () throws IOException {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
            new UserService().showUsers();
        }

        public void updateUser () throws IOException, InterruptedException {
            int option;
            do {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
                System.out.print("\n\n Ingrese la ID del usuario a modificar: ");
                User userToUpdate = userService.getUserByID( Inputs.inputInterger().longValue());
                userService.showUserDetails(userToUpdate);
                System.out.print(" Ingrese el campo que quiera modificar: ");
                option = Inputs.inputInterger();
                if (option < 1 || option > 9) {
                    System.out.println("\n Elija una opcion correcta!");
                    Thread.sleep(3000);
                }
            } while (option < 1 || option > 9);
        }

        public void searchUser () throws IOException {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
            System.out.print("\n\n Ingrese la ID del usuario: ");
            userService.showUserDetails(userService.getUserByID(Inputs.inputInterger().longValue()));
        }

        public void selecteMain(User user) throws IOException, InterruptedException {
            if(user != null){
                switch (user.getUserProfile()){
                    case Administrador -> administrador(user);
                    case Recepcionista -> recepcionista(user);
                    case Pasajero -> pasajero(user);
                }
            }
        }
    }
