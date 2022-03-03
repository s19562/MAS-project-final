package com.example.demo.api;


import com.example.demo.dao.entity.KlientFirmowy;
import com.example.demo.manager.KlientFirmowyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/klienci/firmowi")
public class KlientFirmowyApi {


    private KlientFirmowyManager klientFirmowyManager;

    @Autowired
    public KlientFirmowyApi(KlientFirmowyManager klientFirmowyManager) {
        this.klientFirmowyManager = klientFirmowyManager;
    }

    @PostMapping
        public KlientFirmowy addKlient(@RequestBody KlientFirmowy klientFirmowy){
        return klientFirmowyManager.save(klientFirmowy);
    }




}
