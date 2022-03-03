package com.example.demo.dao;


import com.example.demo.dao.entity.Atrakcja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtrakcjaRepo extends CrudRepository<Atrakcja, Long> {

}
