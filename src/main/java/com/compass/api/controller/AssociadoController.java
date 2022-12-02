package com.compass.api.controller;


import com.compass.api.domain.Associado;
import com.compass.api.enums.CargoPolitico;
import com.compass.api.service.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value= "/associados")
public class AssociadoController {

    @Autowired
    private AssociadoService associadoService;

    @PostMapping
    @Transactional
    public ResponseEntity<Associado> save(@RequestBody Associado associado, UriComponentsBuilder uriBuilder){
        URI uri = uriBuilder.path("/associados/{id}").buildAndExpand(associado.getId()).toUri();
        return ResponseEntity.created(uri).body(associadoService.save(associado));
    }

    @GetMapping
    public ResponseEntity<List<Associado>> findAllByCargoPolitico(CargoPolitico cargo){
        if (cargo != null) {
            return ResponseEntity.ok(associadoService.findByCargoPolitico(cargo));
        }
        return ResponseEntity.ok(associadoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Associado> findById(@PathVariable Long id){
        return ResponseEntity.ok(associadoService.findById(id));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Associado> updateById(@PathVariable Long id, @RequestBody Associado associado){
        return ResponseEntity.ok(associadoService.updateById(id, associado));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        associadoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}