package com.compass.api.domain;

import com.compass.api.dto.AssociadoComPartidoDTO;
import com.compass.api.enums.CargoPolitico;
import com.compass.api.enums.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Associado {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private CargoPolitico cargoPolitico;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeNascimento;

    private Sexo sexo;

    public Associado(Long id, String fulano, CargoPolitico prefeito, LocalDateTime parse, Sexo masculino) {

    }

    public Associado(Long id, String nome, CargoPolitico cargoPolitico, LocalDate dataDeNascimento, Sexo sexo) {
        super();
        this.id = id;
        this.nome = nome;
        this.cargoPolitico = cargoPolitico;
        this.dataDeNascimento = dataDeNascimento;
        this.sexo = sexo;
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

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public AssociadoComPartidoDTO converter(Associado associado, Partido partido) {
        return new AssociadoComPartidoDTO(associado, partido);
    }
}




