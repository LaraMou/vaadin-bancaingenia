package com.example.application.views.inicio;

import com.example.application.backend.model.Movimiento;
import com.example.application.backend.model.Tarjeta;
import com.example.application.backend.service.MovimientoService;
import com.example.application.backend.service.TarjetaService;
import com.example.application.components.CardTarjeta;
import com.github.appreciated.card.Card;
import com.github.appreciated.card.ClickableCard;
import com.github.appreciated.card.RippleClickableCard;
import com.github.appreciated.card.label.PrimaryLabel;
import com.github.appreciated.card.label.TitleLabel;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Image;
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
    List<Tarjeta> tarjetas;

    private TarjetaService tarjetaService;

    List<Movimiento> movimientosList = new ArrayList<>();
    ListDataProvider<Movimiento> movimientosProvider;

    Grid<Movimiento> grid = new Grid<>(Movimiento.class);

    private MovimientoService movimientoService;

  /*  RippleClickableCard rcard = new RippleClickableCard(
            onClick -> {*//* Handle Card click *//*},
            new TitleLabel("Example Title") // Follow up with more Components ...
    );

    ClickableCard ccard = new ClickableCard(
            onClick -> {
                UI.getCurrent().navigate("tarjetas");},
            new TitleLabel("Example Title") // Follow up with more Components ...
    );*/

    ClickableCard card = new  ClickableCard(


            onClick -> {
                Dialog dialog = new Dialog();
                dialog.add(new H1("Lista de movimientos de la tarjeta"));
                dialog.setWidth("1366px");
                dialog.setHeight("766px");
                dialog.open();
                ;},

            new Image("images/bbva.png", "BBVA logo"),
            new TitleLabel("10354,52 €                         ").withWhiteSpaceNoWrap(),
            new PrimaryLabel("****3331")

    );

    ClickableCard card2 = new  ClickableCard (
            onClick -> {
                UI.getCurrent().navigate("Movimientos");},
            new Image("images/bbva.png", "BBVA logo"),
            new TitleLabel("10354,52€                         ").withWhiteSpaceNoWrap(),
            new PrimaryLabel("**** 4441")
    );

    ClickableCard card3 = new  ClickableCard (
            onClick -> {
                UI.getCurrent().navigate("Movimientos");},
            new Image("images/bbva.png", "BBVA logo"),
            new TitleLabel("10354,52€                         ").withWhiteSpaceNoWrap(),
            new PrimaryLabel("**** 5551")
    );
    ClickableCard card4 = new  ClickableCard(
            onClick -> {
                UI.getCurrent().navigate("Movimientos");},
            new Image("images/bbva.png", "BBVA logo"),
            new TitleLabel("10354,52€                         ").withWhiteSpaceNoWrap(),
            new PrimaryLabel("**** 2221")
    );

    ClickableCard card5 = new  ClickableCard (
            onClick -> {
                UI.getCurrent().navigate("Movimientos");},
            new Image("images/bbva.png", "BBVA logo"),
            new TitleLabel("10354,52€                         ").withWhiteSpaceNoWrap(),
            new PrimaryLabel("**** 1111")
    );





    public InicioView(MovimientoService movimientoService, TarjetaService tarjetaService) {
        this.movimientoService = movimientoService;
        this.tarjetaService = tarjetaService;
        this.movimientosList= movimientoService.findMovimientos();
        loadGrid();
//        createDialog();
        

        grid.setColumns("tarjeta.id","importe","concepto","fechaValor");
        grid.getColumnByKey("tarjeta.id").setHeader("Tarjeta");
        grid.getColumnByKey("importe").setHeader("Importe");
        grid.getColumnByKey("concepto").setHeader("Concepto");
        grid.getColumnByKey("fechaValor").setHeader("Fecha");
        grid.setWidthFull();


        HorizontalLayout layout = new HorizontalLayout();
        addClassName("tarjetas-view");
        setSizeFull();
        //cargar datos desde repostorio
        loadData();
        //añadir las cuentas en componente card

        layout.add(createCard());

        layout.setPadding(false);
        layout.setMargin(true);

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
    private HorizontalLayout createCard() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        add(new H1("Tarjetas"));
        add(new Hr());
        for (Tarjeta tarjeta : this.tarjetas) {

            horizontalLayout.add(new CardTarjeta(tarjeta, this.tarjetaService, this.movimientoService));

        }

        return horizontalLayout;
    }

    /**
     * Metodo que saca los datos de las tarjetas
     */
    private void loadData() {
        this.tarjetas = tarjetaService.findTarjetas();
    }

    /**
     * Metodo que retorna los datos de los movimientos
     */
    private void loadGrid()
    {
        movimientosProvider = DataProvider.ofCollection(this.movimientosList);
        movimientosProvider.setSortOrder(Movimiento::getFecha, SortDirection.DESCENDING);

        grid.setDataProvider(movimientosProvider);
    }

//    private void createDialog(){
//        Dialog dialog = new Dialog();
//        dialog.add(new Text("Close me with the esc-key or an outside click"));
//
//        dialog.setWidth("400px");
//        dialog.setHeight("150px");
//
//
//    }
}
