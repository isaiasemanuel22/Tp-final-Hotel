package com.company.models;

import javax.jws.soap.SOAPBinding;
import java.time.LocalDate;

public class Reservation {
    private static int uniqueID = 0;
    private int ID;
    private LocalDate entryDate;
    private LocalDate departureDate;
    private Room room;
    private User user;

    public Reservation(int ID, LocalDate entryDate, LocalDate departureDate, Room room, User user) {
        uniqueID++;
        this.ID = uniqueID;
        this.entryDate = entryDate;
        this.departureDate = departureDate;
        this.room = room;
        this.user = user;
    }

    public int getID() {
        return ID;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    @Override
    public String toString() {
        return "Reservation{" +
                "ID=" + ID +
                ", entryDate='" + entryDate + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", room=" + room +
                '}';
    }
}
