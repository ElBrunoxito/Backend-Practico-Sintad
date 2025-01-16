package com.yobrunox.backendsintad;

import com.yobrunox.backendsintad.controller.TipoContribuyenteController;
import com.yobrunox.backendsintad.dto.tipoContribuyente.TipoContribuyenteCreateDTO;
import com.yobrunox.backendsintad.dto.tipoContribuyente.TipoContribuyenteGetDTO;
import com.yobrunox.backendsintad.model.Entidad;
import com.yobrunox.backendsintad.model.TipoContribuyente;
import com.yobrunox.backendsintad.repository.EntidadRepository;
import com.yobrunox.backendsintad.repository.TipoContribuyenteRepository;
import com.yobrunox.backendsintad.service.TipoContribuyenteService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)

public class TipoContribuyenteTest {
    private MockMvc mockMvc;

    @Mock
    private TipoContribuyenteRepository tipoContribuyenteRepository;

    @InjectMocks
    private TipoContribuyenteService tipoContribuyenteService;

    TipoContribuyenteGetDTO TC_1 = new TipoContribuyenteGetDTO(1,"Contribuyente 1",true);
    TipoContribuyenteGetDTO TC_2 = new TipoContribuyenteGetDTO(2,"Contribuyente 2",true);
    TipoContribuyenteGetDTO TC_3 = new TipoContribuyenteGetDTO(3,"Contribuyente 3",true);

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(tipoContribuyenteService).build();
    }
    @Test
    public void getAllTipoContribuyentes() throws Exception {
        List<TipoContribuyenteGetDTO> tcs = new ArrayList<>(Arrays.asList(TC_1,TC_2,TC_3));
        Mockito.when(tipoContribuyenteRepository.getAllTipoContribuyente()).thenReturn(Optional.of(tcs));

        List<TipoContribuyenteGetDTO> result = tipoContribuyenteService.getAllTipoContribuyentes();


        //Assertions.assertNotNull(result);
        Assertions.assertEquals(result,tcs);


    }
}
