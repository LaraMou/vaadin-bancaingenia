package com.example.application.views.cuentas;

import java.util.List;

import com.example.application.backend.service.CuentaService;
import com.example.application.backend.service.MovimientoService;
import com.example.application.components.CardCuenta;
import com.example.application.backend.model.Cuenta;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.example.application.views.main.MainView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Route(value = "Cuentas", layout = MainView.class)
@PageTitle("Bienvenido/a a tu banca")
public class CuentasView extends HorizontalLayout  {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final int NOTIFICATION_DEFAULT_DURATION = 5000;
    List<Cuenta> cuentasList;
    Cuenta cuenta;
    private CuentaService cuentaService;
    private MovimientoService movimientoService;

    public CuentasView(CuentaService cuentaService, MovimientoService movimientoService) {
        this.cuentaService = cuentaService;
        this.movimientoService = movimientoService;
        addClassName("cuentas-view");
        setSizeFull();
        //cargar datos desde repostorio
        loadData();
        //añadir las cuentas en componente card
        add(createCard());
        addClassName("navegation0");

    }

    private HorizontalLayout createCard() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        add(new H1("Cuentas"));
        add(new Hr());
        for (Cuenta cuenta : this.cuentasList) {

            horizontalLayout.add(new CardCuenta(cuenta, this.cuentaService, this.movimientoService));

        }

        return horizontalLayout;
    }


    private void loadData() {
        this.cuentasList = cuentaService.findAll();
    }


}
