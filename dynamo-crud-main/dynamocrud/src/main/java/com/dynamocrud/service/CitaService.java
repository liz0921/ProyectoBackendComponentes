package com.dynamocrud.service;

import com.dynamocrud.dto.CitaDto;
import com.dynamocrud.dto.UsuarioDto;
import com.dynamocrud.entity.*;
import com.dynamocrud.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitaService {
    @Autowired
    CitaRepository citaRepository;

    public Iterable<Cita> lista(){
        return citaRepository.findAll();
    }

    public Cita getOne(String idCita){
        return citaRepository.findById(idCita).get();
    }

    public Cita save(CitaDto dto){
        Cita cita =
                Cita.builder().idCita(dto.getIdCita()).descripcion(dto.getDescripcion()).fecha(dto.getFecha()).hora(dto.getHora()).numeroDosis(dto.getNumeroDosis()).idUsuario(dto.getIdUsuario())
                        .TipoVacuna
                                (TipoVacuna.builder()
                                        .idTipoVacuna(dto.getTipoVacuna().getIdVacuna()).cantidadDosis(dto.getTipoVacuna().getCantidadDosis()) .nombreVacuna(dto.getTipoVacuna().getNombreVacuna()) .build())
                      .LugarVacunacion
                                (LugarVacunacion.builder()
                                        .idLugarVacunacion(dto.getLugarVacunacion().getIdLugarVacunacion()).nombreCentroVacunacion(dto.getLugarVacunacion().getNombreCentoVacunacion()).direccion(dto.getLugarVacunacion().getDireccion()).provincia(dto.getLugarVacunacion()
                                                .getProvincia()).canton(dto.getLugarVacunacion().getCanton()).distrito(dto.getLugarVacunacion()
                                                .getDistrito()).build()).build();

        return citaRepository.save(cita);
    }
   /* public Usuario update(UsuarioDto dto){
        Usuario usuario = citaRepository.findById(dto.getId()).get();
        usuario.setUsuarioId(dto.getId());
        usuario.setNombre(dto.getNombre());
        usuario.setDireccion(Direccion.builder()
                .ciudad(dto.getDireccionDto().getCiudad()).calle(dto.getDireccionDto().getCalle()).cp(dto.getDireccionDto().getCp()).build());
        return citaRepository.save(usuario);
    }*/

    public void delete(String idCita){
        citaRepository.deleteById(idCita);
    }

    public boolean existsId(String idCita){
        return citaRepository.existsById(idCita);
    }
}
