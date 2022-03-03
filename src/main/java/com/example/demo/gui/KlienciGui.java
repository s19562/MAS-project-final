package com.example.demo.gui;


import com.example.demo.api.KlientApi;
import com.example.demo.dao.RezerwacjaRepo;
import com.example.demo.dao.entity.Animator;
import com.example.demo.dao.entity.Atrakcja;
import com.example.demo.dao.entity.Klient;
import com.example.demo.dao.entity.Rezerwacja;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;

//@Route("Klient i jego rezerwacje")
@Route(value = "klienci", layout = MainGui.class)
@PageTitle("Rezerwacje klientów")
public class KlienciGui extends VerticalLayout {

    private KlientApi klientApi;
    private RezerwacjaRepo rezerwacjaRepo;

    public KlienciGui(KlientApi klientApi, RezerwacjaRepo rezerwacjaRepo) {
        this.klientApi = klientApi;
        this.rezerwacjaRepo = rezerwacjaRepo;

        Select<Klient> select = new Select<>();
        select.setLabel("Klient");
        List<Klient> klientList = (List<Klient>) klientApi.getAll();
// Choose which property from Department is the presentation value
        select.setItemLabelGenerator(Klient::getEmail);
        select.setItems(klientList);

        Button buttonAdd = new Button("Pokaz rezerwacje");


        Grid<Rezerwacja> grid = new Grid<>(Rezerwacja.class);

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



        buttonAdd.addClickListener(clickEvent -> {


//            String email = select.getValue().getEmail();
//            grid.setItems((List<Rezerwacja>)rezerwacjaRepo.search(email));

            Klient klient = select.getValue();
            grid.setItems(klient.getRezerwacje());


            grid.getColumns().forEach(col -> col.setAutoWidth(true));

            add(grid);

        });

        add(new H1("Rezerwacje klienta"), select, buttonAdd);





    }


}
