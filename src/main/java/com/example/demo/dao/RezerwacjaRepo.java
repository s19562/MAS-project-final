package com.example.demo.dao;


import com.example.demo.dao.entity.Rezerwacja;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RezerwacjaRepo extends CrudRepository<Rezerwacja, Long> {

//    @Query("select c from Rezerwacja c " +
//            "where lower(c.klient.email) like lower(concat('%', :searchTerm, '%')) ")
//    List<Rezerwacja> search(@Param("searchTerm") String searchTerm);


}

