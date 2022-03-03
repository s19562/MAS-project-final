package com.example.demo.manager;


import com.example.demo.dao.KlientRepo;
import com.example.demo.dao.entity.Klient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KlientManager {

    private KlientRepo klientRepo;

    @Autowired
    public KlientManager(KlientRepo klientRepo) {
        this.klientRepo = klientRepo;
    }


    public Optional<Klient> findById(Long id){
        return klientRepo.findById(id);
    }

    public Iterable<Klient> findAll(){
        return klientRepo.findAll();
    }




}
