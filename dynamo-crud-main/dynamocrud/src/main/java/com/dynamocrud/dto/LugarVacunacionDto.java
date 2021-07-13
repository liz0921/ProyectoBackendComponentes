package com.dynamocrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LugarVacunacionDto {
    private String idLugarVacunacion;
    private String nombreCentoVacunacion;
    private String direccion;
    private String provincia;
    private String canton;
    private String distrito;
}

