package com.example.demo.api;


import com.example.demo.dao.entity.Atrakcja;
import com.example.demo.manager.AtrakcjaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/atrakcje")
public class AtrakcjaApi {


    private AtrakcjaManager atrakcjaManager;

    @Autowired
    public AtrakcjaApi(AtrakcjaManager atrakcjaManager) {
        this.atrakcjaManager = atrakcjaManager;
    }


    @GetMapping("/all")
    public Iterable<Atrakcja> getAll(){
        return atrakcjaManager.findAll();
    }


    @PostMapping
    public Atrakcja addAtrakcja(@RequestBody Atrakcja atrakcja){
        return atrakcjaManager.save(atrakcja);
    }



}
