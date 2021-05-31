package com.example.application.components;

import com.example.application.backend.model.Cuenta;
import com.example.application.backend.model.Movimiento;
import com.example.application.backend.service.CuentaService;
import com.example.application.backend.service.MovimientoService;
import com.vaadin.flow.component.Shortcuts;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.List;
import java.util.Locale;

public class CuentaDialog extends Dialog {
    private CuentaService cuentaService;
    private MovimientoService movimientoService;
    private Long id;
    private Cuenta cuenta;
    private List<Movimiento> movimientoList;
    private Grid<Movimiento> grid = new Grid<>(Movimiento.class);
    public CuentaDialog(Cuenta cuenta, CuentaService cuentaService, MovimientoService movimientoService, Long id) {
        this.id = id;
        this.cuenta = cuenta;
        this.cuentaService = cuentaService;
        this.movimientoService = movimientoService;

        add(detailsCuenta(movimientoService,id));

        setCloseOnEsc(false);
        setCloseOnOutsideClick(false);
        Span message = new Span();

        Button confirmButton = new Button("Close", event -> {
            message.setText("Confirmed!");
            close();
        });



        add(new Div( confirmButton));
    }

    private VerticalLayout detailsCuenta(MovimientoService movimientoService, Long id) {
        System.out.println("entro en detalle"+id);
        loadGrid(id);
        configureGrid();

        VerticalLayout verticalLayout = new VerticalLayout();

        verticalLayout.setSizeFull();
        verticalLayout.setWidth("1366px");
        verticalLayout.setHeight("768px");
        //iban
        verticalLayout.add(grid);

        return verticalLayout;
    }

    private void loadGrid(Long id) {
        movimientoList = movimientoService.findMovimentosByCuenta(id);
        grid.setItems(movimientoList);
    }
    private void configureGrid() {
        grid.addClassName("lista-cuenta");
        grid.setSizeFull();
        grid.setColumns("cuenta.numerocuenta","importe","concepto","fechaValor");




    }
}
