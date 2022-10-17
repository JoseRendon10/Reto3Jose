package com.example.reto3jose.Service;

import com.example.reto3jose.Entities.Gama;
import com.example.reto3jose.Repository.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class GamaService {

    @Autowired
    private GamaRepository gamaRepository;

    public List<Gama> getAll() { return gamaRepository.getAll(); }
    public Optional<Gama> getGama(int id) { return gamaRepository.getGama(id); }
    public Gama save(Gama gama){
        if(gama.getId() == null){
            return gamaRepository.save(gama);
        }else{
            Optional<Gama> gama1 = gamaRepository.getGama(gama.getId());
            if(gama1.isPresent()){
                return gama;
            }else{
                return gamaRepository.save(gama);
            }
        }
    }
    public Gama update(Gama gama){
        if(gama.getId()!=null) {
            Optional<Gama> q = gamaRepository.getGama(gama.getId());
            if (q.isPresent()) {
                if (gama.getDescription() != null) {
                    q.get().setDescription(gama.getDescription());
                }
                if (gama.getName() != null) {
                    q.get().setName(gama.getName());
                }
                return gamaRepository.save(q.get());
            }else{
                return gama;
            }
        }else{
            return gama;
        }
    }
    public boolean delete(int id){
        boolean d = getGama(id).map(gama -> {
            gamaRepository.delete(gama);
            return true;
        }).orElse(false);
        return d;
    }
}
