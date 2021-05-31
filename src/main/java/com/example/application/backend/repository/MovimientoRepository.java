package com.example.application.backend.repository;


import com.example.application.backend.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento,Long> {
    @Query("select m from Movimiento m where m.cuenta.id = ?1")
    List<Movimiento> findMovimientoByCuenta(Long id);

}
