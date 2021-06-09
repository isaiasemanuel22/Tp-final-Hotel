package com.company.services;

import com.company.models.User;
import com.company.models.UserType;
import com.company.repository.UserRepository;
import com.company.utils.Inputs;

import java.io.IOException;

public class UserService {

    UserRepository repository;

    public UserService() throws IOException {
        this.repository =  UserRepository.getInstance();
    }

    public void addUser(User toAdd) throws IOException {
        repository.save(toAdd);
    }

    public void saveAll(){
        repository.saveAll();
    }

    public UserType chooseUserType() throws InterruptedException {
        int option;
        UserType toReturn = null;
        do {
            System.out.print("\n 1. " + UserType.ADMIN
                    + "\n 2. " + UserType.PASAJERO
                    + "\n 3. " + UserType.RECEPCIONISTA
                    + "\n Elige que tipo de usario: "
            );

            option = Inputs.inputInterger();
            switch (option) {
                case 1 -> toReturn = UserType.ADMIN;
                case 2 -> toReturn = UserType.PASAJERO;
                case 3 -> toReturn = UserType.RECEPCIONISTA;
                default -> {
                    System.out.println(" Ingrese una opcion correta!");
                    Thread.sleep(3000);
                }
            }
        } while (option > 3 || option < 1);
        return toReturn;
    }

    public void createUser(boolean admin) throws InterruptedException {
        User user = new User();
        if (admin)
            user.setUserType(chooseUserType());
        else
            user.setUserType(UserType.PASAJERO);

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
        user.setUserName(Inputs.inputString());

        System.out.print("\n Ingrese la contraseña: ");
        user.setPassword(Inputs.inputString());
        user.setRoomID(0);
        try {
            addUser(user);
        } catch (Exception e) {
            System.out.println(" Hubo un problema al registar el usuario por favor intente mas tarde.");
        }
    }

    public void updateUser(User user, int option) throws InterruptedException {
        switch (option){
            case 1:
                user.setUserType(chooseUserType());
                break;
            case 2:
                System.out.print("\n Ingrese el nombre: ");
                user.setName(Inputs.inputString());
                break;
            case 3:
                System.out.print("\n Ingrese el apellido: ");
                user.setLastName(Inputs.inputString());
                break;
            case 4:
                System.out.print("\n Ingrese el DNI: ");
                user.setDNI(Inputs.inputString());
                break;
            case 5:
                System.out.print("\n Ingrese la direccion: ");
                user.setAdress(Inputs.inputString());
                break;
            case 6:
                System.out.print("\n Ingrese el numero de telefono: ");
                user.setPhone(Inputs.inputString());
                break;
            case 7:
                System.out.print("\n Ingrese el mail: ");
                user.setEmail(Inputs.inputString());
                break;
            case 8:
                System.out.print("\n Ingrese el genero: ");
                user.setGenre(Inputs.inputString());
                break;
            case 9:
                System.out.print("\n Ingrese la contraseña: ");
                user.setPassword(Inputs.inputString());
            case 10:
                if (user.isBanned())
                    user.unban();
                else
                    user.ban();
                break;
        };
        repository.update(user);

    }

    public void showUserDetails(User user){
        String status = new String();
        if(user.isBanned())
            status = "Baneado";
        else
            status = "Activo";

        System.out.println("\n\n 1. Tipo de usuario: "+user.getUserType()
                +"\n 2. Nombre: "+user.getName()
                +"\n 3. Apellido: "+user.getLastName()
                +"\n 4. DNI: "+user.getDNI()
                +"\n 5. Direccion: "+user.getAdress()
                +"\n 6. Telefono: "+user.getPhone()
                +"\n 7. Email: "+user.getEmail()
                +"\n 8. Genero: "+user.getGenre()
                +"\n 9. Contraseña: "+user.getPassword()
                +"\n 10. Estado: "+status
        );
    }

    private void showUsersOnSearch(User user){
        System.out.println("\n\n Tipo de usuario: "+user.getUserType()
                +"\n Nombre de usuario: "+ user.getUserName()
                +"\n Nombre: "+ user.getName()
                +"\n Apellido: "+ user.getLastName()
                +"\n DNI: "+ user.getDNI()
        );
    }

    public void showUsers(){
        for (User aux: repository.getUsers())
            showUsersOnSearch(aux);
    }


    public User searchByUserName(String userName) {
        return repository.getByUserName(userName);
    }

    public void passenger(){
        for (User aux: repository.getUsers()) {
            if(aux.getUserType() == UserType.PASAJERO){
                showUsersOnSearch(aux);
            }
        }
    }

    public void passengerActivos(){
        for (User aux: repository.getUsers()) {
            if(aux.getUserType() == UserType.PASAJERO && aux.isBanned()){
                showUserDetails(aux);
            }
        }
    }



    public void roomXPassenger(int room , User user){
        user.setRoomID(room);
        repository.update(user);
    }

    public void vacate(User user){
        repository.update(user);
    }

    public void bannedPassenger(User user){
        repository.update(user);
    }

    public User getUserByRoom(int room){
        return repository.getUserByRoom(room);
    }


    public void createPassenger(){

    }
    /*public void register(User user) {
        repository.save(user);
    }*/
}
