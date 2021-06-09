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
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
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


    public String room() {
        return "Room{" +
                "roomTypeID=" + roomType +
                ", roomNumber=" + roomNumber +
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
