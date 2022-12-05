package com.librarium.application.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("/login")
public class LoginPage extends VerticalLayout{
	
	public LoginPage() {
		H1 title = new H1("Login");
		/*TextField firstName = new TextField("First name");
		TextField lastName = new TextField("Last name");*/
		TextField username = new TextField("Username");
		PasswordField password = new PasswordField("Password");
		//PasswordField confirmPassword = new PasswordField("Confirm password");
		Button loginButton = new Button("Login");
		
		loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		loginButton.addClassName("submit-btt");
		
		HorizontalLayout hint = new HorizontalLayout();
		
		Span span = new Span("Non hai un account?");
		Anchor linkRegistration = new Anchor("/signup", "Registrati");
		
		hint.addClassName("hint");
		hint.add(span, linkRegistration);
		
		FormLayout formLayout = new FormLayout();
		formLayout.add(title, username, password, loginButton, hint);
		
		/*formLayout.setResponsiveSteps(
		        // Use one column by default
		        new ResponsiveStep("0", 1),
		        // Use two columns, if layout's width exceeds 500px
		        new ResponsiveStep("300px", 2));*/
		
		formLayout.setWidth("400px");
		
		HorizontalLayout hLayout = new HorizontalLayout();
		hLayout.setJustifyContentMode(JustifyContentMode.CENTER);
		hLayout.add(formLayout);
		hLayout.setSizeFull();
		
		setSizeFull();
		
		add(hLayout);
	}
	
}
