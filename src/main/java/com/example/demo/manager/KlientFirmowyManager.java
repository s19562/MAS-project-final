package com.example.demo.manager;


import com.example.demo.dao.KlientFirmowyRepo;
import com.example.demo.dao.entity.KlientFirmowy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class KlientFirmowyManager {

    private KlientFirmowyRepo klientFirmowyRepo;

    @Autowired
    public KlientFirmowyManager(KlientFirmowyRepo klientFirmowyRepo) {
        this.klientFirmowyRepo = klientFirmowyRepo;
    }


        public KlientFirmowy save(KlientFirmowy klientFirmowy){
        return klientFirmowyRepo.save(klientFirmowy);
    }

        @EventListener(ApplicationReadyEvent.class)
        public void fillDB(){
        save(new KlientFirmowy(733633533 , "Poznan ul. Mala" , "emka@wp.pl", "DuzyBen"));
        save(new KlientFirmowy(988900977 , "Warszawa ul. Duza" , "wppi@wp.pl", "MalyWojtek"));
    }



}
