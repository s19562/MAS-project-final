package com.example.demo.manager;


import com.example.demo.dao.RezerwacjaRepo;
import com.example.demo.dao.entity.Rezerwacja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RezerwacjaManager {

    private RezerwacjaRepo rezerwacjaRepo;

    @Autowired
    public RezerwacjaManager(RezerwacjaRepo rezerwacjaRepo) {
        this.rezerwacjaRepo = rezerwacjaRepo;
    }


    public Iterable<Rezerwacja> findAll(){
        return rezerwacjaRepo.findAll();
    }

    public Optional<Rezerwacja> findById(Long id){
        return rezerwacjaRepo.findById(id);
    }

    public Rezerwacja save(Rezerwacja rezerwacja){
        return rezerwacjaRepo.save(rezerwacja);
    }



}
