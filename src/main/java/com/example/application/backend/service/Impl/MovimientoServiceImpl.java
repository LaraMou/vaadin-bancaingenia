package com.example.application.backend.service.Impl;


import com.example.application.backend.dao.MovimientoDAO;
import com.example.application.backend.service.MovimientoService;
import com.example.application.backend.model.Movimiento;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    public MovimientoDAO movimientoDAO;
    public MovimientoServiceImpl(MovimientoDAO movimientoDAO) {this.movimientoDAO = movimientoDAO;}

    @Override
    public Movimiento createMovimiento(Movimiento movimiento){ return this.movimientoDAO.createMovimiento(movimiento);}

    @Override
    public Movimiento updateMovimiento(Movimiento movimiento){return this.movimientoDAO.updateMovimiento(movimiento);}

    @Override
    public void deleteMovimiento(Long id){this.movimientoDAO.deleteMovimiento(id);};

    @Override
    public Optional<Movimiento> findOneMovimiento(Long id){return this.movimientoDAO.findOneMovimiento(id);}


    @Override
    public List<Movimiento> findMovimientos(){return this.movimientoDAO.findMovimientos();}

    @Override
    public List<Movimiento> findMovimientosEntre(Long id, LocalDate fechaInicio, LocalDate fechaFin){return this.movimientoDAO.findMovimientosEntre(id,fechaInicio,fechaFin);}

    @Override
    public List<Movimiento> findMovimentosByCuenta(Long idCuenta) {
        return this.movimientoDAO.findMovimientosByCuenta(idCuenta);
    }

    @Override
    public List<Movimiento> findMovimientosByTarjeta(Long idTarjeta) {
        return this.movimientoDAO.findMovimientosByTarjeta(idTarjeta);
    }
}
