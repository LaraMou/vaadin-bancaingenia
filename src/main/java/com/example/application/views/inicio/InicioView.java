package com.example.application.views.inicio;

import com.example.application.backend.model.Movimiento;
import com.example.application.backend.service.MovimientoService;
import com.github.appreciated.card.Card;
import com.github.appreciated.card.ClickableCard;
import com.github.appreciated.card.RippleClickableCard;
import com.github.appreciated.card.label.PrimaryLabel;
import com.github.appreciated.card.label.TitleLabel;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.provider.SortDirection;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.example.application.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Route(value = "Inicio", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Bienvenido/a a tu banca")
public class InicioView extends VerticalLayout {

    List<Movimiento> movimientosList = new ArrayList<>();
    ListDataProvider<Movimiento> movimientosProvider;

    Grid<Movimiento> grid = new Grid<>(Movimiento.class);

    private MovimientoService movimientoService;

    RippleClickableCard rcard = new RippleClickableCard(
            onClick -> {/* Handle Card click */},
            new TitleLabel("Example Title") // Follow up with more Components ...
    );

    ClickableCard ccard = new ClickableCard(
            onClick -> {/* Handle Card click */},
            new TitleLabel("Example Title") // Follow up with more Components ...
    );

    Card card = new Card(
            // if you don't want the title to wrap you can set the whitespace = nowrap
            new TitleLabel("BBVA").withWhiteSpaceNoWrap(),
            new TitleLabel("10354,52 €").withWhiteSpaceNoWrap(),
            new PrimaryLabel("Some primary text")
    );

    Card card2 = new Card (
            new TitleLabel("BBVA").withWhiteSpaceNoWrap(),
            new TitleLabel("10354,52€").withWhiteSpaceNoWrap(),
            new PrimaryLabel("Some primary text")
    );

    Card card3 = new Card (
            new TitleLabel("BBVA").withWhiteSpaceNoWrap(),
            new TitleLabel("10354,52€").withWhiteSpaceNoWrap(),
            new PrimaryLabel("Some primary text")
    );
    Card card4 = new Card (
            new TitleLabel("BBVA").withWhiteSpaceNoWrap(),
            new TitleLabel("10354,52€").withWhiteSpaceNoWrap(),
            new PrimaryLabel("Some primary text")
    );

    Card card5 = new Card (
            new TitleLabel("BBVA").withWhiteSpaceNoWrap(),
            new TitleLabel("10354,52€").withWhiteSpaceNoWrap(),
            new PrimaryLabel("Some primary text")
    );





    public InicioView(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
        this.movimientosList= movimientoService.findMovimientos();
        loadGrid();



        grid.setColumns("tarjeta.id","importe","concepto","fechaValor");
        grid.getColumnByKey("tarjeta.id").setHeader("Tarjeta");
        grid.getColumnByKey("importe").setHeader("Importe");
        grid.getColumnByKey("concepto").setHeader("Concepto");
        grid.getColumnByKey("fechaValor").setHeader("Fecha");
        grid.setWidthFull();

        HorizontalLayout layout = new HorizontalLayout();
        add(new H1("Tarjetas"));
        add(new Hr());
        layout.add(card, card2, card3,card4, card5);
        card4.setVisible(false);
// shorthand methods for changing the component theme variants
        layout.setPadding(false);
        layout.setMargin(true);
// just a demonstration of the API, by default the spacing is on
        layout.setSpacing(true);

        add(layout);
        add(new Hr());
        addClassName("inicio-view2");

        HorizontalLayout layout2 = new HorizontalLayout();
        layout2.setPadding(false);
        layout2.setSpacing(true);
        layout2.setMargin(true);
        add(layout2);
        add(grid);
    }
    private void loadGrid()
    {
        movimientosProvider = DataProvider.ofCollection(this.movimientosList);
        movimientosProvider.setSortOrder(Movimiento::getFecha, SortDirection.DESCENDING);

        grid.setDataProvider(movimientosProvider);
    }

}
