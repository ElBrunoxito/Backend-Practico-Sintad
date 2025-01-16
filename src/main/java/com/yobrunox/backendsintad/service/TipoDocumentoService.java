package com.yobrunox.backendsintad.service;

import com.yobrunox.backendsintad.dto.exception.BusinessException;
import com.yobrunox.backendsintad.dto.tipoDocumento.TipoDocumentoCreateDTO;
import com.yobrunox.backendsintad.dto.tipoDocumento.TipoDocumentoGetDTO;
import com.yobrunox.backendsintad.model.TipoDocumento;
import com.yobrunox.backendsintad.repository.TipoDocumentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TipoDocumentoService {
    private final TipoDocumentoRepository tipoDocumentoRepository;

    public List<TipoDocumentoGetDTO> getAllTipDocumentos(){
        return tipoDocumentoRepository.getAllTipoDocumentos().orElseThrow(
                ()->new BusinessException("E-500", HttpStatus.BAD_REQUEST, "Error al obtener los tipos de documentos")
        );

    }

    public TipoDocumentoGetDTO getTipoDocumento(Integer idEntidad){
        boolean exists = tipoDocumentoRepository.existsById(idEntidad);
        if(!exists){
            throw new BusinessException("E-404", HttpStatus.NOT_FOUND, "El tipo de documento no existe");
        }
        TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(idEntidad).orElse(null);
        return new TipoDocumentoGetDTO(tipoDocumento);
    }

    @Transactional
    public TipoDocumentoGetDTO crearTipoDocumento(TipoDocumentoCreateDTO tipoDocumentoCreateDTO) {

        boolean exists = tipoDocumentoRepository.existsByCodigo(tipoDocumentoCreateDTO.getCodigo());
        if (exists) {
            throw new BusinessException("E-409", HttpStatus.CONFLICT, "Codigo existente");
        }
        TipoDocumento tipoDocumento = TipoDocumento.builder()
                .codigo(tipoDocumentoCreateDTO.getCodigo())
                .nombre(tipoDocumentoCreateDTO.getNombre())
                .descripcion(tipoDocumentoCreateDTO.getDescripcion())
                .estado(tipoDocumentoCreateDTO.getEstado())
                .build();

        return new TipoDocumentoGetDTO(tipoDocumentoRepository.save(tipoDocumento));
    }

    @Transactional
    public TipoDocumentoGetDTO actualizarTipoDocumento(TipoDocumentoCreateDTO tipoDocumentoCreateDTO, Integer idTipoDocumento) {
        boolean exists = tipoDocumentoRepository.existsById(idTipoDocumento);
        if(!exists){
            throw new BusinessException("E-404", HttpStatus.NOT_FOUND, "El tipo de documento no existe");
        }

        TipoDocumento tipoDocumento = TipoDocumento.builder()
                .idTipoDocumento(idTipoDocumento)
                .codigo(tipoDocumentoCreateDTO.getCodigo())
                .nombre(tipoDocumentoCreateDTO.getNombre())
                .descripcion(tipoDocumentoCreateDTO.getDescripcion())
                .estado(tipoDocumentoCreateDTO.getEstado())
                .build();

        return new TipoDocumentoGetDTO(tipoDocumentoRepository.save(tipoDocumento));

    }

    @Transactional
    public void eliminarTipoDocumento(Integer idTipoDocumento) {
        boolean exists = tipoDocumentoRepository.existsById(idTipoDocumento);
        if(!exists){
            throw new BusinessException("E-404", HttpStatus.NOT_FOUND, "El tipo de documento no existe");
        }
        tipoDocumentoRepository.deleteById(idTipoDocumento);
    }

}
