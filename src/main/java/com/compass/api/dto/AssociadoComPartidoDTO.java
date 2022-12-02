package com.compass.api.dto;

import com.compass.api.domain.Associado;
import com.compass.api.domain.Partido;
import com.compass.api.enums.CargoPolitico;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class AssociadoComPartidoDTO {

    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private CargoPolitico cargoPolitico;

    private String nomePartido;

    public AssociadoComPartidoDTO() {}

    public AssociadoComPartidoDTO(Associado associado, Partido partido) {
        this.setId(associado.getId());
        this.setNome(associado.getNome());
        this.setCargoPolitico(associado.getCargoPolitico());
        this.setNomePartido(partido.getNomeDoPartido());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CargoPolitico getCargoPolitico() {
        return cargoPolitico;
    }

    public void setCargoPolitico(CargoPolitico cargoPolitico) {
        this.cargoPolitico = cargoPolitico;
    }

    public String getNomePartido() {
        return nomePartido;
    }

    public void setNomePartido(String nomePartido) {
        this.nomePartido = nomePartido;
    }




}
