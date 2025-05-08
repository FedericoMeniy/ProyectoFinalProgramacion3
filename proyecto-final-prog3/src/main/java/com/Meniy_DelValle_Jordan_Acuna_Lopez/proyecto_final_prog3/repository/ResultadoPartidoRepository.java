package com.Meniy_DelValle_Jordan_Acuna_Lopez.proyecto_final_prog3.repository;

import com.Meniy_DelValle_Jordan_Acuna_Lopez.proyecto_final_prog3.model.EquipoReal;
import com.Meniy_DelValle_Jordan_Acuna_Lopez.proyecto_final_prog3.model.ResultadoPartido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ResultadoPartidoRepository extends JpaRepository<ResultadoPartido, Long> {

    List<ResultadoPartido> findByEquipoReal(EquipoReal equipoReal);

    List<ResultadoPartido> findByEquipoRealId(Long equipoRealId);

    List<ResultadoPartido> findByFechaPartido(LocalDate fechaPartido);

    List<ResultadoPartido> findByEquipoRealAndFechaPartido(EquipoReal equipoReal, LocalDate fechaPartido);

    List<ResultadoPartido> findByFechaPartidoBetween(LocalDate fechaInicio, LocalDate fechaFin);

    boolean existsByEquipoRealAndFechaPartidoAndOponenteIgnoreCase(EquipoReal equipoReal, LocalDate fechaPartido, String oponente);

}