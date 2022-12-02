package com.compass.api.domain;

import com.compass.api.dto.PartidoDTO;
import com.compass.api.enums.Ideologia;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Partido  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String nomeDoPartido;

    private String sigla;

    @Enumerated(EnumType.STRING)
    private Ideologia ideologia;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeFundacao;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tb_idPartido")
    private List<Associado> associados = new ArrayList<Associado>();

    public Partido() {}

    public Partido(PartidoDTO partidoDTO) {
        this.id = partidoDTO.getId();
        this.nomeDoPartido = partidoDTO.getNomeDoPartido();
        this.sigla = partidoDTO.getSigla();
        this.ideologia = partidoDTO.getIdeologia();
        this.dataDeFundacao = partidoDTO.getDataDeFundacao();
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

    public List<Associado> getAssociado() {
        return associados;
    }

    public void setAssociados(List<Associado> associados) {
        this.associados = associados;
    }
    public List<Associado> getAssociados() {
        return associados;
    }
    public void addAssociado(Associado associado) {
        associados.add(associado);
    }
    public void removeAssociado(Associado associado) {
        associados.remove(associado);
    }

    public boolean procurarAssociado(Associado associado) {
        return associados.contains(associado);
    }

    public PartidoDTO converter(Partido partido) {
        return new PartidoDTO(partido);
    }


}