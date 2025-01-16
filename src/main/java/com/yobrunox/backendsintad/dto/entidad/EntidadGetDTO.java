package com.yobrunox.backendsintad.dto.entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yobrunox.backendsintad.model.Entidad;
import com.yobrunox.backendsintad.model.TipoContribuyente;
import com.yobrunox.backendsintad.model.TipoDocumento;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EntidadGetDTO {
    private Integer idEntidad;
    private String nroDocumento;
    private String razonSocial;
    private String nombreComercial;
    private String direccion;
    private String telefono;
    private Boolean estado;
    private String tipoDocumento;
    private String tipoContribuyente;



    public EntidadGetDTO(Entidad entidad) {
        this.idEntidad = entidad.getIdEntidad();
        this.nroDocumento = entidad.getNroDocumento();
        this.razonSocial = entidad.getRazonSocial();
        this.nombreComercial = entidad.getNombreComercial();
        this.direccion = entidad.getDireccion();
        this.telefono = entidad.getTelefono();
        this.estado = entidad.getEstado();
        this.tipoDocumento = entidad.getTipoDocumento().getCodigo();
        this.tipoContribuyente = entidad.getTipoContribuyente().getNombre();

    }

}
