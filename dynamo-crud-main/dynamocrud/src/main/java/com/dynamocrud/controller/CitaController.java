package com.dynamocrud.controller;

import com.dynamocrud.dto.CitaDto;
import com.dynamocrud.dto.UsuarioDto;
import com.dynamocrud.entity.Cita;
import com.dynamocrud.entity.Usuario;
import com.dynamocrud.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CitaController {

    @Autowired
    CitaService citaService;

    @GetMapping("/cita")
    public ResponseEntity<Iterable<Cita>> list() {
        return ResponseEntity.ok(citaService.lista());
    }

    @GetMapping("/cita/{idCita}")
    public ResponseEntity<Cita> getOne(@PathVariable("idCita") String idCita) {
        if (!citaService.existsId(idCita))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(citaService.getOne(idCita));
    }

    @PostMapping("/cita")
    public ResponseEntity<Cita> create(@RequestBody CitaDto citaDto) {
        try {
            if (citaService.existsId(citaDto.getIdCita()))
                return new ResponseEntity("el id ya existe", HttpStatus.BAD_REQUEST);
            return ResponseEntity.ok(citaService.save(citaDto));
        } catch (Exception e) {
            return (ResponseEntity<Cita>) ResponseEntity.badRequest();
        }

    }

  /*  @PutMapping("/usuario")
    public ResponseEntity<Usuario> update(@RequestBody UsuarioDto usuarioDto){
        if(!citaService.existsId(usuarioDto.getId()))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        if(citaService.existsNombre(usuarioDto.getNombre()) && !citaService.getOne(usuarioDto.getId()).getNombre().equals(usuarioDto.getNombre()))
            return new ResponseEntity("ese nombre ya existe", HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(citaService.update(usuarioDto));

    }*/

    @DeleteMapping("/cita/{idCita}")
    public ResponseEntity<?> delete(@PathVariable("idCita") String idCita) {
        if (!citaService.existsId(idCita))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        citaService.delete(idCita);
        return new ResponseEntity("cita eliminada", HttpStatus.OK);
    }

}


