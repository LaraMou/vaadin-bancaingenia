package com.example.application.components;

import com.example.application.backend.model.Cuenta;
import com.example.application.backend.model.Movimiento;
import com.example.application.backend.model.Tarjeta;
import com.example.application.backend.service.CuentaService;
import com.example.application.backend.service.MovimientoService;
import com.example.application.backend.service.TarjetaService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.List;

public class TarjetaDialog extends Dialog {
    private TarjetaService tarjetaService;
    private MovimientoService movimientoService;
    private Long id;
    private Tarjeta tarjeta;
    private List<Movimiento> movimientoList;
    private Grid<Movimiento> grid = new Grid<>(Movimiento.class);
    private Icon arrow = new Icon();
    public TarjetaDialog(Tarjeta tarjeta, TarjetaService tarjetaService, MovimientoService movimientoService, Long id) {
        this.id = id;
        this.tarjeta = tarjeta;
        this.tarjetaService = tarjetaService;
        this.movimientoService = movimientoService;

        add(detailsTarjeta(movimientoService,id));

        setCloseOnEsc(true);
        setCloseOnOutsideClick(true);
    }


    private VerticalLayout detailsTarjeta(MovimientoService movimientoService, Long id) {

        loadGrid(id);
        configureGrid();

        VerticalLayout verticalLayout = new VerticalLayout();

        verticalLayout.setSizeFull();
        verticalLayout.setWidth("1100px");
        verticalLayout.setHeight("500px");

        verticalLayout.add(grid);

        return verticalLayout;
    }

    private void loadGrid(Long id) {
        movimientoList = movimientoService.findMovimientosByTarjeta(id);

        grid.setItems(movimientoList);
    }
    private void configureGrid() {

        grid.addClassName("lista-tarjeta");
        grid.setSizeFull();

        grid.setColumns("tarjeta.id","importe","concepto","fechaValor");
        grid.getColumnByKey("tarjeta.id").setHeader("Tarjeta");

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
