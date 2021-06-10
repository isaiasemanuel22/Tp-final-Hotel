package com.company.models;

import java.time.LocalDate;

public class Reserva {
    private String passenger;
    private Integer room;
    private LocalDate start;
    private LocalDate end;
    private Integer id;

    public Reserva(String username , Integer room , LocalDate start ,LocalDate end){
        this.passenger = username;
        this.room = room;
        this.start = start;
        this.end = end;
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

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return
                '\n' + "Pasajero='" + passenger
                +'\n' + "Habitacion='" + room
                +'\n' + "Inicio='" + start
                +'\n' + "Fin='" + end;

    }
}
