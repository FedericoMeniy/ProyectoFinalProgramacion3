package com.Meniy_DelValle_Jordan_Acuna_Lopez.proyecto_final_prog3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.UniqueConstraint;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;


import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = {"id", "nombre"}) 
@Entity
@Table(name = "equipos_reales",
        uniqueConstraints = {
               @UniqueConstraint(columnNames = {"nombre", "liga"}, name = "equipo_nombre_liga")
        })
public class EquipoReal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del equipo no puede estar vacío.")
    @Size(min = 2, max = 50, message = "El nombre del equipo debe tener entre 2 y 50 caracteres.")
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @NotBlank(message = "La liga del equipo no puede estar vacía.")
    @Size(min = 2, max = 50, message = "La liga debe tener entre 2 y 50 caracteres.")
    @Column(name = "liga", nullable = false, length = 50)
    private String liga;

    @NotNull(message = "La calificación de estrellas no puede ser nula.")
    @Min(value = 1, message = "La calificación mínima es 1 estrella.")
    @Max(value = 5, message = "La calificación máxima es 5 estrellas.")
    @Column(name = "estrellas", nullable = false)
    private Integer estrellas;


    @Size(max = 255, message = "La URL del logo no debe exceder los 255 caracteres.")
    @Column(name = "logo_url", length = 255, nullable = true)
    private String logoUrl;

}