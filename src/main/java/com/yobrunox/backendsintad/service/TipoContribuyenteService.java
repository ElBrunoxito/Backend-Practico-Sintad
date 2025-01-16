package com.yobrunox.backendsintad.service;

import com.yobrunox.backendsintad.dto.exception.BusinessException;
import com.yobrunox.backendsintad.dto.tipoContribuyente.TipoContribuyenteCreateDTO;
import com.yobrunox.backendsintad.dto.tipoContribuyente.TipoContribuyenteGetDTO;
import com.yobrunox.backendsintad.model.TipoContribuyente;
import com.yobrunox.backendsintad.repository.TipoContribuyenteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TipoContribuyenteService {
    private final TipoContribuyenteRepository tipoContribuyenteRepository;

    public List<TipoContribuyenteGetDTO> getAllTipoContribuyentes()  {
        return tipoContribuyenteRepository.getAllTipoContribuyente().orElseThrow(
                ()->new BusinessException("E-500", HttpStatus.BAD_REQUEST, "Error al obtener los tipos de contribuyentes")
        );

    }
    public TipoContribuyenteGetDTO getTipoContribuyente(Integer idEntidad){
        boolean exists = tipoContribuyenteRepository.existsById(idEntidad);
        if(!exists){
            throw new BusinessException("E-404", HttpStatus.NOT_FOUND, "El tipo de contribuyente no existe");
        }
        TipoContribuyente tipoContribuyente = tipoContribuyenteRepository.findById(idEntidad).orElse(null);
        return new TipoContribuyenteGetDTO(tipoContribuyente);
    }

    @Transactional
    public TipoContribuyenteGetDTO crearTipoContribuyente(TipoContribuyenteCreateDTO tipoContribuyenteCreateDTO) {

        boolean exists = tipoContribuyenteRepository.existsByNombre(tipoContribuyenteCreateDTO.getNombre());
        if (exists) {
            throw new BusinessException("E-409", HttpStatus.CONFLICT, "Nombre ya existente");
        }
        TipoContribuyente tipoContribuyente = TipoContribuyente.builder()
                .nombre(tipoContribuyenteCreateDTO.getNombre())
                .estado(tipoContribuyenteCreateDTO.getEstado())
                .build();

        return new TipoContribuyenteGetDTO(tipoContribuyenteRepository.save(tipoContribuyente));
    }

    @Transactional
    public TipoContribuyenteGetDTO actualizarTipoContribuyente(TipoContribuyenteCreateDTO tipoContribuyenteCreateDTO, Integer idTipoContribuyente) {
        boolean exists = tipoContribuyenteRepository.existsById(idTipoContribuyente);
        if(!exists){
            throw new BusinessException("E-404", HttpStatus.NOT_FOUND, "El tipo de contribuyente no existe");
        }

        TipoContribuyente tipoContribuyente = TipoContribuyente.builder()
                .idTipoContribuyente(idTipoContribuyente)
                .nombre(tipoContribuyenteCreateDTO.getNombre())
                .estado(tipoContribuyenteCreateDTO.getEstado())
                .build();
        return new TipoContribuyenteGetDTO(tipoContribuyenteRepository.save(tipoContribuyente));

    }

    @Transactional
    public void eliminarTipoContribuyente(Integer idTipoContribuyente) {
        boolean exists = tipoContribuyenteRepository.existsById(idTipoContribuyente);
        if(!exists){
            throw new BusinessException("E-404", HttpStatus.NOT_FOUND, "El tipo de contribuyente no existe");
        }
        tipoContribuyenteRepository.deleteById(idTipoContribuyente);
    }
}
