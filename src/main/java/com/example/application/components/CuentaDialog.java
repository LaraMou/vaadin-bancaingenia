package com.example.application.components;

import com.example.application.backend.model.Cuenta;
import com.example.application.backend.service.CuentaService;
import com.example.application.backend.service.MovimientoService;
import com.vaadin.flow.component.Shortcuts;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Locale;

public class CuentaDialog extends Dialog {
    private CuentaService cuentaService;
    private Long id;
    private Cuenta cuenta;
    public CuentaDialog(Cuenta cuenta, CuentaService cuentaService, MovimientoService movimientoService, Long id) {
        this.id = id;
        this.cuenta = cuenta;
        this.cuentaService = cuentaService;
        add(detailsCuenta(cuenta,id));

        setCloseOnEsc(false);
        setCloseOnOutsideClick(false);
        Span message = new Span();

        Button confirmButton = new Button("Close", event -> {
            message.setText("Confirmed!");
            close();
        });



        add(new Div( confirmButton));
    }

    private VerticalLayout detailsCuenta(Cuenta cuenta, Long id) {
        System.out.println("entro en detalle"+id);
        VerticalLayout verticalLayout = new VerticalLayout();

        verticalLayout.setSizeFull();
        verticalLayout.setWidth("1366px");
        verticalLayout.setHeight("768px");
        //iban

        HorizontalLayout ibanLayout = new HorizontalLayout();
        Span ibanSapn = new Span();
        Span title1Span = new Span();
        title1Span.add("IBAN".toUpperCase(Locale.ROOT));
        ibanSapn.add(cuenta.getCodpais() +"  " + cuenta.getDigitocontrol()+" "+ cuenta.getEntidad()+" "+cuenta.getOficina()+" "+cuenta.getNumerocuenta());

        ibanLayout.add(title1Span,ibanSapn);



        // layout con el saldo de la cuenta
        HorizontalLayout saldoLayout = new HorizontalLayout();

        Span saldoSpan = new Span();
        saldoSpan.add(cuenta.getImporteactual() + " €");
        saldoLayout.add(saldoSpan);


        // añadimos todos los layouts horizontales al layout principal

        verticalLayout.add(ibanLayout);
        verticalLayout.add(saldoLayout);
        return verticalLayout;
    }
}
