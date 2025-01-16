package com.yobrunox.backendsintad.controller;

import com.yobrunox.backendsintad.dto.exception.ErrorAndResponseDTO;
import com.yobrunox.backendsintad.dto.tipoContribuyente.TipoContribuyenteCreateDTO;
import com.yobrunox.backendsintad.dto.tipoContribuyente.TipoContribuyenteGetDTO;
import com.yobrunox.backendsintad.service.TipoContribuyenteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user/tipoContribuyente")
@AllArgsConstructor
public class TipoContribuyenteController {
    private final TipoContribuyenteService tipoContribuyenteService;

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        List<TipoContribuyenteGetDTO> tipoContribuyentes = tipoContribuyenteService.getAllTipoContribuyentes();
        ErrorAndResponseDTO response = ErrorAndResponseDTO.builder()
                .message("Tipo de contribuyentes obtenidas")
                .code("R-200")
                .body(tipoContribuyentes)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        TipoContribuyenteGetDTO tipoContribuyente = tipoContribuyenteService.getTipoContribuyente(id);
        ErrorAndResponseDTO response = ErrorAndResponseDTO.builder()
                .message("Tipo de contribuyente obtenida correctamente")
                .code("R-200")
                .body(tipoContribuyente)
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@Valid @RequestBody TipoContribuyenteCreateDTO tipoContribuyenteCreateDTO) {
        TipoContribuyenteGetDTO tipoContribuyente = tipoContribuyenteService.crearTipoContribuyente(tipoContribuyenteCreateDTO);
        ErrorAndResponseDTO response = ErrorAndResponseDTO.builder()
                .message("Tipo contribuyente creada correctamente")
                .code("R-200")
                .body(tipoContribuyente)
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody TipoContribuyenteCreateDTO tipoContribuyenteCreateDTO, @PathVariable Integer id){
        TipoContribuyenteGetDTO tipoContribuyente = tipoContribuyenteService.actualizarTipoContribuyente(tipoContribuyenteCreateDTO,id);
        ErrorAndResponseDTO response = ErrorAndResponseDTO.builder()
                .message("Tipo contribuyente actualizada correctamente")
                .code("R-200")
                .body(tipoContribuyente)
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        tipoContribuyenteService.eliminarTipoContribuyente(id);
        ErrorAndResponseDTO response = ErrorAndResponseDTO.builder()
                .message("Tipo contribuyente eliminado correctamente")
                .code("R-200")
                .build();
        return ResponseEntity.ok(response);
    }

}
