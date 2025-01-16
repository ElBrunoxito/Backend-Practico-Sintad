package com.yobrunox.backendsintad.controller;

import com.yobrunox.backendsintad.dto.entidad.EntidadCreateDTO;
import com.yobrunox.backendsintad.dto.entidad.EntidadGetDTO;
import com.yobrunox.backendsintad.dto.entidad.EntidadOnlyGetDTO;
import com.yobrunox.backendsintad.dto.exception.ErrorAndResponseDTO;
import com.yobrunox.backendsintad.model.Entidad;
import com.yobrunox.backendsintad.service.EntityService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user/entidad")
@AllArgsConstructor
public class EntidadController {


    private final EntityService entityService;

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        List<EntidadGetDTO> entidades = entityService.getAllEntidades();
        ErrorAndResponseDTO response = ErrorAndResponseDTO.builder()
                .message("Entidades obtenidas")
                .code("R-200")
                .body(entidades)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<?> getAll(@PathVariable Integer id) {
        EntidadOnlyGetDTO entidad = entityService.getEntidad(id);
        ErrorAndResponseDTO response = ErrorAndResponseDTO.builder()
                .message("Entidad obtenida correctamente")
                .code("R-200")
                .body(entidad)
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@Valid @RequestBody EntidadCreateDTO entidadRequest) {
        EntidadGetDTO entidad = entityService.crearEntidad(entidadRequest);
        ErrorAndResponseDTO response = ErrorAndResponseDTO.builder()
                .message("Entidad creada correctamente")
                .code("R-200")
                .body(entidad)
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody EntidadCreateDTO entidadRequest, @PathVariable Integer id){
        EntidadGetDTO entidad = entityService.actualizarEntidad(entidadRequest,id);
        ErrorAndResponseDTO response = ErrorAndResponseDTO.builder()
                .message("Entidad actualizada correctamente")
                .code("R-200")
                .body(entidad)
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        entityService.eliminarEntidad(id);
        ErrorAndResponseDTO response = ErrorAndResponseDTO.builder()
                .message("Entidad eliminada  correctamente")
                .code("R-200")
                .build();
        return ResponseEntity.ok(response);
    }




}
