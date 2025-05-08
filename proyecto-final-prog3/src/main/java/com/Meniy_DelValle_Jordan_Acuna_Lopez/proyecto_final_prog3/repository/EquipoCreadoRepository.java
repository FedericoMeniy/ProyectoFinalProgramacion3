package com.Meniy_DelValle_Jordan_Acuna_Lopez.proyecto_final_prog3.repository;

import com.Meniy_DelValle_Jordan_Acuna_Lopez.proyecto_final_prog3.model.EquipoCreado;
import com.Meniy_DelValle_Jordan_Acuna_Lopez.proyecto_final_prog3.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EquipoCreadoRepository extends JpaRepository<EquipoCreado, Long> {

    List<EquipoCreado> findByUsuario(Usuario usuario);

    List<EquipoCreado> findByUsuarioId(Long usuarioId);

    Optional<EquipoCreado> findByIdAndUsuarioId(Long id, Long usuarioId);

    boolean existsByNombreEquipoAndUsuario(String nombreEquipo, Usuario usuario);

    List<EquipoCreado> findAllByOrderByPuntosTotalesDesc();

}