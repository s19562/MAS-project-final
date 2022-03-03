package com.example.demo.gui;

import com.example.demo.api.RezerwacjaApi;
import com.example.demo.dao.entity.Animator;
import com.example.demo.dao.entity.Atrakcja;
import com.example.demo.dao.entity.Klient;
import com.example.demo.dao.entity.Rezerwacja;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;

//@Route("Rezerwacje")
@Route(value = "rezerwacje", layout = MainGui.class)
@PageTitle("Rezerwacje")
public class TabRezGui extends VerticalLayout {

    private RezerwacjaApi rezerwacjaApi;

    public TabRezGui(RezerwacjaApi rezerwacjaApi){

        Grid<Rezerwacja> grid = new Grid<>(Rezerwacja.class);
        grid.setItems((List<Rezerwacja>)rezerwacjaApi.getAll());
        grid.removeColumnByKey("animator");
        grid.removeColumnByKey("atrakcja");
        grid.removeColumnByKey("klient");

        grid.addColumn(rezerwacja -> {
            Animator animator = rezerwacja.getAnimator();
            return rezerwacja == null ? "-" : animator.getOsoba().getNazwisko();

        }).setHeader("Animator");

        grid.addColumn(rezerwacja -> {
            Atrakcja atrakcja = rezerwacja.getAtrakcja();
            return rezerwacja == null ? "-" : atrakcja.getNazwa();

        }).setHeader("Atrakcja");

        grid.addColumn(rezerwacja -> {
            Klient klient = rezerwacja.getKlient();
            return rezerwacja == null ? "-" : klient.getEmail();

        }).setHeader("Klient");

        grid.getColumns().forEach(col -> col.setAutoWidth(true));


        add(new H1("Tabela rezerwacji"),grid);

    }





}
