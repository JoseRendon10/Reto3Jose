package com.reto3.reto3g24.Repository;

import com.reto3.reto3g24.Entities.Reservation;
import com.reto3.reto3g24.Repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll() { return (List<Reservation>) reservationCrudRepository.findAll(); }

    public Optional<Reservation> getReservation(int id) { return reservationCrudRepository.findById(id); }
    public Reservation save(Reservation c) { return reservationCrudRepository.save(c); }
    public void delete(Reservation c) { reservationCrudRepository.delete(c); }
}
