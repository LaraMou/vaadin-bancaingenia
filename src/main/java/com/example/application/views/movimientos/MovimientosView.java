package com.example.application.views.movimientos;


import com.example.application.data.service.SamplePersonService;


import com.example.application.model.Movimiento;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;


import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.example.application.views.main.MainView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Route(value = "Movimientos/:samplePersonID?/:action?(edit)", layout = MainView.class)
@PageTitle("Bienvenido/a a tu banca")
public class MovimientosView extends HorizontalLayout {

    List<Movimiento> movimientosList = new ArrayList<>();

    public MovimientosView() {

        Grid<Movimiento> grid = new Grid<>(Movimiento.class);
        grid.setColumns("tarjeta","importe","concepto","fecha");
        grid.setWidthFull();

        HorizontalLayout layout = new HorizontalLayout();
        add(new H1("Movimientos"));
        add(new Hr());


// shorthand methods for changing the component theme variants
        layout.setPadding(false);
        layout.setMargin(true);
// just a demonstration of the API, by default the spacing is on
        layout.setSpacing(true);

        add(layout);
        addClassName("inicio-view");

        HorizontalLayout layout2 = new HorizontalLayout();
        layout2.setPadding(false);
        layout2.setSpacing(false);
        layout2.setMargin(false);
        layout2.add(grid);
        add(layout2);

    }

    }


