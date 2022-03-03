package com.example.demo.manager;


import com.example.demo.dao.AnimatorRepo;
import com.example.demo.dao.entity.Animator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnimatorManager {

    private AnimatorRepo animatorRepo;

    @Autowired
    public AnimatorManager(AnimatorRepo animatorRepo) {
        this.animatorRepo = animatorRepo;
    }


    public Optional<Animator> findById(Long id){
        return animatorRepo.findById(id);
    }

    public Iterable<Animator> findAll(){
        return animatorRepo.findAll();
    }





}
