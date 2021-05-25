package com.company.services;

import com.company.repository.AdministradorRepository;

public class AdministradorService {

    private AdministradorRepository admRepository = new AdministradorRepository();

    public void createAdmin(){
        admRepository.crearAdministrador();
    }
}
