package com.example.application.backend.service;


import com.example.application.model.Cuenta;

import java.util.List;

public interface CuentaService {
    List<Cuenta> findAll();

   Cuenta findById(Long id);

    Cuenta saveCuenta(Cuenta cuenta);

   void deleteById(Long id);



}
