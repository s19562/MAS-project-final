package com.example.demo.dao.entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Osoba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Osoba() {
    }

    public Osoba(String imie, String nazwisko, LocalDate dataUro) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUro = dataUro;
    }


    private String imie;
    private String nazwisko;
    private LocalDate dataUro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public LocalDate getDataUro() {
        return dataUro;
    }

    public void setDataUro(LocalDate dataUro) {
        this.dataUro = dataUro;
    }

    @OneToOne
    @JoinColumn(name = "klientIndywidualny_id", nullable = true)
    private KlientIndywidualny klientIndywidualny;

    @OneToOne
    @JoinColumn(name = "pracownik_id", nullable = true)
    private Pracownik pracownik;

    public KlientIndywidualny getKlientIndywidualny() {
        return klientIndywidualny;
    }

    public void setKlientIndywidualny(KlientIndywidualny klientIndywidualny) {
        this.klientIndywidualny = klientIndywidualny;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }
}
