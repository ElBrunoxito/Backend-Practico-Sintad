package com.yobrunox.backendsintad.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoDocumento;
    @Column(length = 20)
    private String codigo;
    @Column(length = 100)
    private String nombre;
    @Column(length = 200)
    private String descripcion;
    private Boolean estado;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "tipoDocumento")
    private List<Entidad> entidades;


}
