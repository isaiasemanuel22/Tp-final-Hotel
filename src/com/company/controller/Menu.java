package com.company.controller;

import com.company.models.User;
import com.company.models.UserProfile;
import com.company.repository.UserRepository;
import com.company.services.UserProfileService;
import com.company.utils.Inputs;
import com.company.repository.RoomRepository;
import com.company.repository.RoomTypeRepository;
import com.company.services.RoomService;
import com.company.services.RoomTypeService;
import com.company.services.UserService;
import jdk.internal.util.xml.impl.Input;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    private UserService userService = new UserService();
    private UserProfileService = new UserProfileService;
    private RoomTypeService roomTypeService = new RoomTypeService();
    private RoomService roomService = new RoomService();

    public Menu() throws IOException {
    }

    public void initProgram(){
        login();
    }

    public void login(){
        System.out.print("Ingrese su nombre de usuario: ");
        String userName = new Inputs().inputString();
        System.out.print("\nIngrese su contraseña: ");
        String password = new Inputs().inputString();
    }

    private void administrador(String username){
        System.out.println("ADMINISTRADOR");
        System.out.println("Bienvenido " + username);
        System.out.println("Crear Administrador > 1");
        System.out.println("Agregar recepcionista > 2");
        System.out.println("Agregar Conserje > 3");
        System.out.println("Dar permiso recepcionista > 4");
        System.out.println("Dar permiso conserje > 5 ");
        System.out.println("Buscar Usuario > 6 ");
        System.out.println("Modificar Usuario > 7 ");
        System.out.println("Mostrar Usuarios > 7 ");
    }

    private void recepcionista(String username){
        System.out.println("RECEPCINISTA");
        System.out.println("Bienvenido " + username);

        System.out.println("Crear Administrador > 1");
        System.out.println("Agregar recepcionista > 2");
        System.out.println("Agregar Conserje > 3");
        System.out.println("Dar permiso recepcionista > 4");
        System.out.println("Dar permiso conserje > 5 ");

    }
    private void usuario(String username){
        System.out.println("USUARIO");
        System.out.println("Bienvenido " + username);

        System.out.println("Crear Administrador > 1");
        System.out.println("Agregar recepcionista > 2");
        System.out.println("Agregar Conserje > 3");
        System.out.println("Dar permiso recepcionista > 4");
        System.out.println("Dar permiso conserje > 5 ");

    }

    public void addUser(){
        User user = new User();
        user.setUserType()
        String name, String lastName, String DNI, String adress, String phone, String email, String genre, String userId, String password
    }

    public void showUsers() throws IOException {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        new UserService().showUsers();
    }

    public void updateUser() throws IOException {
        System.out.print("\n\nIngrese la ID del usuario a modificar: ");
        userService.showUserDetails(userService.getUserByID(new Inputs().inputInterger().longValue()));
    }
}
