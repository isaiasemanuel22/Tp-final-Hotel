package com.company;

import com.company.controller.Menu;
import com.company.controller.Session;

public class Main {

    public static void main(String[] args){
        Session session = new Session();
        Menu menu = new Menu();

        menu.init(session.mainMenu());

    }
}
