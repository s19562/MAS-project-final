package com.example.demo.dao;


import com.example.demo.dao.entity.Strefa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrefaRepo extends CrudRepository<Strefa, Long> {

}
