package com.example.application.components;

import com.example.application.backend.model.Cuenta;
import com.example.application.backend.model.Movimiento;
import com.example.application.backend.service.CuentaService;
import com.example.application.backend.service.MovimientoService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Shortcuts;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
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
    private Icon arrow;
    private Grid<Movimiento> grid = new Grid<>(Movimiento.class);
    public CuentaDialog(Cuenta cuenta, CuentaService cuentaService, MovimientoService movimientoService, Long id) {
        this.id = id;
        this.cuenta = cuenta;
        this.cuentaService = cuentaService;
        this.movimientoService = movimientoService;
        loadGrid(id);
        configureGrid();
        add(detailsCuenta(id));

        setCloseOnEsc(true);
        setCloseOnOutsideClick(true);
        Span message = new Span();

    }

    private VerticalLayout detailsCuenta( Long id) {



        VerticalLayout verticalLayout = new VerticalLayout();

        verticalLayout.setSizeFull();
        verticalLayout.setWidth("1100px");
        verticalLayout.setHeight("500px");
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
        grid.addComponentColumn(item -> iconoArrow(grid,item)).setFlexGrow(1).setWidth("120px").setHeader("");




    }

    private Icon iconoArrow(Grid<Movimiento> grid, Movimiento item) {
        if(item.getImporte()>0d){

            arrow = new Icon(VaadinIcon.ARROW_CIRCLE_DOWN);
            arrow.setColor("green");

        }else{
            arrow = new Icon(VaadinIcon.ARROW_CIRCLE_UP);
            arrow.setColor("red");
        }
        return arrow;
    }

}
