package com.Meniy_DelValle_Jordan_Acuna_Lopez.proyecto_final_prog3.repository;

import com.Meniy_DelValle_Jordan_Acuna_Lopez.proyecto_final_prog3.model.EquipoReal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EquipoRealRepository extends JpaRepository<EquipoReal, Long> {

    Optional<EquipoReal> findByNombre(String nombre);

    List<EquipoReal> findByLiga(String liga);

    List<EquipoReal> findByEstrellas(Integer estrellas);

    boolean existsByNombre(String nombre);

}