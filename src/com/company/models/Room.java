package com.company.models;

public class Room {
    private Type roomType;
    private String features;
    private int roomNumber;


    public Room(Type roomType, String features, int roomNumber) {
        this.roomType = roomType;
        this.features = features;
        this.roomNumber = roomNumber;
    }


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
}
