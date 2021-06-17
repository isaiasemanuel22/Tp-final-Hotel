package com.company.services;

import com.company.models.Reserva;
import com.company.models.Room;
import com.company.models.RoomType;
import com.company.models.Type;
import com.company.repository.ReservationRepository;
import com.company.repository.RoomRepository;
import com.company.repository.RoomTypeRepository;

import javax.security.auth.callback.LanguageCallback;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class RoomService {
    RoomRepository roomRepository = RoomRepository.getInstance();
    RoomTypeRepository roomTypeRepository = RoomTypeRepository.getInstance();
    ReservationRepository reservationRepository = ReservationRepository.getInstance();

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

        for (int i = 1 ; i < 80 ; i++){
                if(i < 10){
                    rooms.add(new Room(roomTypes.get(0).getRoomType() , "Una habitación asignada a una persona. Puede tener una o más camas. El tamaño de la habitación o el área de las habitaciones individuales son generalmente de 37 m² a 45 m²." , i ,true));
                }
                else if(i < 20){
                    rooms.add(new Room(roomTypes.get(1).getRoomType() , "Una habitación asignada a dos personas. Puede tener una o más camas. El tamaño de la habitación o el área de las habitaciones dobles son generalmente entre 40 m² y 45 m²." , i ,true));
                }else if(i < 30) {
                    rooms.add(new Room(roomTypes.get(2).getRoomType() , "Una habitación con capacidad para tres personas y ha sido equipada con tres camas individuales, una cama doble y una cama individual o dos camas dobles." , i ,true));
                }else if(i < 40){
                    rooms.add(new Room(roomTypes.get(3).getRoomType() , "Una habitación asignada a cuatro personas. Puede tener dos o más camas. El tamaño de la habitación o el área de las habitaciones Quad son generalmente de 70 a 85 m²." , i ,true));
                }else if(i < 50) {
                    rooms.add(new Room(roomTypes.get(4).getRoomType() , "Una habitación con una cama de matrimonio. Puede ser ocupado por una o más personas." , i ,true));
                }
                else if (i < 60) {
                    rooms.add(new Room(roomTypes.get(5).getRoomType() , "Una habitación con una cama king-size. Puede ser ocupado por una o más personas." , i,true ));
                }else if(i < 70){
                    rooms.add(new Room(roomTypes.get(6).getRoomType() , "Es un salón o sala de estar, conectado a una o más habitaciones. (Una habitación con uno o más dormitorios y una sala de estar separada.) El tamaño de la habitación o el área de las habitaciones Suite son generalmente entre 70 m² y 100 m²." , i ,true));
                }else {
                    rooms.add(new Room(roomTypes.get(7).getRoomType() , "La habitación más cara que brinda un hotel. Tiene uno o más dormitorios, una sala de estar bien decorada, los suministros son de alta calidad e incluye servicios personalizados." , i ,true));
                }
            }
        return rooms;
        }

    public boolean chekAvailability(Integer roomNumber) {
        return roomRepository.isAvailable(roomNumber);
    }

    public void showAvailableRooms(){
        for(Room room : roomRepository.getAll()){
            if(room.isAvailable()){
                System.out.println(room.room());
            }
        }
    }

    public void showUnavailableRooms(){
        for(Room room : roomRepository.getAll()){
            if(!room.isAvailable()){
                System.out.println(room.room());
            }
        }
    }


    public void occupyRoom(int room){
        roomRepository.getRoom(room).ocupped();
        roomRepository.updateRoom(roomRepository.getRoom(room));
    }

    public void vacate(int room){
        roomRepository.getRoom(room).available();;
        roomRepository.updateRoom(roomRepository.getRoom(room));
    }

    public void showRooms(){
        for(Room room : roomRepository.getAll()){
            System.out.println(room.room());
        }
    }

    public Room getRoom(int room){
       return roomRepository.getRoom(room);
    }

    public void showByTypeRoom(RoomType typeRoom){
        for(Room room: roomRepository.getRoomsByTypeRoom(typeRoom)){
            System.out.println(" "+room.room());
        }

    }

    public Room getByNum_TypeRoom(int room, RoomType roomType) {
        Room roomSearch = roomRepository.getRoom(room);
        if(roomSearch.getRoomType() == roomType.getRoomType()){
            return roomSearch;
        }
        return null;
    }

    public ArrayList<Room> getAllRooms(){
        return roomRepository.getAll();
    }


    public void updateRoomStatus(){
        for (Reserva aux: reservationRepository.getReservations()) {
            LocalDate start = LocalDate.parse(aux.getStart());
            LocalDate end = LocalDate.parse(aux.getEnd());
            if (start.equals(LocalDate.now()) && aux.isActive()){
                    Room room = roomRepository.getRoom(aux.getRoom());
                    room.ocupped();
                    roomRepository.updateRoom(room);
            }
            if (end.equals(LocalDate.now())){
               Room room =  roomRepository.getRoom(aux.getRoom());
               room.available();
               roomRepository.updateRoom(room);
            }
            if( start.isBefore(LocalDate.now()) && end.isAfter(LocalDate.now()) && !aux.isActive()){
                Room room =  roomRepository.getRoom(aux.getRoom());
                room.available();
                roomRepository.updateRoom(room);
            }
        }
    }
}

