package com.company;

import com.company.controller.Menu;
import com.company.models.User;
import com.company.models.UserType;
import com.company.repository.UserRepository;
import com.company.services.UserService;
import com.company.utils.Archivos;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Menu menu = new Menu();
        menu.initProgram();

    }
}
