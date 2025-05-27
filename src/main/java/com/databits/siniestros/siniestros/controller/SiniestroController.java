package com.databits.siniestros.siniestros.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.databits.siniestros.siniestros.entity.Documento;
import com.databits.siniestros.siniestros.entity.Siniestro;
import com.databits.siniestros.siniestros.entity.Tienda;
import com.databits.siniestros.siniestros.service.SiniestroService;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/siniestros")
@CrossOrigin(origins = "*")
public class SiniestroController {

    @Autowired
    private SiniestroService siniestroService;

    @GetMapping
    public List<Siniestro> getAllSiniestros() {
       // return siniestroService.getAllSiniestros();

        Tienda tienda = new Tienda();
        tienda.setId(UUID.randomUUID());
        tienda.setNombre("Tienda Sur");
        tienda.setDireccion("Calle Sur 789");
        tienda.setCiudad("Guadalajara");
        tienda.setCodigoPostal("44100");

          Siniestro s1 = new Siniestro();
        s1.setId(UUID.randomUUID());
        s1.setTienda(tienda);
        s1.setTipoSiniestro("Robo");
        s1.setTiempo("2h 15m");
        s1.setPrioridad("Alta");
        s1.setDocumentos(Arrays.asList(
            new Documento("Reporte Inicial", "Generado", "PDF"),
            new Documento("Declaración de Hechos", "Generado", "DOCX"),
            new Documento("Inventario Afectado", "Generado", "XLSX"),
            new Documento("Formulario Aseguradora", "Generado", "PDF")
        ));

        // Siniestro 2
        Siniestro s2 = new Siniestro();
        s2.setId(UUID.randomUUID());
        s2.setTienda(tienda);
        s2.setTipoSiniestro("Daño");
        s2.setTiempo("5h 30m");
        s2.setPrioridad("Media");
        s2.setDocumentos(Arrays.asList(
            new Documento("Reporte Inicial", "Generado", "PDF"),
            new Documento("Evaluación de Daños", "Generado", "DOCX"),
            new Documento("Presupuesto Reparación", "Generado", "XLSX")
        ));

        // Siniestro 3
        Siniestro s3 = new Siniestro();
        s3.setId(UUID.randomUUID());
        s3.setTienda(tienda);
        s3.setTipoSiniestro("Extravío");
        s3.setTiempo("8h 45m");
        s3.setPrioridad("Baja");
        s3.setDocumentos(Arrays.asList(
            new Documento("Reporte Inicial", "Generado", "PDF"),
            new Documento("Lista de Elementos", "Generado", "XLSX")
        ));

        return Arrays.asList(s1, s2, s3);
    }
}