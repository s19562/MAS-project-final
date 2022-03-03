package com.example.demo.dao.entity;


import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pracownik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Pracownik() {
    }

    public Pracownik(LocalDate dataZatrudnienia, double stawka, int przepracowaneGodziny, @Nullable String uwagii, Osoba osoba) {
        this.dataZatrudnienia = dataZatrudnienia;
        this.stawka = stawka;
        this.przepracowaneGodziny = przepracowaneGodziny;
        this.uwagii = uwagii;
        this.osoba = osoba;
        osoba.setPracownik(this);
    }

    private LocalDate dataZatrudnienia;

    private double stawka;

    private int przepracowaneGodziny;

    @Nullable
    private String uwagii;

    public Long getId() {
        return id;
    }

    public String getIdSting() {
        return Long.toString(id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataZatrudnienia() {
        return dataZatrudnienia;
    }

    public void setDataZatrudnienia(LocalDate dataZatrudnienia) {
        this.dataZatrudnienia = dataZatrudnienia;
    }

    public double getStawka() {
        return stawka;
    }

    public void setStawka(double stawka) {
        this.stawka = stawka;
    }

    public int getPrzepracowaneGodziny() {
        return przepracowaneGodziny;
    }

    public void setPrzepracowaneGodziny(int przepracowaneGodziny) {
        this.przepracowaneGodziny = przepracowaneGodziny;
    }

    @Nullable
    public String getUwagii() {
        return uwagii;
    }

    public void setUwagii(@Nullable String uwagii) {
        this.uwagii = uwagii;
    }

    @OneToOne
    @JoinColumn(name = "osoba_id", nullable = false)
    private Osoba osoba;

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }
}
