package com.databits.siniestros.siniestros.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.databits.siniestros.siniestros.entity.Siniestro;
import com.databits.siniestros.siniestros.repository.SiniestroRepository;


import java.util.List;

@Service
public class SiniestroService {

    @Autowired
    private SiniestroRepository siniestroRepository;

    public List<Siniestro> getAllSiniestros() {
       return siniestroRepository.findAll();
    }
}
