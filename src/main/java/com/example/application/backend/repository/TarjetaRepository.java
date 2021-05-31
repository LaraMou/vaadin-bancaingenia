package com.example.application.backend.repository;


import com.example.application.backend.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta,Long> {
    @Query("SELECT SUM(importe) from Movimiento where tarjeta.id=?1")
    Double getSaldoTotalCuenta(Long id);

}
