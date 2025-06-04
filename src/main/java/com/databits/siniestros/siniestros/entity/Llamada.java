package com.databits.siniestros.siniestros.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "llamada")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Llamada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "siniestro_data", columnDefinition = "jsonb")
    private String siniestroData; // Se guarda como String y se convierte después

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    private Integer estatus;
}