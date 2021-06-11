package com.company.models;

import java.time.LocalDate;

public class Reserva {
    private String passenger;
    private Integer room;
    private String start;
    private String end;
    private boolean active;


    public Reserva() {
    }

    public Reserva(String username , Integer room , String start , String end){
        this.passenger = username;
        this.room = room;
        this.start = start;
        this.end = end;
        this.active = true;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void active(){
        this.active = true;
    }

    public void inactive(){
        this.active = false;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return
                '\n' + "Pasajero: " + passenger
                +'\n' + "Habitacion: " + room
                +'\n' + "Fecha de entrada: " + start
                +'\n' + "Fecha de salida: " + end;

    }
}
