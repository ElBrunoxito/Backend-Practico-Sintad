package com.yobrunox.backendsintad.dto.tipoDocumento;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoDocumentoCreateDTO {
    private String codigo;
    private String nombre;
    private String descripcion;
    private Boolean estado;
}
