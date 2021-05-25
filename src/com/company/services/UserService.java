package com.company.services;

public class UserService {

    public int traerUsuario(String userName){
        int acceso = 0;
        if(userName.equals("Isaias")){
            System.out.println(userName);
            acceso = 1;
        }else if(userName.equals("Octavio")){
            System.out.println(userName);
            acceso = 2;
        }else if(userName.equals("Emanuel")){
            System.out.println(userName);
            acceso = 3;
        }
        return acceso;
    }
}
