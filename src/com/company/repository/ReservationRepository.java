package com.company.repository;

import com.company.models.Reserva;
import com.company.utils.Archivos;

import java.io.IOException;
import java.util.ArrayList;

public class ReservationRepository {
    private static ReservationRepository instance = null;
    private Archivos<Reserva> archivos = new Archivos<>("reservas");
    private ArrayList<Reserva> reservations = new ArrayList<>();

    private ReservationRepository() throws IOException {
        reservations = archivos.read(Reserva.class);
    }

    public static ReservationRepository getInstance() throws IOException {
        if(instance == null){
            instance = new ReservationRepository();
        }
        return instance;
    }
}
