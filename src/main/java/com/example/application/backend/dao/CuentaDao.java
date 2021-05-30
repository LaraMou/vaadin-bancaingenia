package com.example.application.backend.dao;



import com.example.application.model.Cuenta;

import java.util.List;
import java.util.Optional;

public interface CuentaDao {
    Optional<Cuenta> findCuentaByNumerocuenta(Long numerocuenta);

    List<Cuenta> findAll(Integer paginacion, Integer limite);

    List<Cuenta> findAccountsByUsuario(Long idUsuario);
}
