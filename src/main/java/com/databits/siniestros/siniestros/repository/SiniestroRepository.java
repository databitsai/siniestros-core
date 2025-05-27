package com.databits.siniestros.siniestros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.databits.siniestros.siniestros.entity.Siniestro;
import java.util.UUID;

public interface SiniestroRepository extends JpaRepository<Siniestro, UUID> {
}
