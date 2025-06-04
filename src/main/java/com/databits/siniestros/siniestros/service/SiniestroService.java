package com.databits.siniestros.siniestros.service;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.databits.siniestros.siniestros.dto.SiniestroDto;
import com.databits.siniestros.siniestros.entity.Llamada;
import com.databits.siniestros.siniestros.entity.Siniestro;
import com.databits.siniestros.siniestros.entity.Tienda;
import com.databits.siniestros.siniestros.repository.LlamadaRepository;
import com.databits.siniestros.siniestros.repository.SiniestroRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SiniestroService {

    @Autowired
    private SiniestroRepository siniestroRepository;
    
    @Autowired
    private LlamadaRepository llamadaRepository;
    
    @Autowired
    private ObjectMapper objectMapper;

    public List<Siniestro> getAllSiniestros() {
       return siniestroRepository.findAll();
    }
    
    public List<Siniestro> getAllLLamadas() {
    	
    	System.out.println("Antes de convertir");
    	System.out.println("*");
    	
    	List<SiniestroDto> DTOS =  llamadaRepository.findAll().stream()
                .map(this::convertirJsonALlamada)
                .collect(Collectors.toList());
    	
    	System.out.println("Despues de convertir DTOS");
    	System.out.println("*");
    	
    	return DTOS.stream()
                .map(this::convertirUno)
                .collect(Collectors.toList());
    	
        
     }
    
    public SiniestroDto convertirJsonALlamada(Llamada llamada) {
        try {
        	
        	SiniestroDto dto = objectMapper.readValue(llamada.getSiniestroData(), SiniestroDto.class);
        	dto.setId(llamada.getId()); // 💥 Aquí le pasas el id de la llamada
        	return dto;
        	
        } catch (Exception e) {
            throw new RuntimeException("Error al convertir siniestro_data a SiniestroDto", e);
        }
    }
    
    private Siniestro convertirUno(SiniestroDto dto) {
        Siniestro siniestro = new Siniestro();

        // Combinar fecha y hora
        String fechaHoraStr = dto.getFecha() + "T" + dto.getHora() + ":00-06:00";
        ZonedDateTime fechaHora = ZonedDateTime.parse(fechaHoraStr, DateTimeFormatter.ISO_OFFSET_DATE_TIME);

        siniestro.setId(dto.getId().toString());
        siniestro.setHoraAproximada(fechaHora);
        siniestro.setFechaRegistro(fechaHora);
        siniestro.setCreatedAt(ZonedDateTime.now());

        siniestro.setTipoSiniestro(dto.getTipo_siniestro());
        siniestro.setMontoEstimado(dto.getMonto());
        siniestro.setTiempo(dto.getHora() + "h 00m");
        siniestro.setPrioridad("Alta");
        siniestro.setDocumentos(null); // Si decides usar documentos reales, actualiza aquí

        
        //TIENDA EN BD
        Tienda tienda = new Tienda();
        tienda.setId("500");
        tienda.setNombre("Tienda Sur");
        tienda.setDireccion("Calle Sur 789");
        tienda.setCiudad("Guadalajara");
        tienda.setCodigoPostal("44100");
        

        siniestro.setTienda(tienda);

        return siniestro;
    }
}
