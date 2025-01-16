package com.yobrunox.backendsintad.repository;

import com.yobrunox.backendsintad.dto.entidad.EntidadGetDTO;
import com.yobrunox.backendsintad.dto.tipoContribuyente.TipoContribuyenteGetDTO;
import com.yobrunox.backendsintad.model.TipoContribuyente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoContribuyenteRepository extends JpaRepository<TipoContribuyente, Integer> {
    @Query("SELECT NEW com.yobrunox.backendsintad.dto.tipoContribuyente.TipoContribuyenteGetDTO(TC.idTipoContribuyente,TC.nombre,TC.estado) " +
            "FROM TipoContribuyente TC")
    Optional<List<TipoContribuyenteGetDTO>> getAllTipoContribuyente();

    boolean existsByNombre(String nombre);
}
