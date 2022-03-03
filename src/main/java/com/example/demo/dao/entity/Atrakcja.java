package com.example.demo.dao.entity;


import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Atrakcja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Atrakcja() {
    }

    public Atrakcja(String nazwa, StopienTrudnosci stopienTrudnosci, double koszt, Strefa strefa) {
        this.nazwa = nazwa;
        this.stopienTrudnosci = stopienTrudnosci;
        this.koszt = koszt;
        this.strefa = strefa;
//        strefa.addAtrakcja(this);
    }

    private String nazwa;

    @Enumerated(EnumType.STRING)
    private StopienTrudnosci stopienTrudnosci;

    private double koszt;

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

    public StopienTrudnosci getStopienTrudnosci() {
        return stopienTrudnosci;
    }

    public void setStopienTrudnosci(StopienTrudnosci stopienTrudnosci) {
        this.stopienTrudnosci = stopienTrudnosci;
    }

    public double getKoszt() {
        return koszt;
    }

    public void setKoszt(double koszt) {
        this.koszt = koszt;
    }

    @ManyToOne
    @JoinColumn(name = "strefa_id", nullable = false)
    private Strefa strefa;

    public Strefa getStrefa() {
        return strefa;
    }

    public void setStrefa(Strefa strefa) {
        this.strefa = strefa;
    }

    @OneToMany(mappedBy = "atrakcja")
    private List<Rezerwacja> rezerwacje = new ArrayList<>();

    public List<Rezerwacja> getRezerwacje() {
        return rezerwacje;
    }

    public void setRezerwacje(List<Rezerwacja> rezerwacje) {
        this.rezerwacje = rezerwacje;
    }

    public void addRezerwacja(Rezerwacja rezerwacja){
        this.rezerwacje.add(rezerwacja);
    }

    @ManyToMany
            (cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    @JoinTable(
            name = "Atrakcja_Rekwizyt",
            joinColumns = { @JoinColumn(name = "atrakcja_id")},
            inverseJoinColumns = { @JoinColumn(name = "rekwizyt_id")}
    )
    @Nullable
    private Set<Rekwizyt> rekwizyty = new HashSet<>();

    @Nullable
    public Set<Rekwizyt> getRekwizyty() {
        return rekwizyty;
    }

    public void setRekwizyty(@Nullable Set<Rekwizyt> rekwizyty) {
        this.rekwizyty = rekwizyty;
    }


}
