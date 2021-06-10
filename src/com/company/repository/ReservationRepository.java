package com.company.repository;

import com.company.models.Reserva;
import com.company.utils.Archivos;

import java.io.IOException;
import java.util.ArrayList;

public class ReservationRepository {
    private Archivos<Reserva> archivos = new Archivos<>("reservas");
    private ArrayList<Reserva> reservations = new ArrayList<>();

    public ReservationRepository() throws IOException {
        reservations = archivos.read(Reserva.class);
    }

    public ArrayList<Reserva> getReservations() { return reservations; }

    public void saveAll(){ archivos.save(reservations); }
}
