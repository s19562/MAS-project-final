package com.example.demo.dao.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Rezerwacja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Rezerwacja() {
    }

    public Rezerwacja(int numer, LocalDateTime dataGodzinaRezerwacji, int liczkaOsob, StatusRezerwacji statusRezerwacji, Atrakcja atrakcja, Klient klient, Animator animator) {
        this.numer = numer;
        this.dataGodzinaRezerwacji = dataGodzinaRezerwacji;
        this.liczkaOsob = liczkaOsob;
        this.statusRezerwacji = statusRezerwacji;
        this.atrakcja = atrakcja;
        this.klient = klient;
        this.animator = animator;
    }


    @Column(unique = true)
    private int numer;

    private LocalDateTime dataGodzinaRezerwacji;
    private int liczkaOsob;

    @Enumerated(EnumType.STRING)
    private StatusRezerwacji statusRezerwacji;

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

    public LocalDateTime getDataGodzinaRezerwacji() {
        return dataGodzinaRezerwacji;
    }

    public void setDataGodzinaRezerwacji(LocalDateTime dataGodzinaRezerwacji) {
        this.dataGodzinaRezerwacji = dataGodzinaRezerwacji;
    }

    public int getLiczkaOsob() {
        return liczkaOsob;
    }

    public void setLiczkaOsob(int liczkaOsob) {
        this.liczkaOsob = liczkaOsob;
    }

    public StatusRezerwacji getStatusRezerwacji() {
        return statusRezerwacji;
    }

    public void setStatusRezerwacji(StatusRezerwacji statusRezerwacji) {
        this.statusRezerwacji = statusRezerwacji;
    }

    @ManyToOne
    @JoinColumn(name = "atrakcja_id", nullable = false)
    private Atrakcja atrakcja;

    @ManyToOne
    @JoinColumn(name = "klient_id", nullable = false)
    private Klient klient;

    @ManyToOne
    @JoinColumn(name = "animator_id", nullable = false)
    private Animator animator;

    public Atrakcja getAtrakcja() {
        return atrakcja;
    }

    public void setAtrakcja(Atrakcja atrakcja) {
        this.atrakcja = atrakcja;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public Animator getAnimator() {
        return animator;
    }

    public void setAnimator(Animator animator) {
        this.animator = animator;
    }
}
