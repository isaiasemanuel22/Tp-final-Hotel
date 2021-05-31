package com.company.controller;

import com.company.models.User;
import com.company.services.UserService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    private  UserService userService = new UserService();

    public Menu() throws IOException {
    }


    public void initProgram(){
        login();
    }

    public void login(){
        System.out.println("Ingrese su nombre de usuario");
        Scanner write = new Scanner(System.in);
        String userName = null;
        int acceso;
        try{
            userName = write.nextLine();
        }catch (Exception e){
            System.out.println(e.toString());
        }

        acceso = userService.traerUsuario(userName);
        if(acceso != 0 ){
            switch (acceso) {
                case 1 -> {
                    administrador(userName);
                }
                case 2 -> {
                    recepcionista(userName);

                }
                case 3 -> {
                    usuario(userName);

                }
            }
        }

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

    public void showUsers(){

    }

}
