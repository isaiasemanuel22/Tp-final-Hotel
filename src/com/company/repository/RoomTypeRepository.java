package com.company.repository;


import com.company.models.RoomType;
import com.company.models.Type;
import com.company.utils.Archivos;

import java.util.ArrayList;

public class RoomTypeRepository {
    private static RoomTypeRepository instance;
    private Archivos<RoomType> archivos = new Archivos<>("roomType");
    private ArrayList<RoomType> typeRooms;

    private RoomTypeRepository() {
        if(!archivos.exists()){
            setRoomTypes(createRoomsType());
            saveRoomsType();
        }
        this.typeRooms = archivos.read(RoomType.class);
        instance = this;
    }

    public static RoomTypeRepository getInstance() {
        if(instance == null){
            instance = new RoomTypeRepository();
        }
        return instance;
    }

    public ArrayList<RoomType> getRoomTypes(){ return this.typeRooms; }

    public void setRoomTypes(ArrayList<RoomType> roomTypes){ this.typeRooms = roomTypes; }

    public void saveRoomsType(){ archivos.save(this.typeRooms); }

    private ArrayList<RoomType> createRoomsType(){
        ArrayList<RoomType> roomsType = new ArrayList<>();
        for (int i = 0 ; i < 8 ; i++){
            RoomType newRoomType = new RoomType();
            switch (i) {
                case 0 -> {
                    System.out.println("Individual");
                    roomsType.add(new RoomType(Type.Individual, 0));
                }
                case 1 -> {
                    System.out.println("Dobre");
                    roomsType.add(new RoomType(Type.Doble, 0));
                }
                case 2 -> {
                    System.out.println("Triple");
                    roomsType.add(new RoomType(Type.Triple, 0));
                }
                case 3 -> {
                    System.out.println("Quad");
                    roomsType.add(new RoomType(Type.Quad, 0));
                }
                case 4 -> {
                    System.out.println("Queen");
                    roomsType.add(new RoomType(Type.Queen, 0));
                }
                case 5 -> {
                    System.out.println("King");
                    roomsType.add(new RoomType(Type.King, 0));
                }
                case 6 -> {
                    System.out.println("Suite");
                    roomsType.add(new RoomType(Type.Suite, 0));
                }
                case 7 -> {
                    System.out.println("SuitePresidencial");
                    roomsType.add(new RoomType(Type.SuitePresidencial, 0));
                }
            }
        }
        return roomsType;
    }
}
