package com.company.repository;

import com.company.models.User;

public class AdministradorRepository {

    public User crearAdministrador(){
        User newUser = new User
                ();
        return newUser;
    }
}

