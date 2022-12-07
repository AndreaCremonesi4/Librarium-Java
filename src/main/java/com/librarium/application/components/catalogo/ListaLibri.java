package com.librarium.application.components.catalogo;

import java.util.ArrayList;
import java.util.List;

import com.librarium.database.generated.org.jooq.tables.records.LibriRecord;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class ListaLibri extends HorizontalLayout{
	
	//private List<LibriRecord> listaLibri;
	
	public ListaLibri() {
		addClassName("lista-libri");
		setHeight("200px");
	}
	
	public ListaLibri(List<LibriRecord> listaLibri) {
		this();
		
		setItems(listaLibri);
	}
	
	public void setItems(List<LibriRecord> listaLibri) {
		//this.listaLibri = listaLibri;
		
		// rimuovi i libri vecchi
		removeAll();
		
		for(LibriRecord libro : listaLibri) {
			System.out.println(libro.toString());
			Image icona = new Image();
			icona.setSrc(libro.getCopertina());
			add(icona);
		}
	}
	
}
