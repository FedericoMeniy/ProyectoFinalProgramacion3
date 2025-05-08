package com.Meniy_DelValle_Jordan_Acuna_Lopez.proyecto_final_prog3.model.enums;

import lombok.Getter;

@Getter
public enum TipoResultado {
    GANADO(3),
    EMPATADO(1),
    PERDIDO(0);

    private final int puntos;

    TipoResultado(int puntos) {
        this.puntos = puntos;
    }
}