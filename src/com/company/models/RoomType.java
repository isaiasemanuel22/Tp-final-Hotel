package com.company.models;

public class RoomType {
    private Type roomType;
    private int price;

    public RoomType() {
    }

    public RoomType(Type roomType, int price) {
        this.roomType = roomType;
        this.price = price;
    }

    public Type getRoomType() { return roomType; }

    public void setRoomType(Type roomType) { this.roomType = roomType; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    @Override
    public String toString() {
        return "\n\n Tipo de habitacion: " + roomType
               +"\n Precio : "+ price;
    }
}
