package com.company.repository;

import com.company.models.User;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Scanner;

public class AdministradorRepository {

    public User crearAdministrador(){
        JSONObject jsonObject = new JSONObject();
        User newUser = new User
                (       1,
                        "Isaias",
                        "Calfin",
                        "32456789",
                        "Brasil 1265",
                        "2236745133",
                        "isaias@hotmail.com",
                        "Masculino",
                        1,
                        "Isaias22"
                );

        jsonObject.put("user" , newUser);

        System.out.println(jsonObject);
        return newUser;

    }
}

