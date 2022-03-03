package com.example.demo.dao.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class KlientIndywidualny extends Klient{


    public KlientIndywidualny(int numerTel, String adres, String email, int numerKlienta, Osoba osoba) {
        super(numerTel, adres, email);
        this.numerKlienta = numerKlienta;
        this.osoba = osoba;
        osoba.setKlientIndywidualny(this);
    }

    public KlientIndywidualny() {

    }

    @Column(unique = true)
    private int numerKlienta;

    public int getNumerKlienta() {
        return numerKlienta;
    }

    public void setNumerKlienta(int numerKlienta) {
        this.numerKlienta = numerKlienta;
    }

    @ManyToOne
    @JoinColumn(name = "osoba_id", nullable = false)
    private Osoba osoba;

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }
}
