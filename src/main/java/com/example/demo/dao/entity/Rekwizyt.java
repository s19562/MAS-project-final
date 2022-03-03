package com.example.demo.dao.entity;



import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Rekwizyt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Rekwizyt() {
    }

    public Rekwizyt(String nazwa, String opis, Magazyn magazyn) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.magazyn = magazyn;
    }

    private String nazwa;
    private String opis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @ManyToOne
    @JoinColumn(name = "magazyn_id", nullable = false)
    private Magazyn magazyn;

    public Magazyn getMagazyn() {
        return magazyn;
    }

    public void setMagazyn(Magazyn magazyn) {
        this.magazyn = magazyn;
    }

    @ManyToMany
            (mappedBy = "rekwizyty", fetch = FetchType.EAGER)
    @Nullable
    private Set<Atrakcja> atrakcje = new HashSet<>();

    @Nullable
    public Set<Atrakcja> getAtrakcje() {
        return atrakcje;
    }

    public void setAtrakcje(@Nullable Set<Atrakcja> atrakcje) {
        this.atrakcje = atrakcje;
    }



    @Override
    public String toString() {
        return  nazwa;

    }
}
