package com.example.application.views.login;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "login")
@PageTitle("Login | Vaadin Training")

public class LoginView extends VerticalLayout implements BeforeEnterObserver {
	LoginForm loginForm = new LoginForm();	
	
	public LoginView() {
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);
        
		loginForm.setForgotPasswordButtonVisible(false);	
		loginForm.setAction("login");

        add(new Image("images/logo1.png", "IngeniaBANK logo"));
        add(loginForm);
        add(new H3("Usuario: admin - Password: password"));
        add(new H4("(expira en 5 minutos)"));
	}
		
    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if(beforeEnterEvent.getLocation()
        .getQueryParameters()
        .getParameters()
        .containsKey("error")) {
        	loginForm.setError(true);
        }
    }
}
