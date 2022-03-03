package com.example.demo.dao;


import com.example.demo.dao.entity.KlientFirmowy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlientFirmowyRepo extends CrudRepository<KlientFirmowy , Long> {
}
