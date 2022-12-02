package com.compass.api.dto;

import com.compass.api.domain.Partido;
import com.compass.api.enums.Ideologia;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

public class PartidoDTO {

    private Long id;

    private String nomeDoPartido;

    private String sigla;

    @Enumerated(EnumType.STRING)
    private Ideologia ideologia;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeFundacao;

    public PartidoDTO() {}

    public PartidoDTO(Partido partido) {
        this.id = partido.getId();
        this.nomeDoPartido = partido.getNomeDoPartido();
        this.sigla = partido.getSigla();
        this.ideologia = partido.getIdeologia();
        this.dataDeFundacao = partido.getDataDeFundacao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDoPartido() {
        return nomeDoPartido;
    }

    public void setNomeDoPartido(String nomeDoPartido) {
        this.nomeDoPartido = nomeDoPartido;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Ideologia getIdeologia() {
        return ideologia;
    }

    public void setIdeologia(Ideologia ideologia) {
        this.ideologia = ideologia;
    }

    public LocalDate getDataDeFundacao() {
        return dataDeFundacao;
    }

    public void setDataDeFundacao(LocalDate dataDeFundacao) {
        this.dataDeFundacao = dataDeFundacao;
    }


}