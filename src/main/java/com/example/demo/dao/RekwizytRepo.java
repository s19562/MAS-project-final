package com.example.demo.dao;


import com.example.demo.dao.entity.Rekwizyt;
import com.example.demo.dao.entity.Rezerwacja;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RekwizytRepo extends CrudRepository<Rekwizyt, Long> {

    @Query("select c from Rekwizyt c " +
            "where lower(c.nazwa) like lower(concat('%', :searchTerm, '%')) ")
    List<Rekwizyt> search(@Param("searchTerm") String searchTerm);

}
