package com.Meniy_DelValle_Jordan_Acuna_Lopez.proyecto_final_prog3.model;

import com.Meniy_DelValle_Jordan_Acuna_Lopez.proyecto_final_prog3.model.enums.TipoResultado; // Importamos nuestro Enum
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.FetchType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"equipoReal"})
@EqualsAndHashCode(of = {"id", "equipoReal", "fechaPartido"})
@Entity
@Table(name = "resultados_partidos")
public class ResultadoPartido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El equipo real no puede ser nulo.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_real_id", nullable = false)
    private EquipoReal equipoReal;

    @NotNull(message = "La fecha del partido no puede ser nula.")
    @PastOrPresent(message = "La fecha del partido debe ser en el pasado o presente.")
    @Column(name = "fecha_partido", nullable = false)
    private LocalDate fechaPartido;

    @NotBlank(message = "El nombre del oponente no puede estar vacío.")
    @Size(max = 100, message = "El nombre del oponente no debe exceder los 100 caracteres.")
    @Column(name = "oponente", nullable = false, length = 100)
    private String oponente;

    @NotNull(message = "El resultado del partido no puede ser nulo.")
    @Enumerated(EnumType.STRING)
    @Column(name = "resultado", nullable = false, length = 10)
    private TipoResultado resultado;

    @NotNull(message = "Los puntos obtenidos no pueden ser nulos.")
    @Column(name = "puntos_obtenidos", nullable = false)
    private Integer puntosObtenidos;


    public ResultadoPartido(EquipoReal equipoReal, LocalDate fechaPartido, String oponente, TipoResultado resultado) {
        this.equipoReal = equipoReal;
        this.fechaPartido = fechaPartido;
        this.oponente = oponente;
        this.resultado = resultado;
        if (resultado != null) {
            this.puntosObtenidos = resultado.getPuntos();
        } else {
            this.puntosObtenidos = 0;
        }
    }
}