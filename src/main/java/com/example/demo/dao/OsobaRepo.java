package com.example.demo.dao;


import com.example.demo.dao.entity.Osoba;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OsobaRepo  extends CrudRepository<Osoba, Long> {
}
