package com.databits.siniestros.siniestros.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class SiniestroDto {
	private Long id;
    private String hora;
    private String fecha;
    private String folio;
    private BigDecimal monto;
    private String tipo_siniestro;
    private TiendaDto tienda;
    private List<TestigoDto> testigos;
    private List<PerpetradorDto> perpetradores;
    private String estado_verificacion;
    private String timestamp_guardado;
}