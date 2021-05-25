package com.company.controller;

import com.company.services.UserService;

import java.util.Scanner;

public class Menu {
    private  UserService userService = new UserService();


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
            switch (acceso){
                case 1: administrador(userName);

                case 2: recepcionista(userName);

                case 3: usuario(userName);
            }
        }

    }

    public void administrador(String username){

    }

    public void recepcionista(String username){

    }
    public void usuario(String username){

    }
}
