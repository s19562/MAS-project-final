package com.example.demo.dao.entity;


import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Animator extends Pracownik {


    public Animator() {
    }

    public Animator(LocalDate dataZatrudnienia, double stawka, int przepracowaneGodziny, String uwagii, Osoba osoba, boolean badanie) {
        super(dataZatrudnienia, stawka, przepracowaneGodziny, uwagii, osoba);
        osoba.setPracownik(this);
        this.badanie = badanie;
    }

    private boolean badanie;


    public boolean isBadanie() {
        return badanie;
    }

    public void setBadanie(boolean badanie) {
        this.badanie = badanie;
    }

    @OneToMany(mappedBy = "animator")
    @Nullable
    private List<Rezerwacja> rezerwacje = new ArrayList<>();

    @Nullable
    public List<Rezerwacja> getRezerwacje() {
        return rezerwacje;
    }

    public void setRezerwacje(@Nullable List<Rezerwacja> rezerwacje) {
        this.rezerwacje = rezerwacje;
    }

    public void addRezerwacja(Rezerwacja rezerwacja){
        this.rezerwacje.add(rezerwacja);
    }


}
