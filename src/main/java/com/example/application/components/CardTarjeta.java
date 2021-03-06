package com.example.application.components;

import com.example.application.backend.model.Cuenta;
import com.example.application.backend.model.Tarjeta;
import com.example.application.backend.service.CuentaService;
import com.example.application.backend.service.MovimientoService;
import com.example.application.backend.service.TarjetaService;
import com.github.appreciated.card.ClickableCard;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Locale;

public class CardTarjeta extends ClickableCard {
    private Double saldo;
    public CardTarjeta(Tarjeta tarjeta, TarjetaService tarjetaService, MovimientoService movimientoService) {
        super(event -> {
            new TarjetaDialog(tarjeta,tarjetaService, movimientoService,tarjeta.getId()).open();

        });
        recuperaSaldo(tarjeta,tarjetaService);


        this.setWidth("300px");
        this.setHeight("175px");
        this.getElement().getStyle().set("radius", "24px");

        // layout principal que contendrĂ¡ los layouts posteriores
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();

        // layout con el logo de ingenia bank
        HorizontalLayout imagenLayout = new HorizontalLayout();
        Image ingeniaImage = new Image("images/bbvacirc.png", " bbvacirc");

        imagenLayout.add(ingeniaImage);

        // numerocuenta y tipo de cuenta
        HorizontalLayout numcLayout = new HorizontalLayout();
        Span numcSpan = new Span();
        String formateo = String.valueOf(tarjeta.getMaskedNumeroTarjeta());

        hideCardNumber(formateo);


        numcSpan.add(tarjeta.getTipo().toUpperCase(Locale.ROOT)+"  " + formateo);
        numcSpan.getElement().getStyle().set("background", "#EA6D64");
        numcSpan.getElement().getStyle().set("border-radius", "25px");
        numcSpan.getElement().getStyle().set("padding", "6px");
        numcSpan.getElement().getStyle().set("color", "white");
        numcLayout.add(numcSpan);


        // layout con el saldo de la cuenta
        HorizontalLayout saldoLayout = new HorizontalLayout();
        addClassName("saldo");
        Span saldoSpan = new Span();
        saldoSpan.add(saldo + " â‚¬");
        saldoSpan.getElement().getStyle().set("font-weight", "bold");
        saldoLayout.add(saldoSpan);


        // aĂ±adimos todos los layouts horizontales al layout principal
        layout.add(imagenLayout);
        layout.add(numcLayout);
        layout.add(saldoLayout);

        add(layout);


    }

    private Double recuperaSaldo(Tarjeta tarjeta, TarjetaService tarjetaService) {
        saldo = tarjetaService.getSaldoTotalCuenta(tarjeta.getId());
        if(saldo==null)
            saldo = 0D;
        return  saldo;
    }

    private String hideCardNumber(String cardNumber){
        String formateo = cardNumber;

        formateo.replaceAll("4","*");
        return  formateo;


    }
}

