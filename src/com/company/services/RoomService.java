package com.company.services;

import com.company.controller.RoomMenu;
import com.company.models.Room;
import com.company.repository.RoomRepository;

import java.util.HashSet;

public class RoomService {

    RoomRepository repository = new RoomRepository();
    HashSet<Room> rooms = new HashSet<Room>();

    public boolean createRoom(){ // servicio para crear habitacion e integrarla al sistema

        int roomNumber = RoomMenu.askForRoomNumber();

        if (roo)

    }

    public boolean contains(int roomNumber){
        for (Room room : rooms){
            if (room.equals())
        }
    }
    
}
