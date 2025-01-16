package com.yobrunox.backendsintad.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Entidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEntidad;

    @Column(length = 20)
    private String nroDocumento;

    @Column(length = 50)
    private String razonSocial;
    @Column(length = 100)
    private String nombreComercial;
    @Column(length = 200)
    private String direccion;
    @Column(length = 30)
    private String telefono;

    private Boolean estado;


    @ManyToOne
    @JoinColumn(name = "id_tipo_documento")
    @JsonIgnore
    private TipoDocumento tipoDocumento;

    @ManyToOne
    @JoinColumn(name = "id_tipo_contribuyente")
    @JsonIgnore
    private TipoContribuyente tipoContribuyente;




}
