package com.company.repository;

import com.company.models.Room;
import com.company.utils.Archivos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class RoomRepository {
    Archivos<Room> archivos = new Archivos<>("Rooms");
    ArrayList<Room> rooms;

    public  RoomRepository() throws IOException {
        rooms =  archivos.read(Room.class);

    }

    public void saveRooms(ArrayList<Room> rooms){
        System.out.println(rooms);
        archivos.save(rooms);
    }

    public boolean isAvailable(Integer roomNumber) {
        return rooms.stream().anyMatch(room -> roomNumber.equals(room.getRoomNumber()));
    }

    public ArrayList<Room> getAll(){
        return this.rooms;
    }
}

