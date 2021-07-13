package com.dynamocrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TipoVacunaDto {
    private String idVacuna;
    private int cantidadDosis;
    private String nombreVacuna;
}
