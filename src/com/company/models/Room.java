package com.company.models;

public class Room {
    private Type roomType;
    private String features;
    private int roomNumber;
    private int floor;
    private boolean available;

    public Room() {
    }

    public Room(int roomNumber){
        this.roomNumber = roomNumber;
    }

    public Room(Type roomType, String features, int roomNumber, int floor, boolean available) {
        this.roomType = roomType;
        this.features = features;
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.available = available;
    }

    public String getFeatures() { return features; }

    public void setFeatures(String features) { this.features = features; }

    public int getRoomNumber() { return roomNumber; }

    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }

    public int getFloor() { return floor; }

    public void setFloor(int floor) { this.floor = floor; }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomTypeID=" + roomType +
                ", features='" + features + '\'' +
                ", roomNumber=" + roomNumber +
                ", floor=" + floor +
                '}';
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
