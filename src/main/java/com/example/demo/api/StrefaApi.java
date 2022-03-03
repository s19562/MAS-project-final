package com.example.demo.api;



import com.example.demo.dao.entity.Strefa;
import com.example.demo.manager.StrefaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/strefa")
public class StrefaApi {


    private StrefaManager strefaManager;


    @Autowired
    public StrefaApi(StrefaManager strefaManager) {
        this.strefaManager = strefaManager;
    }

    @GetMapping("/all")
    public Iterable<Strefa> getAll(){
        return strefaManager.findAll();
    }

    @PostMapping
    public Strefa addStrefa(@RequestBody Strefa strefa){
        return strefaManager.save(strefa);
    }

    @GetMapping
    public Optional<Strefa> getById(@RequestParam long index){
        return strefaManager.findById(index);
    }



}
