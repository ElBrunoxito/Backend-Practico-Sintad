package com.yobrunox.backendsintad.dto.tipoDocumento;

import com.yobrunox.backendsintad.model.TipoDocumento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoDocumentoGetDTO {

    private Integer idTipoDocumento;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Boolean estado;

    public TipoDocumentoGetDTO(TipoDocumento tipoDocumento) {
        idTipoDocumento = tipoDocumento.getIdTipoDocumento();
        codigo = tipoDocumento.getCodigo();
        nombre = tipoDocumento.getNombre();
        descripcion = tipoDocumento.getDescripcion();
        estado = tipoDocumento.getEstado();
    }

}
