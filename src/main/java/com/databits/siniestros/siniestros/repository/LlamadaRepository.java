package com.databits.siniestros.siniestros.repository;

import com.databits.siniestros.siniestros.entity.Llamada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LlamadaRepository extends JpaRepository<Llamada, Long> {
    // Aquí puedes agregar métodos personalizados si los necesitas después
}