package com.example.demo.dao.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Klient {

    public Klient() {
    }

    public Klient(int numerTel, String adres, String email) {
        this.numerTel = numerTel;
        this.adres = adres;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numerTel;
    private String adres;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumerTel() {
        return numerTel;
    }

    public void setNumerTel(int numerTel) {
        this.numerTel = numerTel;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "klient")
    private List<Rezerwacja> rezerwacje = new ArrayList<>(); //TUTAJ WYCIAGNAJ ! BEZPOSREDNIO Z BAZY A NIE SELECTEM W REPO

    public List<Rezerwacja> getRezerwacje() {
        return rezerwacje;
    }

    public void setRezerwacje(List<Rezerwacja> rezerwacje) {
        this.rezerwacje = rezerwacje;
    }
}
