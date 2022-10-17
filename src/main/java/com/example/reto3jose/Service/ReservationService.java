package com.example.reto3jose.Service;

import com.example.reto3jose.Entities.Reservation;
import com.example.reto3jose.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() { return reservationRepository.getAll(); }
    public Optional<Reservation> getReservation(int id) { return reservationRepository.getReservation(id);}
    public Reservation save(Reservation p){
        if(p.getId()==null){
            return reservationRepository.save(p);
        }else{
            Optional<Reservation> e = reservationRepository.getReservation(p.getId());
            if(e.isPresent()){
                return p;
            }else{
                return reservationRepository.save(p);
            }
        }
    }
    public Reservation update(Reservation p){
        if(p.getId()!=null) {
            Optional<Reservation> q = reservationRepository.getReservation(p.getId());
            if (q.isPresent()) {
                if (p.getStartDate() != null) {
                    q.get().setStartDate(p.getStartDate());
                }
                if (p.getDevolutionDate() != null) {
                    q.get().setDevolutionDate(p.getDevolutionDate());
                }
                if (p.getStatus() != null) {
                    q.get().setStatus(p.getStatus());
                }
                reservationRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Reservation>p= reservationRepository.getReservation(id);
        if(p.isPresent()){
            reservationRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }
}
