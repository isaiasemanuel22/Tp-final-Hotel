package com.company.repository;

import com.company.models.User;

import java.util.HashMap;
import java.util.Scanner;

public class AdministradorRepository {

    public User crearAdministrador(){
        User newUser = new User
                (
                        "Isaias",
                        "Calfin",
                        "32456789",
                        "Brasil 1265",
                        "2236745133",
                        "isaias@hotmail.com",
                        "Masculino",
                        "IsaiasUTN",
                        "Isaias22"
                );

        return newUser;
    }
}

