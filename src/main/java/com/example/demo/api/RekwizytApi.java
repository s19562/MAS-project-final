package com.example.demo.api;


import com.example.demo.dao.entity.Rekwizyt;
import com.example.demo.manager.RekwizytManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/rekwizyty")
public class RekwizytApi {


    private RekwizytManager rekwizytManager;


    @Autowired
    public RekwizytApi(RekwizytManager rekwizytManager) {
        this.rekwizytManager = rekwizytManager;
    }


    @GetMapping("/all")
    public Iterable<Rekwizyt> getAll(){
        return rekwizytManager.findAll();
    }


    @GetMapping
    public Optional<Rekwizyt> getById(@RequestParam long index){
        return rekwizytManager.findById(index);
    }



}
