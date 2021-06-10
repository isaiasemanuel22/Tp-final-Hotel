package com.company.repository;

import com.company.models.Room;
import com.company.models.RoomType;
import com.company.utils.Archivos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class RoomRepository {
    private static RoomRepository instance;
    Archivos<Room> archivos = new Archivos<>("Rooms");
    ArrayList<Room> rooms;

    private RoomRepository() throws IOException {
        rooms =  archivos.read(Room.class);

    }

    public static RoomRepository getInstance() throws IOException {
        if (instance == null)
            instance = new RoomRepository();
        return instance;
    }

    public void saveRooms(ArrayList<Room> rooms){
        System.out.println(rooms);
        archivos.save(rooms);
    }

    public boolean isAvailable(Integer roomNumber) {
        for (Room room: rooms) {
            if(room.getRoomNumber() == roomNumber){
                return room.isAvailable();
            }
        }
        return true;
    }

    public ArrayList<Room> getAll(){
        return this.rooms;
    }

    public Room getRoom(int roomID){
        Room roomSearch = null;
        for (Room room:rooms) {
            if(room.getRoomNumber() == roomID){
                roomSearch = room;
            }
        }
        return roomSearch;
    }

    public void updateRoom(Room room){
        for(int i = 0 ; i < rooms.size() ; i++){
            if(rooms.get(i).getRoomNumber() == room.getRoomNumber()){
                rooms.remove(rooms.get(i));
                rooms.add(i , room);
            }
        }
        archivos.save(rooms);
    }

    public ArrayList<Room> getRoomsByTypeRoom(RoomType typeRoom) {
        ArrayList<Room> roomsByType = new ArrayList<>();
        for(Room roomSearch : rooms){
            if(roomSearch.getRoomType() == typeRoom.getRoomType()){
                if(roomSearch.isAvailable()){
                    roomsByType.add(roomSearch);
                }
            }
        }
        return roomsByType;
    }
}

