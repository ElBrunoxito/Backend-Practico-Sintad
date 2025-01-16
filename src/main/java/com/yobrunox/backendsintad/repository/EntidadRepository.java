package com.yobrunox.backendsintad.repository;

import com.yobrunox.backendsintad.dto.entidad.EntidadGetDTO;
import com.yobrunox.backendsintad.model.Entidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntidadRepository extends JpaRepository<Entidad,Integer> {

    boolean existsByNroDocumento(String nroDocumento);

    @Query("SELECT NEW com.yobrunox.backendsintad.dto.entidad.EntidadGetDTO(E.idEntidad,E.nroDocumento,E.razonSocial,E.nombreComercial,E.direccion,E.telefono,E.estado,E.tipoDocumento.codigo,E.tipoContribuyente.nombre) " +
            "FROM Entidad E")
    Optional<List<EntidadGetDTO>> getAllEntities();
}
