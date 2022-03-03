package com.example.demo.manager;


import com.example.demo.dao.RekwizytRepo;
import com.example.demo.dao.entity.Rekwizyt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RekwizytManager {


    private RekwizytRepo rekwizytRepo;

    @Autowired
    public RekwizytManager(RekwizytRepo rekwizytRepo) {
        this.rekwizytRepo = rekwizytRepo;
    }


    public Optional<Rekwizyt> findById(Long id){
        return rekwizytRepo.findById(id);
    }

    public Iterable<Rekwizyt> findAll(){
        return rekwizytRepo.findAll();
    }

}
