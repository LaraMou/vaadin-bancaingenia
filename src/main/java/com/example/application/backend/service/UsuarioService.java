package com.example.application.backend.service;



import com.example.application.backend.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
     List<Usuario> findAll();

     Optional<Usuario> findUsuarioByNif(String nif);

     Usuario saveUser(Usuario user);

     void deleteById(Long id);
}
