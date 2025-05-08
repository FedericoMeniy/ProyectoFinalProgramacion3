package com.Meniy_DelValle_Jordan_Acuna_Lopez.proyecto_final_prog3.repository;

import com.Meniy_DelValle_Jordan_Acuna_Lopez.proyecto_final_prog3.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}