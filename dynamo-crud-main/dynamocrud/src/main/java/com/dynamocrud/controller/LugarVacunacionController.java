package com.dynamocrud.controller;

import com.dynamocrud.dto.LugarVacunacionDto;
import com.dynamocrud.entity.LugarVacunacion;
import com.dynamocrud.service.LugarVacunacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class LugarVacunacionController {
    @Autowired
    LugarVacunacionService lugarService;

    @GetMapping("/lugarVacunacion")
    public ResponseEntity<Iterable<LugarVacunacion>> list() {
        return ResponseEntity.ok(lugarService.lista());
    }

    @GetMapping("/lugarVacunacion/{idLugarVacunacion }")
    public ResponseEntity<LugarVacunacion> getOne(@PathVariable("idLugarVacunacion") String idLugarVacunacion) {
        if (!lugarService.existsId(idLugarVacunacion))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(lugarService.getOne(idLugarVacunacion));
    }

    @PostMapping("/lugarVacunacion")
    public ResponseEntity<LugarVacunacion> create(@RequestBody LugarVacunacionDto lugarDto) {
        try {
            if (lugarService.existsId(lugarDto.getIdLugarVacunacion())) {
                return new ResponseEntity("el id ya existe", HttpStatus.BAD_REQUEST);
            }
            if (lugarService.existsId(lugarDto.getNombreCentoVacunacion()))
                return new ResponseEntity("ese nombre ya existe", HttpStatus.BAD_REQUEST);
            return ResponseEntity.ok(lugarService.save(lugarDto));
        } catch (Exception e) {
            return (ResponseEntity<LugarVacunacion>) ResponseEntity.badRequest();
        }

    }


    @PutMapping("/lugarVacunacion")
    public ResponseEntity<LugarVacunacion> update(@RequestBody LugarVacunacionDto lugarDto) {
        if (!lugarService.existsId(lugarDto.getIdLugarVacunacion()))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
       /* if(tipoVacunaService.existsNombre(tipoVacunaDto.getNombreVacuna()) && !tipoVacunaService.getOne(tipoVacunaDto.getIdVacuna()).getNombreVacuna().equals(tipoVacunaDto.getNombreVacuna()))
            return new ResponseEntity("ese nombre ya existe", HttpStatus.BAD_REQUEST);*/
        return ResponseEntity.ok(lugarService.update(lugarDto));
    }

    @DeleteMapping("/lugarVacunacion/{idLugarVacunacion}")
    public ResponseEntity<?> delete(@PathVariable("idLugarVacunacion") String idLugarVacunacion) {
        if (!lugarService.existsId(idLugarVacunacion))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        lugarService.delete(idLugarVacunacion);
        return new ResponseEntity("usuario eliminado", HttpStatus.OK);
    }

}