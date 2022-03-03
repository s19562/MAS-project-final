package com.example.demo.manager;


import com.example.demo.dao.StrefaRepo;
import com.example.demo.dao.entity.Strefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StrefaManager {

    private StrefaRepo strefaRepo;

    @Autowired
    public StrefaManager(StrefaRepo strefaRepo) {
        this.strefaRepo = strefaRepo;
    }


    public Iterable<Strefa> findAll(){
        return strefaRepo.findAll();
    }

    public Optional<Strefa> findById(Long id){
        return strefaRepo.findById(id);
    }

    public Strefa save(Strefa strefa){
        return strefaRepo.save(strefa);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB1(){
        save(new Strefa("pomaranczowa", "z gumy", 2, 15));
        save(new Strefa("niebieska", "wodna", 6 , 30));
    }



}
