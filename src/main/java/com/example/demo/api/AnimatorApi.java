package com.example.demo.api;


import com.example.demo.dao.entity.Animator;
import com.example.demo.manager.AnimatorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/animatorzy")
public class AnimatorApi {

    private AnimatorManager animatorManager;

    @Autowired
    public AnimatorApi(AnimatorManager animatorManager) {
        this.animatorManager = animatorManager;
    }

    @GetMapping("/all")
    public Iterable<Animator> getAll(){
        return animatorManager.findAll();
    }

    @GetMapping
    public Optional<Animator> getById(@RequestParam long index){
        return animatorManager.findById(index);
    }




}
