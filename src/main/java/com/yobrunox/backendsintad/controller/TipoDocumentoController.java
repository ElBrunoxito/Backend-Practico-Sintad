package com.yobrunox.backendsintad.controller;

import com.yobrunox.backendsintad.dto.exception.ErrorAndResponseDTO;
import com.yobrunox.backendsintad.dto.tipoDocumento.TipoDocumentoCreateDTO;
import com.yobrunox.backendsintad.dto.tipoDocumento.TipoDocumentoGetDTO;
import com.yobrunox.backendsintad.service.TipoDocumentoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user/tipoDocumento")
@AllArgsConstructor
public class TipoDocumentoController {

    private final TipoDocumentoService tipoDocumentoService;

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        List<TipoDocumentoGetDTO> tipoDocumentos = tipoDocumentoService.getAllTipDocumentos();
        ErrorAndResponseDTO response = ErrorAndResponseDTO.builder()
                .message("Tipo de documentos obtenidos")
                .code("R-200")
                .body(tipoDocumentos)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<?> getAll(@PathVariable Integer id) {
        TipoDocumentoGetDTO tipoDocumento = tipoDocumentoService.getTipoDocumento(id);
        ErrorAndResponseDTO response = ErrorAndResponseDTO.builder()
                .message("Tipo de documento obtenido correctamente")
                .code("R-200")
                .body(tipoDocumento)
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@Valid @RequestBody TipoDocumentoCreateDTO tipoDocumentoCreateDTO) {
        TipoDocumentoGetDTO tipoDocumento = tipoDocumentoService.crearTipoDocumento(tipoDocumentoCreateDTO);
        ErrorAndResponseDTO response = ErrorAndResponseDTO.builder()
                .message("Tipo documento creada correctamente")
                .code("R-200")
                .body(tipoDocumento)
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody TipoDocumentoCreateDTO tipoDocumentoCreateDTO, @PathVariable Integer id){
        TipoDocumentoGetDTO tipoDocumento = tipoDocumentoService.actualizarTipoDocumento(tipoDocumentoCreateDTO,id);
        ErrorAndResponseDTO response = ErrorAndResponseDTO.builder()
                .message("Tipo documento actualizada correctamente")
                .code("R-200")
                .body(tipoDocumento)
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        tipoDocumentoService.eliminarTipoDocumento(id);
        ErrorAndResponseDTO response = ErrorAndResponseDTO.builder()
                .message("Tipo documento eliminado correctamente")
                .code("R-200")
                .build();
        return ResponseEntity.ok(response);
    }
}
