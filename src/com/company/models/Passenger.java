package com.company.models;

import com.company.models.Reservation;
import com.company.models.Room;
import java.util.ArrayList;

public class Passenger {
    private User usuario;
    private int actuallyReservation; //Contains reservation ID
    private ArrayList<Integer> bookingHistory; ; //Contains the reservations ID history
    private ArrayList<Integer> payments; //Contains the tickets ID history

    public Passenger() {
        actuallyReservation = -1;
        bookingHistory = new ArrayList<Integer>();
        payments = new ArrayList<Integer>();
    }

    public void setUser(User user){
        usuario = user;
    }
}
