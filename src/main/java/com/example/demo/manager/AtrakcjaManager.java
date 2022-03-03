package com.example.demo.manager;

import com.example.demo.dao.AtrakcjaRepo;
import com.example.demo.dao.entity.Atrakcja;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class AtrakcjaManager {

    private AtrakcjaRepo atrakcjaRepo;
    private StrefaManager strefaManager;


    @Autowired
    public AtrakcjaManager(AtrakcjaRepo atrakcjaRepo, StrefaManager strefaManager) {
        this.atrakcjaRepo = atrakcjaRepo;
        this.strefaManager = strefaManager;
    }


    public Iterable<Atrakcja> findAll(){
        return atrakcjaRepo.findAll();
    }

    public Atrakcja save(Atrakcja atrakcja){
        return atrakcjaRepo.save(atrakcja);
    }


}
