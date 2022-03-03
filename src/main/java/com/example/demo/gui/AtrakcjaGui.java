package com.example.demo.gui;


import com.example.demo.dao.AtrakcjaRepo;
import com.example.demo.dao.RekwizytRepo;
import com.example.demo.dao.entity.Atrakcja;
import com.example.demo.dao.entity.Rekwizyt;
import com.example.demo.dao.entity.Rezerwacja;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


import java.util.List;
import java.util.Set;

@Route(value = "atrakcje", layout = MainGui.class)
@PageTitle("Atrakcje i rekwizyty")
public class AtrakcjaGui extends VerticalLayout {


    private AtrakcjaRepo atrakcjaRepo;
    private RekwizytRepo rekwizytRepo;

    public AtrakcjaGui(AtrakcjaRepo atrakcjaRepo, RekwizytRepo rekwizytRepo) {
        this.atrakcjaRepo = atrakcjaRepo;
        this.rekwizytRepo = rekwizytRepo;

        Select<Atrakcja> select = new Select<>();
        select.setLabel("Atrakcja");
        List<Atrakcja> atrakcjaList = (List<Atrakcja>) atrakcjaRepo.findAll();
// Choose which property from Department is the presentation value
        select.setItemLabelGenerator(Atrakcja::getNazwa);
        select.setItems(atrakcjaList);

        Button buttonAdd = new Button("Pokaz rekwizyty");

        Grid<Rekwizyt> grid = new Grid<>(Rekwizyt.class);


        buttonAdd.addClickListener(clickEvent -> {


            Set<Rekwizyt> rekwizyty = select.getValue().getRekwizyty();
            System.out.println(rekwizyty);
            grid.setItems(rekwizyty);


            grid.getColumns().forEach(col -> col.setAutoWidth(true));

            add(grid);

        });

        add(new H1("Rekwizyty do atrakcji"), select, buttonAdd);








    }
}
