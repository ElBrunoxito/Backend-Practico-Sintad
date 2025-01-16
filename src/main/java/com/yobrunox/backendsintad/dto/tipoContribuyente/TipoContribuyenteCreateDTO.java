package com.yobrunox.backendsintad.dto.tipoContribuyente;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoContribuyenteCreateDTO {
    private String nombre;
    private Boolean estado;
}
