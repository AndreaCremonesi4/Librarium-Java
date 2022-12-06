package com.librarium.application.views;

import java.util.List;

import com.librarium.application.backend.DatabaseHelper;
import com.librarium.application.components.LinkButton;
import com.librarium.database.generated.org.jooq.tables.records.AutoriRecord;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("/")
public class HomePage extends VerticalLayout {

	AutoriRecord a;
	List<AutoriRecord> autori;
	Grid<AutoriRecord> grid;

	AutoriRecord selectedAuthor = null;
	TextField author;

	public HomePage() {
		LinkButton button = new LinkButton("Login", "login");
		button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		grid = new Grid<>(AutoriRecord.class, false);
		grid.addColumn(AutoriRecord::getId).setHeader("ID");
		grid.addColumn(AutoriRecord::getNome).setHeader("Nome");
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
