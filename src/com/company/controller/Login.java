package com.company.controller;

import java.util.Scanner;

public class Login {

    public void Login(){
        Scanner write = new Scanner(System.in);
        String name;
        System.out.println("Ingrese nombre de usuario");
        try {
            name = write.nextLine();

        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
