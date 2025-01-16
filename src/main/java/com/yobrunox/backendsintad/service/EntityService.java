package com.yobrunox.backendsintad.service;

import com.yobrunox.backendsintad.dto.entidad.EntidadCreateDTO;
import com.yobrunox.backendsintad.dto.entidad.EntidadGetDTO;
import com.yobrunox.backendsintad.dto.entidad.EntidadOnlyGetDTO;
import com.yobrunox.backendsintad.dto.exception.BusinessException;
import com.yobrunox.backendsintad.model.Entidad;
import com.yobrunox.backendsintad.model.TipoContribuyente;
import com.yobrunox.backendsintad.model.TipoDocumento;
import com.yobrunox.backendsintad.repository.EntidadRepository;
import com.yobrunox.backendsintad.repository.TipoContribuyenteRepository;
import com.yobrunox.backendsintad.repository.TipoDocumentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class EntityService {


    private final EntidadRepository entidadRepository;
    private final TipoContribuyenteRepository tipoContribuyenteRepository;
    private final TipoDocumentoRepository tipoDocumentoRepository;

    public List<EntidadGetDTO> getAllEntidades(){
        return entidadRepository.getAllEntities().orElseThrow(
                ()->new BusinessException("E-500", HttpStatus.BAD_REQUEST, "Error al obtener la entidades")
        );

    }
    public EntidadOnlyGetDTO getEntidad(Integer idEntidad){
        boolean exists = entidadRepository.existsById(idEntidad);
        if(!exists){
            throw new BusinessException("E-404", HttpStatus.NOT_FOUND, "La entidad no existe");
        }
        Entidad entidad = entidadRepository.findById(idEntidad).orElse(null);
        return new EntidadOnlyGetDTO(entidad);
    }

    @Transactional
    public EntidadGetDTO crearEntidad(EntidadCreateDTO entidadCreateDTO) {

        boolean exists = entidadRepository.existsByNroDocumento(entidadCreateDTO.getNroDocumento());
        if (exists) {
            throw new BusinessException("E-409", HttpStatus.CONFLICT, "Numero de documento ya existente");
        }
        TipoContribuyente tipoContribuyente = tipoContribuyenteRepository.findById(entidadCreateDTO.getIdTipoContribuyente()).orElseThrow(
                ()-> new BusinessException("E-404", HttpStatus.NOT_FOUND, "No se encontro el tipo contribuyente")

        );
        TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(entidadCreateDTO.getIdTipoDocumento()).orElseThrow(
                ()-> new BusinessException("E-404", HttpStatus.NOT_FOUND, "No se encontro el tipo de documento")

        );
        Entidad entidad = Entidad.builder()
                .nroDocumento(entidadCreateDTO.getNroDocumento())
                .razonSocial(entidadCreateDTO.getRazonSocial())
                .nombreComercial(entidadCreateDTO.getNombreComercial())
                .direccion(entidadCreateDTO.getDireccion())
                .telefono(entidadCreateDTO.getTelefono())
                .estado(entidadCreateDTO.getEstado())
                .tipoDocumento(tipoDocumento)
                .tipoContribuyente(tipoContribuyente)
                .build();

        return new EntidadGetDTO(entidadRepository.save(entidad));
    }

    @Transactional
    public EntidadGetDTO actualizarEntidad(EntidadCreateDTO entidadCreateDTO, Integer idEntidad) {
        boolean exists = entidadRepository.existsById(idEntidad);
        if(!exists){
            throw new BusinessException("E-404", HttpStatus.NOT_FOUND, "La entidad no existe");
        }
        TipoContribuyente tipoContribuyente = tipoContribuyenteRepository.findById(entidadCreateDTO.getIdTipoContribuyente()).orElseThrow(
                ()-> new BusinessException("E-404", HttpStatus.NOT_FOUND, "No se encontro el tipo contribuyente")

        );
        TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(entidadCreateDTO.getIdTipoDocumento()).orElseThrow(
                ()-> new BusinessException("E-404", HttpStatus.NOT_FOUND, "No se encontro el tipo de documento")

        );

        Entidad entidad = Entidad.builder()
                .idEntidad(idEntidad)
                .nroDocumento(entidadCreateDTO.getNroDocumento())
                .razonSocial(entidadCreateDTO.getRazonSocial())
                .nombreComercial(entidadCreateDTO.getNombreComercial())
                .direccion(entidadCreateDTO.getDireccion())
                .telefono(entidadCreateDTO.getTelefono())
                .estado(entidadCreateDTO.getEstado())
                .tipoDocumento(tipoDocumento)
                .tipoContribuyente(tipoContribuyente)
                .build();

        return new EntidadGetDTO(entidadRepository.save(entidad));
    }

    @Transactional
    public void eliminarEntidad(Integer idEntidad) {
        boolean exists = entidadRepository.existsById(idEntidad);
        if(!exists){
            throw new BusinessException("E-404", HttpStatus.NOT_FOUND, "La entidad no existe");
        }
        entidadRepository.deleteById(idEntidad);
    }


}

/*

*/