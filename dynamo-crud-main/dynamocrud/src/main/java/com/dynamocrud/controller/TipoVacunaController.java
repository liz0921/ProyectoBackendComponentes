package com.dynamocrud.controller;

import com.dynamocrud.dto.TipoVacunaDto;
import com.dynamocrud.entity.TipoVacuna;
import com.dynamocrud.service.TipoVacunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class TipoVacunaController {
    @Autowired
    TipoVacunaService tipoVacunaService;

    @GetMapping("/tipoVacuna")
    public ResponseEntity<Iterable<TipoVacuna>> list(){
        return ResponseEntity.ok(tipoVacunaService.lista());
    }

    @GetMapping("/tipoVacuna/{idTipoVacuna }")
    public ResponseEntity<TipoVacuna> getOne(@PathVariable("idTipoVacuna") String idTipoVacuna ){

        if(!tipoVacunaService.existsId(idTipoVacuna ))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(tipoVacunaService.getOne(idTipoVacuna ));
    }

    @PostMapping("/tipoVacuna")
    public ResponseEntity<TipoVacuna> create(@RequestBody TipoVacunaDto tipoVacunaDto) {
        try {
            if (tipoVacunaService.existsId(tipoVacunaDto.getIdVacuna())){
                return new ResponseEntity("el id ya existe", HttpStatus.BAD_REQUEST);}
            if(tipoVacunaService.existsId(tipoVacunaDto.getNombreVacuna()))
                return new ResponseEntity("ese nombre ya existe", HttpStatus.BAD_REQUEST);
            return ResponseEntity.ok(tipoVacunaService.save(tipoVacunaDto));
        } catch (Exception e) {
            return (ResponseEntity<TipoVacuna>) ResponseEntity.badRequest();
        }

    }


    @PutMapping("/tipoVacuna")
    public ResponseEntity<TipoVacuna> update(@RequestBody  TipoVacunaDto tipoVacunaDto){
        if(!tipoVacunaService.existsId(tipoVacunaDto.getIdVacuna()))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
       /* if(tipoVacunaService.existsNombre(tipoVacunaDto.getNombreVacuna()) && !tipoVacunaService.getOne(tipoVacunaDto.getIdVacuna()).getNombreVacuna().equals(tipoVacunaDto.getNombreVacuna()))
            return new ResponseEntity("ese nombre ya existe", HttpStatus.BAD_REQUEST);*/
        return ResponseEntity.ok(tipoVacunaService.update(tipoVacunaDto));

    }

    @DeleteMapping("/tipoVacuna/{idTipoVacuna}")
    public ResponseEntity<?> delete(@PathVariable("idTipoVacuna") String idTipoVacuna){
        if(!tipoVacunaService.existsId(idTipoVacuna))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        tipoVacunaService.delete(idTipoVacuna);
        return new ResponseEntity("usuario eliminado", HttpStatus.OK);
}}
