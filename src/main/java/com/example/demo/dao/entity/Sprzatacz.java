package com.example.demo.dao.entity;


import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Sprzatacz extends Pracownik{


    public Sprzatacz() {
    }


    public Sprzatacz(LocalDate dataZatrudnienia, double stawka, int przepracowaneGodziny, String uwagii, Osoba osoba, boolean student, boolean niepelnosprawny) {
        super(dataZatrudnienia, stawka, przepracowaneGodziny, uwagii, osoba);
        osoba.setPracownik(this);
        this.student = student;
        this.niepelnosprawny = niepelnosprawny;
    }

    private boolean student;
    private boolean niepelnosprawny;



    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public boolean isNiepelnosprawny() {
        return niepelnosprawny;
    }

    public void setNiepelnosprawny(boolean niepelnosprawny) {
        this.niepelnosprawny = niepelnosprawny;
    }
}
