package com.example.demo.api;


import com.example.demo.dao.entity.Klient;
import com.example.demo.manager.KlientManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/klienci")
public class KlientApi {

    private KlientManager klientManager;

    @Autowired
    public KlientApi(KlientManager klientManager) {
        this.klientManager = klientManager;
    }

    @GetMapping("/all")
    public Iterable<Klient> getAll(){
        return klientManager.findAll();
    }

    @GetMapping
    public Optional<Klient> getById(@RequestParam long index){
        return klientManager.findById(index);
    }



}
