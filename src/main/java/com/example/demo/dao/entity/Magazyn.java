package com.example.demo.dao.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Magazyn {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private int numer;

    private int powierzchnia;

    private int iloscSchowkow;

    public Magazyn(int numer, int powierzchnia, int iloscSchowkow) {
        this.numer = numer;
        this.powierzchnia = powierzchnia;
        this.iloscSchowkow = iloscSchowkow;
    }

    public Magazyn() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    public int getPowierzchnia() {
        return powierzchnia;
    }

    public void setPowierzchnia(int powierzchnia) {
        this.powierzchnia = powierzchnia;
    }

    public int getIloscSchowkow() {
        return iloscSchowkow;
    }

    public void setIloscSchowkow(int iloscSchowkow) {
        this.iloscSchowkow = iloscSchowkow;
    }

    @OneToMany(mappedBy = "magazyn")
    private List<Rekwizyt> rekwizyty = new ArrayList<>();

    public List<Rekwizyt> getRekwizyty() {
        return rekwizyty;
    }

    public void setRekwizyty(List<Rekwizyt> rekwizyty) {
        this.rekwizyty = rekwizyty;
    }



}
