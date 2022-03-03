package com.example.demo.dao.entity;


import javax.persistence.Entity;

@Entity
public class KlientFirmowy extends Klient {

    public KlientFirmowy() {

    }

    public KlientFirmowy(int numerTel, String adres, String email, String nazwaFirmy) {
        super(numerTel, adres, email);
        this.nazwaFirmy = nazwaFirmy;
    }

    private String nazwaFirmy;

    public String getNazwaFirmy() {
        return nazwaFirmy;
    }

    public void setNazwaFirmy(String nazwaFirmy) {
        this.nazwaFirmy = nazwaFirmy;
    }





}
