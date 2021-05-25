package com.company.models;

public class Room {
    private Type roomType;
    private String features;
    private int roomNumber;
    private int floor;


    public Room(Type roomType, String features, int roomNumber, int floor) {
        this.roomType = roomType;
        this.features = features;
        this.roomNumber = roomNumber;
        this.floor = floor;
    }



    public String getFeatures() { return features; }

    public void setFeatures(String features) { this.features = features; }

    public int getRoomNumber() { return roomNumber; }

    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }

    public int getFloor() { return floor; }

    public void setFloor(int floor) { this.floor = floor; }

    @Override
    public String toString() {
        return "Room{" +
                "roomTypeID=" + roomType +
                ", features='" + features + '\'' +
                ", roomNumber=" + roomNumber +
                ", floor=" + floor +
                '}';
    }
}
