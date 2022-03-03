package com.example.demo.gui;


import com.example.demo.api.AtrakcjaApi;
import com.example.demo.api.RekwizytApi;
import com.example.demo.dao.entity.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;


@Route(value = "rekwizyty", layout = MainGui.class)
@PageTitle("Dodanie rekwizytów")
public class RekwizytyAddGui extends VerticalLayout {

    private AtrakcjaApi atrakcjaApi;
    private RekwizytApi rekwizytApi;

    public RekwizytyAddGui(AtrakcjaApi atrakcjaApi, RekwizytApi rekwizytApi) {
        this.atrakcjaApi = atrakcjaApi;
        this.rekwizytApi = rekwizytApi;


        Select<Atrakcja> select1 = new Select<>();
        select1.setLabel("Atrakcja");
        List<Atrakcja> atrakcjaList = (List<Atrakcja>) atrakcjaApi.getAll();
// Choose which property from Department is the presentation value
        select1.setItemLabelGenerator(Atrakcja::getNazwa);
        select1.setItems(atrakcjaList);

        MultiSelectListBox<Rekwizyt> listBox = new MultiSelectListBox<>();
        listBox.setItems((List<Rekwizyt>)rekwizytApi.getAll());

        Button buttonAdd = new Button("Dodaj rekwizyty do atrakcji");

        buttonAdd.addClickListener(clickEvent -> {
            select1.getValue().setRekwizyty(listBox.getValue());
            Notification notification = new Notification("Rekwizyty dodane", 3000);
            notification.open();

            System.out.println(select1.getValue().getRekwizyty());

        });

        add(new H1("Dodaj rekwizyty do atrakcji"),select1, listBox , buttonAdd);












    }
}
