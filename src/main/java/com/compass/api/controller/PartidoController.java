package com.compass.api.controller;

import com.compass.api.dto.AssociadoComPartidoDTO;
import com.compass.api.dto.PartidoDTO;
import com.compass.api.enums.Ideologia;
import com.compass.api.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value= "/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @PostMapping
    @Transactional
    public ResponseEntity<PartidoDTO> save (@RequestBody PartidoDTO partidoDTO, UriComponentsBuilder uriBuilder){
        URI uri = uriBuilder.path("/partidos/{id}").buildAndExpand(partidoDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(partidoService.save(partidoDTO));
    }

    @GetMapping
    public ResponseEntity<List<PartidoDTO>> findAllOrByIdeologia(Ideologia ideologia) {
        if(ideologia != null) {
            return ResponseEntity.ok(partidoService.findByIdeologia(ideologia));
        }
        return ResponseEntity.ok(partidoService.findAll());
    }

    @GetMapping(value= "/{id}")
    public ResponseEntity<PartidoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(partidoService.findById(id));
    }

    @GetMapping(value= "/{id}/associados")
    public ResponseEntity<List<AssociadoComPartidoDTO>> findByPartidoAssociados(@PathVariable Long id){
        return ResponseEntity.ok(partidoService.findByPartidoAssociados(id));
    }

    @PutMapping(value="/{id}")
    @Transactional
    public ResponseEntity<PartidoDTO> updateById(@PathVariable Long id, @RequestBody PartidoDTO partidoDTO){
        return ResponseEntity.ok(partidoService.updateById(id, partidoDTO));
    }

    @DeleteMapping(value= "/{id}")
    @Transactional
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        partidoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}