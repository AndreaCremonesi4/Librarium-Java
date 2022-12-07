package com.librarium.application.views;

import java.util.List;

import com.librarium.application.backend.DatabaseHelper;
import com.librarium.application.components.LinkButton;
import com.librarium.application.components.catalogo.ListaLibri;
import com.librarium.database.generated.org.jooq.tables.records.AutoriRecord;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("/")
public class HomePage extends VerticalLayout {
	public HomePage() {
		H1 titolo = new H1("Catalogo");
		
		ListaLibri libri = new ListaLibri();
		libri.setItems(DatabaseHelper.leggiLibri());
		
		add(titolo, libri);
	}
}
