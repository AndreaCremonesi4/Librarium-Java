package com.librarium.application.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("/login")
public class LoginPage extends VerticalLayout{
	
	public LoginPage() {
		/* Creazione Form */
		
		// Titolo
		H1 titolo = new H1("Accesso");
		// Campo Email
		EmailField email = new EmailField("Email");
		// Campo Password
		PasswordField password = new PasswordField("Password");
		// Pulsante Login
		Button loginButton = new Button("Accedi");
		loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY); // cambio lo stile del pulsante
		loginButton.addClassName("submit-btt"); // aggiungo la classe CSS
		
		// Creo il contenitore per il testo sottostante al form
		HorizontalLayout hintContainer = new HorizontalLayout();
		
		Span text = new Span("Non hai un account?");
		Anchor linkRegistration = new Anchor("/signup", "Registrati"); // link che riporta alla pagina di registrazione
		
		hintContainer.addClassName("hint"); // aggiungo la classe CSS
		hintContainer.add(text, linkRegistration); // aggiungo i componenti al contenitore
		
		// Creo il form
		FormLayout formLayout = new FormLayout();
		formLayout.add(titolo, email, password, loginButton, hintContainer); // aggiungo al form i componenti
		formLayout.setWidth("400px");
		
		// Creo il contentiore del form
		HorizontalLayout formContainer = new HorizontalLayout();
		formContainer.setJustifyContentMode(JustifyContentMode.CENTER);
		formContainer.add(formLayout);
		formContainer.setSizeFull();
		
		// Layout della pagina a grandezza massima
		setSizeFull();
		
		// aggiungo il container del form alla pagina
		add(formContainer);
	}
	
}
