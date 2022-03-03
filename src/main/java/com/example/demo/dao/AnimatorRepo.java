package com.example.demo.dao;


import com.example.demo.dao.entity.Animator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimatorRepo extends CrudRepository<Animator, Long> {

}
