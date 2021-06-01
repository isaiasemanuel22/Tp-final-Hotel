package com.company.repository;

import com.company.models.RoomType;
import com.company.utils.Archivos;

import java.util.ArrayList;

public class RoomTypeRepository {

    Archivos<RoomType> archivos = new Archivos<>("roomType");
    ArrayList<RoomType> typeRooms = new ArrayList<>();

    public boolean exist(){
       return archivos.existFile();
    }

    public void saveRoomsType(ArrayList<RoomType> rooms){
        archivos.saveMany(rooms);
    }

}
