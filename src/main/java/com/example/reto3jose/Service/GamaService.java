package com.reto3.reto3g24.Service;

import com.reto3.reto3g24.Entities.Gama;
import com.reto3.reto3g24.Repository.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamaService {

    @Autowired
    private GamaRepository gamaRepository;

    public List<Gama> getAll() { return gamaRepository.getAll(); }
    public Optional<Gama> getGama(int id) { return gamaRepository.getGama(id);}
    public Gama save(Gama p){
        if(p.getId()==null){
            return gamaRepository.save(p);
        }else{
            Optional<Gama> e = gamaRepository.getGama(p.getId());
            if(e.isPresent()){
                return p;
            }else{
                return gamaRepository.save(p);
            }
        }
    }
    public Gama update(Gama p){
        if(p.getId()!=null) {
            Optional<Gama> q = gamaRepository.getGama(p.getId());
            if (q.isPresent()) {
                if (p.getDescription() != null) {
                    q.get().setDescription(p.getDescription());
                }
                if (p.getName() != null) {
                    q.get().setName(p.getName());
                }
                gamaRepository.save(q.get());
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
        Optional<Gama>p= gamaRepository.getGama(id);
        if(p.isPresent()){
            gamaRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }
}
