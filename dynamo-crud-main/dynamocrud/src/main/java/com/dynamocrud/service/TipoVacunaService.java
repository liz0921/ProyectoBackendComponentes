package com.dynamocrud.service;

import com.dynamocrud.dto.TipoVacunaDto;
import com.dynamocrud.entity.TipoVacuna;
import com.dynamocrud.repository.TipoVacunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoVacunaService {
    @Autowired
    TipoVacunaRepository tipoVacunaRepository;

    public Iterable<TipoVacuna> lista() {
        return tipoVacunaRepository.findAll();
    }

    public TipoVacuna getOne(String nombreTipoVacuna) {
        return tipoVacunaRepository.findById(nombreTipoVacuna).get();
    }

    public TipoVacuna save(TipoVacunaDto dto) {
       /* TipoVacuna tipo =
                TipoVacuna.builder().idTipoVacuna(dto.getIdVacuna()).cantidadDosis(dto.getCantidadDosis()).nombreVacuna(dto.getNombreVacuna());*/
        TipoVacuna tipoVacuna = new TipoVacuna();
        tipoVacuna.setIdTipoVacuna(dto.getIdVacuna());
        tipoVacuna.setNombreVacuna(dto.getNombreVacuna());
        tipoVacuna.setCantidadDosis(dto.getCantidadDosis());
        return tipoVacunaRepository.save(tipoVacuna);
    }

    public TipoVacuna update(TipoVacunaDto dto) {
        TipoVacuna tipoVacuna = tipoVacunaRepository.findById(dto.getIdVacuna()).get();
        tipoVacuna.setIdTipoVacuna(dto.getIdVacuna());
        tipoVacuna.setNombreVacuna(dto.getNombreVacuna());
        tipoVacuna.setCantidadDosis(dto.getCantidadDosis());
        return tipoVacunaRepository.save(tipoVacuna);
    }

    public void delete(String usuarioId) {
        tipoVacunaRepository.deleteById(usuarioId);
    }

    public boolean existsId(String usuarioId) {
        return tipoVacunaRepository.existsById(String.valueOf(usuarioId));
    }

    public boolean existsByIdTipoVacuna(String idTipoVacuna){
        return tipoVacunaRepository.existsByIdTipoVacuna(idTipoVacuna);
    }

}
