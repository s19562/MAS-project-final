package com.example.demo.gui;


import com.example.demo.api.AnimatorApi;
import com.example.demo.api.AtrakcjaApi;
import com.example.demo.api.KlientApi;
import com.example.demo.dao.RezerwacjaRepo;
import com.example.demo.dao.entity.*;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.notification.*;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;


@Route(value = "", layout = MainGui.class)
@PageTitle("Dodanie rezerwacji")
public class DodajRezGui extends VerticalLayout {

    private KlientApi klientApi;
    private AtrakcjaApi atrakcjaApi;
    private AnimatorApi animatorApi;
    private RezerwacjaRepo rezerwacjaRepo;



    public DodajRezGui(KlientApi klientApi, AtrakcjaApi atrakcjaApi, AnimatorApi animatorApi, RezerwacjaRepo rezerwacjaRepo) {

        this.klientApi = klientApi;
        this.animatorApi = animatorApi;
        this.atrakcjaApi =atrakcjaApi;
        this.rezerwacjaRepo = rezerwacjaRepo;



        TextField textField1 = new TextField("numer rezerwacji");
        TextField textField2 = new TextField("liczka osób");
        ComboBox<StatusRezerwacji> statusBox = new ComboBox<>("Status: ", StatusRezerwacji.PRZYJETA);
        statusBox.setReadOnly(true);
        statusBox.setValue(StatusRezerwacji.PRZYJETA);
        DateTimePicker labelDateTimePicker = new DateTimePicker();
        labelDateTimePicker.setLabel("Data i czas");



        Select<Klient> select = new Select<>();
        select.setLabel("Klient");
        List<Klient> klientList = (List<Klient>) klientApi.getAll();
// Choose which property from Department is the presentation value
        select.setItemLabelGenerator(Klient::getEmail);
        select.setItems(klientList);

        Select<Atrakcja> select1 = new Select<>();
        select1.setLabel("Atrakcja");
        List<Atrakcja> atrakcjaList = (List<Atrakcja>) atrakcjaApi.getAll();
// Choose which property from Department is the presentation value
        select1.setItemLabelGenerator(Atrakcja::getNazwa);
        select1.setItems(atrakcjaList);

        Select<Animator> select2 = new Select<>();
        select2.setLabel("Animator");
        List<Animator> animatorList = (List<Animator>) animatorApi.getAll();
// Choose which property from Department is the presentation value
        select2.setItemLabelGenerator(Animator::getIdSting);
        select2.setItems(animatorList);

        Button buttonAdd = new Button("Dodaj rezerwacje");

        buttonAdd.addClickListener(clickEvent -> {
            Rezerwacja rezerwacja = new Rezerwacja();
            rezerwacja.setNumer(Integer.valueOf(textField1.getValue()));
            rezerwacja.setLiczkaOsob(Integer.valueOf(textField2.getValue()));
            rezerwacja.setStatusRezerwacji(StatusRezerwacji.PRZYJETA);
            rezerwacja.setDataGodzinaRezerwacji(labelDateTimePicker.getValue());
            rezerwacja.setKlient(select.getValue());
            rezerwacja.setAtrakcja(select1.getValue());
            rezerwacja.setAnimator(select2.getValue());
            rezerwacjaRepo.save(rezerwacja);
            Notification notification = new Notification("Rezerwacja dodana", 3000);
            notification.open();

        });



        add(new H1("Dodawanie rezerwacji"),textField1, textField2 , statusBox , labelDateTimePicker, select , select1, select2 , buttonAdd);

    }


}
