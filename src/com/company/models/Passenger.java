package com.company.models;

import com.company.models.Reservation;
import com.company.models.Room;
import java.util.ArrayList;

public class Passenger extends User{
    private int actuallyReservation; //Contains reservation ID
    private ArrayList<Integer> bookingHistory; ; //Contains the reservations ID history
    private ArrayList<Integer> payments; //Contains the tickets ID history

    public Passenger(int ID, String name, String lastName, String DNI, String adress, String phone, String email, String genre, String userId, String password) {
        super(ID, name, lastName, DNI, adress, phone, email, genre, userId, password);
        actuallyReservation = -1;
        bookingHistory = new ArrayList<Integer>();
        payments = new ArrayList<Integer>();
    }
}
