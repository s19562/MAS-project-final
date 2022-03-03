package com.example.demo.dao;


import com.example.demo.dao.entity.Magazyn;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagazynRepo extends CrudRepository<Magazyn, Long> {

}
