package com.compass.api.repository;

import com.compass.api.domain.Partido;
import com.compass.api.dto.PartidoDTO;
import com.compass.api.enums.Ideologia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartidoRepository extends JpaRepository<Partido, Long> {

    List<PartidoDTO> findByIdeologia(Ideologia ideologia);

}
