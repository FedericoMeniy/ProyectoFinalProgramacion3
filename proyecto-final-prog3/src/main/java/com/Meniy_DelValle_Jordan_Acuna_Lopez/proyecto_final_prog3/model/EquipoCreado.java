package com.Meniy_DelValle_Jordan_Acuna_Lopez.proyecto_final_prog3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.FetchType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"usuario", "equiposRealesSeleccionados"})
@EqualsAndHashCode(of = {"id", "nombreEquipo", "usuario"})
@Entity
@Table(name = "equipos_creados")
public class EquipoCreado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del equipo creado no puede estar vacío.")
    @Size(min = 3, max = 50, message = "El nombre del equipo creado debe tener entre 3 y 50 caracteres.")
    @Column(name = "nombre_equipo", nullable = false, length = 50)
    private String nombreEquipo;

    @Column(name = "puntos_totales", nullable = false)
    private int puntosTotales = 0;

    @NotNull(message = "El límite de estrellas no puede ser nulo.")
    @Min(value = 1, message = "El límite de estrellas debe ser al menos 1.")
    @Column(name = "limite_estrellas", nullable = false)
    private Integer limiteEstrellas = 15; // Valor por defecto.

    @Column(name = "estrellas_usadas", nullable = false)
    private int estrellasUsadas = 0;

    //  Relaciones

    @NotNull(message = "El equipo creado debe tener un propietario (usuario).")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "equipo_creado_equipo_real",
            joinColumns = @JoinColumn(name = "equipo_creado_id"),
            inverseJoinColumns = @JoinColumn(name = "equipo_real_id")
    )
    @Size(max = 5, message = "Un equipo creado puede tener como máximo 5 equipos reales.")
    private Set<EquipoReal> equiposRealesSeleccionados = new HashSet<>();

}