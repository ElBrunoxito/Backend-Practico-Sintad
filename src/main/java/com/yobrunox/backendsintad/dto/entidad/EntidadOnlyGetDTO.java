package com.yobrunox.backendsintad.dto.entidad;

import com.yobrunox.backendsintad.model.Entidad;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EntidadOnlyGetDTO {
    private Integer idEntidad;
    private String nroDocumento;
    private String razonSocial;
    private String nombreComercial;
    private String direccion;
    private String telefono;
    private Boolean estado;
    private Integer idTipoDocumento;
    private Integer idTipoContribuyente;

    public EntidadOnlyGetDTO(Entidad entidad) {
        this.idEntidad = entidad.getIdEntidad();
        this.nroDocumento = entidad.getNroDocumento();
        this.razonSocial = entidad.getRazonSocial();
        this.nombreComercial = entidad.getNombreComercial();
        this.direccion = entidad.getDireccion();
        this.telefono = entidad.getTelefono();
        this.estado = entidad.getEstado();
        this.idTipoDocumento = entidad.getTipoDocumento().getIdTipoDocumento();
        this.idTipoContribuyente = entidad.getTipoContribuyente().getIdTipoContribuyente();

    }
}
