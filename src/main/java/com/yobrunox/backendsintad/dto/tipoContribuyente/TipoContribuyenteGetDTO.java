package com.yobrunox.backendsintad.dto.tipoContribuyente;


import com.yobrunox.backendsintad.model.TipoContribuyente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoContribuyenteGetDTO {

    private Integer idTipoContribuyente;
    private String nombre;
    private Boolean estado;

    public TipoContribuyenteGetDTO(TipoContribuyente tipoContribuyente){
        idTipoContribuyente = tipoContribuyente.getIdTipoContribuyente();
        nombre = tipoContribuyente.getNombre();
        estado = tipoContribuyente.getEstado();
    }

}
