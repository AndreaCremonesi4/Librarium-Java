package com.librarium.application.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("/signup")
public class SignupPage extends VerticalLayout {

	public SignupPage() {
		H1 title = new H1("Signup");
		TextField firstName = new TextField("First name");
		TextField lastName = new TextField("Last name");
		TextField username = new TextField("Username");
		PasswordField password = new PasswordField("Password");
		PasswordField confirmPassword = new PasswordField("Confirm password");
		Button loginButton = new Button("Signup");

		loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		loginButton.addClassName("submit-btt");

		HorizontalLayout hint = new HorizontalLayout();

		Span span = new Span("Hai già un account?");
		Anchor linkRegistration = new Anchor("/login", "Accedi");

		hint.addClassName("hint");
		hint.add(span, linkRegistration);

		FormLayout formLayout = new FormLayout();
		formLayout.add(title, firstName, lastName, username, password, confirmPassword, loginButton, hint);

		formLayout.setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("500px", 2));

		formLayout.setColspan(title, 2);
		formLayout.setWidth("400px");

		HorizontalLayout hLayout = new HorizontalLayout();
		hLayout.setJustifyContentMode(JustifyContentMode.CENTER);
		hLayout.add(formLayout);
		hLayout.setSizeFull();

		setSizeFull();

		add(hLayout);
	}

}
