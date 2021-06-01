package com.company.repository;

import com.company.models.Room;
import com.company.utils.Archivos;

import java.io.IOException;
import java.util.ArrayList;

public class RoomRepository {

    Archivos<Room> archivos = new Archivos<>("Rooms");

    public void RoomsGenerate() throws IOException {
        ArrayList<Room> rooms = new ArrayList<>();
        if(archivos.exists()){
            rooms = archivos.readMany(Room.class);
        }else{
            for(int i = 0 ; i < 40 ; i++){

            }
        }
    }


    public ArrayList<Room> rooms(int option , int cant){
        ArrayList<Room> roomsNueva = new ArrayList<>();



        return roomsNueva;
    }



}
