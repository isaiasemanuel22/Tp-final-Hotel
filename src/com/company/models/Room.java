package com.company.models;

public class Room {
    private Type roomType;
    private String features;
    private int roomNumber;
    private boolean available;

    public Room() {
    }

    public Room(Type roomType, String features, int roomNumber , boolean available) {
        this.roomType = roomType;
        this.features = features;
        this.roomNumber = roomNumber;
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public void available() {
        this.available = true;
    }
    public void ocupped() { this.available = false; }

    public Type getRoomType() {
        return roomType;
    }

    public void setRoomType(Type roomType) {
        this.roomType = roomType;
    }

    public String getFeatures() { return features; }

    public void setFeatures(String features) { this.features = features; }

    public int getRoomNumber() { return roomNumber; }

    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }


    @Override
    public String toString() {
        return "Room{" +
                "roomTypeID=" + roomType +
                ", features=" + features +
                ", roomNumber=" + roomNumber +
                '}';
    }


    public String room() {
        return "\n Habitacion: " + roomNumber +
                "\n Tipo de habitacion: " + roomType +
                "\n Disponibilidad: " + queryOccuped();
    }

    public String queryOccuped(){
        if(available){
            return "Desocupada";
        }
        else{
            return "Ocupada";
        }
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(this.roomNumber);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
