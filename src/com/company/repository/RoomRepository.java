package com.company.repository;

import com.company.models.Room;
import com.company.utils.Archivos;

import java.io.IOException;
import java.util.ArrayList;

public class RoomRepository {
    Archivos<Room> archivos = new Archivos<>("Rooms");
    ArrayList<Room> rooms;

    public  RoomRepository() throws IOException {
        rooms =  archivos.read(Room.class);

    }
    public void RoomsGenerate() throws IOException {
        ArrayList<Room> rooms = new ArrayList<>();
        if (archivos.exists()) {
            rooms = archivos.read(Room.class);
        } else {
            for (int i = 0; i < 40; i++) {

            }
        }
    }

    public void saveRooms(ArrayList<Room> rooms){
        System.out.println(rooms);
        archivos.save(rooms);
    }
}