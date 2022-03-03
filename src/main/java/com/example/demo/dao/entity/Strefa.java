package com.example.demo.dao.entity;


import com.example.demo.dao.entity.Atrakcja;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Strefa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Strefa() {
    }

    public Strefa(String name, String opis, int minWiekWejscia, double cenaZaWejscie) {
        this.name = name;
        this.opis = opis;
        this.minWiekWejscia = minWiekWejscia;
        this.cenaZaWejscie = cenaZaWejscie;
    }

    private String name;
    private String opis;
    private int minWiekWejscia;
    private double cenaZaWejscie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getMinWiekWejscia() {
        return minWiekWejscia;
    }

    public void setMinWiekWejscia(int minWiekWejscia) {
        this.minWiekWejscia = minWiekWejscia;
    }

    public double getCenaZaWejscie() {
        return cenaZaWejscie;
    }

    public void setCenaZaWejscie(double cenaZaWejscie) {
        this.cenaZaWejscie = cenaZaWejscie;
    }

    @OneToMany(mappedBy = "strefa")
    @Nullable
    private List<Atrakcja> atrakcje = new ArrayList<>();

    public List<Atrakcja> getAtrakcje() {
        return atrakcje;
    }

    public void setAtrakcje(List<Atrakcja> atrakcje) {
        this.atrakcje = atrakcje;
    }

//    public void addAtrakcja(Atrakcja atrakcja){
//        this.atrakcje.add(atrakcja);
//    }
}
