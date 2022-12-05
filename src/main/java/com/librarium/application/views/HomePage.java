package com.librarium.application.views;

import java.util.ArrayList;
import java.util.List;

import com.librarium.application.backend.DatabaseHelper;
import com.librarium.application.components.LinkButton;
import com.librarium.application.entity.Autore;
import com.librarium.application.navigate.Navigation;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("/")
public class HomePage extends VerticalLayout {

	Autore a;
	List<Autore> autori;
	Grid<Autore> grid;

	Autore selectedAuthor = null;
	TextField author;

	public HomePage() {
		LinkButton button = new LinkButton("Login", "login");
		button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		grid = new Grid<>(Autore.class, false);
		grid.addColumn(Autore::getId).setHeader("ID");
		grid.addColumn(Autore::getNome).setHeader("Nome");
		grid.addCellFocusListener(e -> {
			try {
				a = e.getItem().get();
				author.setValue(a.getNome());
			} catch (Exception ex) {
			}
		});

		author = new TextField();
		author.setLabel("Autore");

		HorizontalLayout hlayout = new HorizontalLayout();
		hlayout.setAlignItems(Alignment.END);
		hlayout.setSizeFull();

		Button modifyButton = new Button("Modifica");
		modifyButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		modifyButton.addClickListener(e -> {
			modifyAuthor();
		});

		hlayout.add(author, modifyButton);

		updateGrid();

		add(button, grid, hlayout);
	}

	void modifyAuthor() {
		String newName = author.getValue();
		if (a != null && !a.getNome().equals(newName)) {
			// aggiorna autore
			a = null;
			author.setValue("");
			updateGrid();
		}
	}

	void updateGrid() {
		autori = DatabaseHelper.leggiAutori();
		
		if (autori != null && autori.size() > 0) {
			grid.setItems(autori);
		}
	}

}
