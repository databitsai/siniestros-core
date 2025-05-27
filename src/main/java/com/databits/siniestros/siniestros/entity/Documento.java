package com.databits.siniestros.siniestros.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Documento {
    private String nombre;
    private String estado;
    private String tipo;


}

