package com.example.demo.dao;

import com.example.demo.dao.entity.Klient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlientRepo extends CrudRepository<Klient, Long> {


}
