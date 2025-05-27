package com.databits.siniestros.siniestros.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "siniestros")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Siniestro {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "hora_aproximada", nullable = false)
    private ZonedDateTime horaAproximada;


    @Column(name = "monto_estimado", nullable = false)
    private BigDecimal montoEstimado;

    @Column(name = "tipo_siniestro", nullable = false)
    private String tipoSiniestro;

    @Column(name = "fecha_registro")
    private ZonedDateTime fechaRegistro;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "id_tienda", referencedColumnName = "id")
    private Tienda tienda;

}
