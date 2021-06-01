package com.company.services;

import com.company.models.RoomType;
import com.company.models.Type;
import com.company.repository.RoomTypeRepository;
import com.company.utils.Inputs;

import java.io.IOException;
import java.util.ArrayList;

public class RoomTypeService {

    Inputs<Object> inputs = new Inputs<>();
    RoomTypeRepository roomTypeRepository = RoomTypeRepository.getInstance();

    public RoomTypeService() throws IOException {
    }

    public void generateRooms(){
        if(!roomTypeRepository.exist()){
            ArrayList<RoomType>  rooms = createRooms();
            roomTypeRepository.saveRoomsType(rooms);
        }
    }

    private ArrayList<RoomType> createRooms(){
        ArrayList<RoomType> roomsType = new ArrayList<>();
        for (int i = 0 ; i < 8 ; i++){
            RoomType newRoomType = new RoomType();
            switch (i) {
                case 0 -> {
                    System.out.println("Individual");
                    roomsType.add(new RoomType(Type.Individual, inputs.inputInterger()));
                }
                case 1 -> {
                    System.out.println("Dobre");
                    roomsType.add(new RoomType(Type.Doble, inputs.inputInterger()));
                }
                case 2 -> {
                    System.out.println("Triple");
                     roomsType.add(new RoomType(Type.Triple, inputs.inputInterger()));
                }
                case 3 -> {
                    System.out.println("Quad");
                    roomsType.add(new RoomType(Type.Quad, inputs.inputInterger()));
                }
                case 4 -> {
                    System.out.println("Queen");
                    roomsType.add(new RoomType(Type.Queen, inputs.inputInterger()));
                }
                case 5 -> {
                    System.out.println("King");
                    roomsType.add(new RoomType(Type.King, inputs.inputInterger()));
                }
                case 6 -> {
                    System.out.println("Suite");
                    roomsType.add(new RoomType(Type.Suite, inputs.inputInterger()));
                }
                case 7 -> {
                    System.out.println("SuitePresidencial");
                    roomsType.add(new RoomType(Type.SuitePresidencial, inputs.inputInterger()));
                }
            }
        }
        return roomsType;
    }
}
