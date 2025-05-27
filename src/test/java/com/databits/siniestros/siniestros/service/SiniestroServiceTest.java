package com.databits.siniestros.siniestros.service;

import com.databits.siniestros.siniestros.entity.Siniestro;
import com.databits.siniestros.siniestros.repository.SiniestroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SiniestroServiceTest {

    private SiniestroRepository siniestroRepository;
    private SiniestroService siniestroService;

    @BeforeEach
    void setUp() {
        siniestroRepository = mock(SiniestroRepository.class);
        siniestroService = new SiniestroService();
 
        siniestroService = new SiniestroService();
        siniestroService.getClass().getDeclaredFields();
        var field = SiniestroService.class.getDeclaredFields()[0]; 
        field.setAccessible(true);
        try {
            field.set(siniestroService, siniestroRepository);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testGetAllSiniestros() {

        Siniestro s1 = new Siniestro(UUID.randomUUID(), ZonedDateTime.now(), new BigDecimal("1000"), "Robo", ZonedDateTime.now(), ZonedDateTime.now(), null);
        Siniestro s2 = new Siniestro(UUID.randomUUID(), ZonedDateTime.now(), new BigDecimal("2000"), "Daño", ZonedDateTime.now(), ZonedDateTime.now(), null);
        List<Siniestro> siniestros = Arrays.asList(s1, s2);

        when(siniestroRepository.findAll()).thenReturn(siniestros);

        List<Siniestro> result = siniestroService.getAllSiniestros();
        assertEquals(2, result.size());
        assertEquals("Robo", result.get(0).getTipoSiniestro());
        verify(siniestroRepository, times(1)).findAll();
    }
}
