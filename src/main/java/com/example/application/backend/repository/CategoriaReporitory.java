package com.example.application.backend.repository;


import com.example.application.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaReporitory extends JpaRepository<Categoria,Long> {

}
