package com.company.repository;

import com.company.models.Reserva;
import com.company.utils.Archivos;

import java.io.IOException;
import java.util.ArrayList;

public class ReservationRepository {
    private static ReservationRepository intance = null;
    private Archivos<Reserva> archivos = new Archivos<>("reservas");
    private ArrayList<Reserva> reservations = new ArrayList<>();



    private  ReservationRepository() throws IOException {
        reservations = archivos.read(Reserva.class);
    }

    public static ReservationRepository getInstance() throws IOException {
        if(intance == null){
            intance = new ReservationRepository();
        }
        return intance;
    }

    public ArrayList<Reserva> getReservations() { return reservations; }

    public ArrayList<Reserva> getActives(){
        ArrayList<Reserva> actives = new ArrayList<>();
        for (Reserva reserva : reservations){
            if(reserva.isActive()){
                actives.add(reserva);
            }
        }
        return actives;
    }

    public void saveAll(){ archivos.save(reservations); }
}
