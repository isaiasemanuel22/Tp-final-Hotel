package com.company.services;

import com.company.models.Room;
import com.company.models.RoomType;
import com.company.models.Type;
import com.company.repository.RoomRepository;
import com.company.repository.RoomTypeRepository;

import java.io.IOException;
import java.util.ArrayList;

public class RoomService {
    RoomRepository roomRepository = new RoomRepository();
    RoomTypeRepository roomTypeRepository = RoomTypeRepository.getInstance();

    public RoomService() throws IOException {
        generateRooms();
    }

    public void generateRooms() {
        if(roomRepository.getAll().size() < 1){
            roomRepository.saveRooms(createRooms());
        }
    }

    private ArrayList<Room> createRooms(){
        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<RoomType> roomTypes = roomTypeRepository.getRoomTypes();

        for (int i = 0 ; i < 80 ; i++){
                if(i < 10){
                    System.out.println("hola");
                    rooms.add(new Room(roomTypes.get(0).getRoomType() , "Una habitación asignada a una persona. Puede tener una o más camas. El tamaño de la habitación o el área de las habitaciones individuales son generalmente de 37 m² a 45 m²." , i ));
                }
                else if(i < 20){
                    rooms.add(new Room(roomTypes.get(1).getRoomType() , "Una habitación asignada a dos personas. Puede tener una o más camas. El tamaño de la habitación o el área de las habitaciones dobles son generalmente entre 40 m² y 45 m²." , i ));
                }else if(i < 30) {
                    rooms.add(new Room(roomTypes.get(2).getRoomType() , "Una habitación con capacidad para tres personas y ha sido equipada con tres camas individuales, una cama doble y una cama individual o dos camas dobles." , i ));
                }else if(i < 40){
                    rooms.add(new Room(roomTypes.get(3).getRoomType() , "Una habitación asignada a cuatro personas. Puede tener dos o más camas. El tamaño de la habitación o el área de las habitaciones Quad son generalmente de 70 a 85 m²." , i ));
                }else if(i < 50) {
                    rooms.add(new Room(roomTypes.get(4).getRoomType() , "Una habitación con una cama de matrimonio. Puede ser ocupado por una o más personas." , i ));
                }
                else if (i < 60) {
                    rooms.add(new Room(roomTypes.get(5).getRoomType() , "Una habitación con una cama king-size. Puede ser ocupado por una o más personas." , i ));
                }else if(i < 70){
                    rooms.add(new Room(roomTypes.get(6).getRoomType() , "Es un salón o sala de estar, conectado a una o más habitaciones. (Una habitación con uno o más dormitorios y una sala de estar separada.) El tamaño de la habitación o el área de las habitaciones Suite son generalmente entre 70 m² y 100 m²." , i ));
                }else {
                    rooms.add(new Room(roomTypes.get(7).getRoomType() , "La habitación más cara que brinda un hotel. Tiene uno o más dormitorios, una sala de estar bien decorada, los suministros son de alta calidad e incluye servicios personalizados." , i ));
                }
            }
        return rooms;
        }

    }

