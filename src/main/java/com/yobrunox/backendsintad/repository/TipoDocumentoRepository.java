package com.yobrunox.backendsintad.repository;

import com.yobrunox.backendsintad.dto.tipoContribuyente.TipoContribuyenteGetDTO;
import com.yobrunox.backendsintad.dto.tipoDocumento.TipoDocumentoGetDTO;
import com.yobrunox.backendsintad.model.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {
    @Query("SELECT NEW com.yobrunox.backendsintad.dto.tipoDocumento.TipoDocumentoGetDTO(TD.idTipoDocumento,TD.codigo,TD.nombre,TD.descripcion,TD.estado) " +
            "FROM TipoDocumento TD")
    Optional<List<TipoDocumentoGetDTO>> getAllTipoDocumentos();

    boolean existsByCodigo(String codigo);
}
