package com.example.demo;

import com.example.demo.dao.*;
import com.example.demo.dao.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class Start {

    private StrefaRepo strefaRepo;
    private AtrakcjaRepo atrakcjaRepo;
    private RekwizytRepo rekwizytRepo;

    private OsobaRepo osobaRepo;
    private AnimatorRepo animatorRepo;

    private RezerwacjaRepo rezerwacjaRepo;

    private KlientFirmowyRepo klientFirmowyRepo;

    private MagazynRepo magazynRepo;


    @Autowired
    public Start(StrefaRepo strefaRepo, AtrakcjaRepo atrakcjaRepo, RekwizytRepo rekwizytRepo,
                 OsobaRepo osobaRepo, AnimatorRepo animatorRepo, RezerwacjaRepo rezerwacjaRepo,
                 KlientFirmowyRepo klientFirmowyRepo, MagazynRepo magazynRepo) {
        this.strefaRepo = strefaRepo;
        this.atrakcjaRepo = atrakcjaRepo;
        this.rekwizytRepo = rekwizytRepo;
        this.osobaRepo = osobaRepo;
        this.animatorRepo = animatorRepo;
        this.rezerwacjaRepo = rezerwacjaRepo;
        this.klientFirmowyRepo = klientFirmowyRepo;
        this.magazynRepo = magazynRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runExample(){

        Strefa strefa1 = new Strefa("zielona", "z trawy", 3, 1);
        strefaRepo.save(strefa1);

        Atrakcja atrakcja1 = new Atrakcja("zjezdzalnia", StopienTrudnosci.sredni, 2.00, strefa1);
        atrakcjaRepo.save(atrakcja1);

        Atrakcja atrakcja3 = new Atrakcja("malowanie", StopienTrudnosci.trudny, 5.00, strefa1);
        atrakcjaRepo.save(atrakcja3);

        Magazyn magazyn1 = new Magazyn(33, 33, 33);
        magazynRepo.save(magazyn1);

        Rekwizyt rekwizyt1 = new Rekwizyt("maska", "karnawalowa", magazyn1);
        rekwizytRepo.save(rekwizyt1);

        Rekwizyt rekwizyt2 = new Rekwizyt("balony", "z helem", magazyn1);
        rekwizytRepo.save(rekwizyt2);

        Rekwizyt rekwizyt3 = new Rekwizyt("farby", "akrylowe", magazyn1);
        rekwizytRepo.save(rekwizyt3);

        Rekwizyt rekwizyt4 = new Rekwizyt("czapeczki", "moga byc na urodzinki", magazyn1);
        rekwizytRepo.save(rekwizyt4);

        Rekwizyt rekwizyt5 = new Rekwizyt("banki", "mydlane", magazyn1);
        rekwizytRepo.save(rekwizyt5);

        Osoba osoba1 = new Osoba("Patrycja", "Dankowska", LocalDate.of(2020 , 10 , 10));
        osobaRepo.save(osoba1);

        Osoba osoba2 = new Osoba("Stefan", "Musk", LocalDate.of(2020 , 10 , 10));
        osobaRepo.save(osoba2);

        Animator animator1 = new Animator(LocalDate.of(2020 , 3 , 5), 18.00 ,
                34, "brak", osoba1, true);
        animatorRepo.save(animator1);

        Animator animator2 = new Animator(LocalDate.of(2020 , 3 , 5), 12.00 ,
                30, "brak", osoba2, true);
        animatorRepo.save(animator2);

        KlientFirmowy klientFirmowy1 = new KlientFirmowy(447755446 , "Gdynia ul. Morska" , "morze@wp.pl", "Stocznia");
        klientFirmowyRepo.save(klientFirmowy1);

        Rezerwacja rezerwacja1 = new Rezerwacja(11, LocalDateTime.now(), 20, StatusRezerwacji.PRZYJETA, atrakcja1, klientFirmowy1, animator1 );
        rezerwacjaRepo.save(rezerwacja1);

        Rezerwacja rezerwacja2 = new Rezerwacja(13, LocalDateTime.now(), 22, StatusRezerwacji.PRZYJETA, atrakcja3, klientFirmowy1, animator1 );
        rezerwacjaRepo.save(rezerwacja2);



        System.out.println(osoba1.getPracownik());

    }



}
