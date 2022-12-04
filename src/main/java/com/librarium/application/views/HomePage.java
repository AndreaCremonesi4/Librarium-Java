package com.librarium.application.views;

import java.util.ArrayList;

import com.librarium.application.backend.DatabaseHelper;
import com.librarium.application.components.LinkButton;
import com.librarium.application.entity.Autore;
import com.librarium.application.navigate.Navigation;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("/")
public class HomePage extends VerticalLayout{
	
	Autore selectedAuthor = null;
	TextField author;
	
	public HomePage() {
		LinkButton button = new LinkButton("Login", "login");
		button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		ArrayList<Autore> autori = DatabaseHelper.leggiAutori();
		
		Grid<Autore> grid = new Grid<>(Autore.class, false);
		grid.addColumn(Autore::getId).setHeader("ID");
		grid.addColumn(Autore::getNome).setHeader("Nome");
		
		author = new TextField();
		author.setLabel("Autore");
		
		grid.setItems(autori);
		grid.addCellFocusListener(e -> {
			try {
				author.setValue(e.getItem().get().getNome());
			}catch(Exception ex) {}
		});
		
		add(button, grid, author);
	}
	
}
