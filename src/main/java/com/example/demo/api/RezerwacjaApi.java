package com.example.demo.api;


import com.example.demo.dao.entity.Rezerwacja;
import com.example.demo.manager.RezerwacjaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/rezerwacje")
public class RezerwacjaApi {

    private RezerwacjaManager rezerwacjaManager;

    @Autowired
    public RezerwacjaApi(RezerwacjaManager rezerwacjaManager) {
        this.rezerwacjaManager = rezerwacjaManager;
    }

    @GetMapping("/all")
    public Iterable<Rezerwacja> getAll(){
        return rezerwacjaManager.findAll();
    }

    @PostMapping
    public Rezerwacja addRezerwacja(@RequestBody Rezerwacja rezerwacja){
        return rezerwacjaManager.save(rezerwacja);
    }

    @GetMapping
    public Optional<Rezerwacja> getById(@RequestParam long index){
        return rezerwacjaManager.findById(index);
    }



}
