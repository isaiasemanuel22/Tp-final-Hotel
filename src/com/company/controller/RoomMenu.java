package com.company.controller;

import org.w3c.dom.ls.LSOutput;

public class RoomMenu {

    public void mainMenu(){
        System.out.println(
                "\nSeleccionar opcion :"
                + "\n\t1 > Agregar habitacion"

                /*
                modificar
                dar de baja
                buscar y mostrar
                 */
        );
    }

    static public int askForRoomNumber(){
        System.out.println("Ingrese el numero de la habitacion");
        // Scanner
        int numeroDelScanner=0;
        return numeroDelScanner;
    }


}
