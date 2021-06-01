package com.company.models;

public class Room {
    private String roomType;
    private String features;
    private int roomNumber;

    public Room() {
    }

    public Room(String roomType, String features, int roomNumber) {
        this.roomType = roomType;
        this.features = features;
        this.roomNumber = roomNumber;
    }


    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
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

    @Override
    public int hashCode() {
        return Integer.hashCode(this.roomNumber);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
