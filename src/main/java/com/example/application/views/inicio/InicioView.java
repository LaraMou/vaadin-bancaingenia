package com.example.application.views.inicio;

import com.example.application.model.Movimiento;
import com.github.appreciated.card.Card;
import com.github.appreciated.card.ClickableCard;
import com.github.appreciated.card.RippleClickableCard;
import com.github.appreciated.card.label.PrimaryLabel;
import com.github.appreciated.card.label.TitleLabel;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
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
public class InicioView extends HorizontalLayout {

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

    List<Movimiento> movimientosList = new ArrayList<>();




    public InicioView() {


        LocalDateTime datetime1 = LocalDateTime.of(2017, 1, 14, 10, 34);
        LocalDate date1 = LocalDate.of(2017, 1, 13);
        movimientosList.add(new Movimiento(100.0,datetime1,date1,"restaurante Francisquita","Pago tarjeta"));
        Grid<Movimiento> grid = new Grid<>(Movimiento.class);
        grid.setColumns("tarjeta","importe","concepto","fecha");
        grid.setWidthFull();

        HorizontalLayout layout = new HorizontalLayout();
        add(new H1("Tarjetas"));
        add(new Hr());
        layout.add(card, card2, card3);

// shorthand methods for changing the component theme variants
        layout.setPadding(false);
        layout.setMargin(true);
// just a demonstration of the API, by default the spacing is on
        layout.setSpacing(true);

        add(layout);
        add(new Hr());
        addClassName("inicio-view");

        HorizontalLayout layout2 = new HorizontalLayout();
        layout2.setPadding(false);
        layout2.setSpacing(true);
        layout2.setMargin(true);
        layout2.add(grid);
        add(layout2);

    }

}
