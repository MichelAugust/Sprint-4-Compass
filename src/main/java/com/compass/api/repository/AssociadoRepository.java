package com.compass.api.repository;

import com.compass.api.domain.Associado;
import com.compass.api.enums.CargoPolitico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {
    List<Associado> findByCargoPolitico(CargoPolitico cargo);
}