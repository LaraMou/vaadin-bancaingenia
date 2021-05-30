package com.example.application.backend.repository;


import com.example.application.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>, CrudRepository<Usuario, Long> {

}
