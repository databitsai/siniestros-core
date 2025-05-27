package com.databits.siniestros.siniestros.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.databits.siniestros.siniestros.entity.Siniestro;
import com.databits.siniestros.siniestros.service.SiniestroService;
import java.util.List;

@RestController
@RequestMapping("/api/siniestros")
@CrossOrigin(origins = "*")
public class SiniestroController {

    @Autowired
    private SiniestroService siniestroService;

    @GetMapping
    public List<Siniestro> getAllSiniestros() {
        return siniestroService.getAllSiniestros();
    }
}