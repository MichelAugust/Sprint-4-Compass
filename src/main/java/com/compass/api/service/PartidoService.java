package com.compass.api.service;

import com.compass.api.domain.Associado;
import com.compass.api.domain.Partido;
import com.compass.api.dto.AssociadoComPartidoDTO;
import com.compass.api.dto.PartidoDTO;
import com.compass.api.enums.Ideologia;
import com.compass.api.exceptions.DeletePartidoException;
import com.compass.api.exceptions.EntityNotFoundException;
import com.compass.api.exceptions.MethodArgumentNotValidException;
import com.compass.api.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    public List<PartidoDTO> findByIdeologia(Ideologia ideologia) {
        return partidoRepository.findByIdeologia(ideologia);
    }

    public List<PartidoDTO> findAll() {
        List<Partido> partidos = partidoRepository.findAll();
        List<PartidoDTO> partidosDto = partidos.stream()
                .map(a -> a.converter(a)).collect(Collectors.toList());
        return partidosDto;
    }

    public List<AssociadoComPartidoDTO> findByPartidoAssociados(Long id) {
        Partido partido = findByPartido(id);
        List<Associado> associados = partido.getAssociados();
        List<AssociadoComPartidoDTO> associadosDto = associados.stream()
                .map(a -> a.converter(a, partido)).collect(Collectors.toList());
        return associadosDto;
    }

    public PartidoDTO findById(Long id) {
        Partido partido = findByPartido(id);
        return new PartidoDTO(partido);
    }


    public PartidoDTO save(PartidoDTO partidoDto) {
        Partido partido = new Partido(partidoDto);
        try {
            partidoRepository.save(partido);
            return new PartidoDTO(partido);
        } catch (MethodArgumentNotValidException e) {
            throw new MethodArgumentNotValidException(e.getMessage());
        }
    }

    public PartidoDTO updateById(Long id, PartidoDTO partidoDto) {
        Partido atualizarPartido = findByPartido(id);
        try {
            atualizarPartido.setNomeDoPartido(partidoDto.getNomeDoPartido());
            atualizarPartido.setSigla(partidoDto.getSigla());
            atualizarPartido.setIdeologia(partidoDto.getIdeologia());
            atualizarPartido.setDataDeFundacao(partidoDto.getDataDeFundacao());
            return new PartidoDTO(atualizarPartido);
        } catch (MethodArgumentNotValidException e) {
            throw new MethodArgumentNotValidException(e.getMessage());
        }
    }

    public void deleteById(Long id) {
        List<Associado> associados = findByPartido(id).getAssociados();
        if (associados.isEmpty()) {
            partidoRepository.deleteById(id);
        } else {
            throw new DeletePartidoException
                    ("Partido com associados, para deletar descadastrar do partido primeiro.");
        }
    }

    private Partido findByPartido(Long id) {
        Partido partido = partidoRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("ID NOT FOUND"));
        return partido;
    }
}