package com.dynamocrud.service;

import com.dynamocrud.dto.LugarVacunacionDto;
import com.dynamocrud.entity.LugarVacunacion;
import com.dynamocrud.repository.LugarVacunacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class LugarVacunacionService {
    @Autowired
    LugarVacunacionRepository lugarRepository;

    public Iterable<LugarVacunacion> lista() {
        return lugarRepository.findAll();
    }

    public  LugarVacunacion getOne(String idLugarVacunacion) {
        return lugarRepository.findById(idLugarVacunacion).get();
    }

    public LugarVacunacion save(LugarVacunacionDto dto) {

        LugarVacunacion lugar = new LugarVacunacion();
        lugar.setIdLugarVacunacion(dto.getIdLugarVacunacion());
        lugar.setNombreCentroVacunacion(dto.getNombreCentoVacunacion());
        lugar.setDireccion(dto.getDireccion());
        lugar.setProvincia(dto.getProvincia());
        lugar.setCanton(dto.getCanton());
        lugar.setDistrito(dto.getDistrito());
        return lugarRepository.save(lugar);
    }

    public LugarVacunacion update(LugarVacunacionDto dto) {
        LugarVacunacion lugar = lugarRepository.findById(dto.getIdLugarVacunacion()).get();
        lugar.setIdLugarVacunacion(dto.getIdLugarVacunacion());
        lugar.setNombreCentroVacunacion(dto.getNombreCentoVacunacion());
        lugar.setDireccion(dto.getDireccion());
        lugar.setProvincia(dto.getProvincia());
        lugar.setCanton(dto.getCanton());
        lugar.setDistrito(dto.getDistrito());
        return lugarRepository.save(lugar);
    }

    public void delete(String usuarioId) {
        lugarRepository.deleteById(usuarioId);
    }

    public boolean existsId(String usuarioId) {
        return lugarRepository.existsById(String.valueOf(usuarioId));
    }

}
