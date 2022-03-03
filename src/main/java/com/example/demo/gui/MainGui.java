package com.example.demo.gui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

import javax.swing.text.html.ListView;

//@CssImport("./styles/shared-styles.css")
public class MainGui extends AppLayout {
    public MainGui() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("Park Rozrywki s19562");
        logo.addClassName("logo");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);

        header.setDefaultVerticalComponentAlignment(
                FlexComponent.Alignment.CENTER);
        header.setWidth("100%");
        header.addClassName("header");


        addToNavbar(header);

    }

    private void createDrawer() {
        RouterLink listLink = new RouterLink("Dodaj rezerwacje", DodajRezGui.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());



        addToDrawer(new VerticalLayout(
                listLink,
                new RouterLink("Rezerwacje klientów", KlienciGui.class),
                new RouterLink("Rezerwacje", TabRezGui.class),
                new RouterLink("Atrakcje i rekwizyty", AtrakcjaGui.class),
                new RouterLink("Dodaj rekwizyty do atrakcji", RekwizytyAddGui.class)
        ));
    }
}
