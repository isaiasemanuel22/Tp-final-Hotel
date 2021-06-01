package com.company.repository;

import com.company.models.RoomType;
import com.company.utils.Archivos;

import java.io.IOException;
import java.util.ArrayList;

public class RoomTypeRepository {

    private Archivos<RoomType> archivos = new Archivos<>("roomType");
    private ArrayList<RoomType> typeRooms = new ArrayList<>();
    private static RoomTypeRepository instance;

    private RoomTypeRepository() throws IOException {
        typeRooms = archivos.read(RoomType.class);
    }

    public static RoomTypeRepository getInstance() throws IOException {
        if(instance == null){
            instance = new RoomTypeRepository();
        }
        return instance;
    }
    public boolean exist(){
       return archivos.existFile();
    }

    public void saveRoomsType(ArrayList<RoomType> rooms){
        typeRooms = rooms;
        archivos.save(rooms);
    }

    public ArrayList<RoomType> getTypeRooms(){
        return this.typeRooms;
    }

}
