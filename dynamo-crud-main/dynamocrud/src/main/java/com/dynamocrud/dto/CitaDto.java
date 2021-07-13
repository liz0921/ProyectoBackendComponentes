package com.dynamocrud.dto;

import com.dynamocrud.entity.Cita;
import com.dynamocrud.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CitaDto {
    private String idCita;
    private String descripcion;
    private LocalDate fecha;
    private Time hora;
    private int numeroDosis;

    private Usuario idUsuario;
    private TipoVacunaDto TipoVacuna;
    private LugarVacunacionDto LugarVacunacion;
}
