package com.compass.api.service;

import com.compass.api.domain.Associado;
import com.compass.api.enums.CargoPolitico;
import com.compass.api.exceptions.EntityNotFoundException;
import com.compass.api.exceptions.MethodArgumentNotValidException;
import com.compass.api.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociadoService {

    @Autowired
    private AssociadoRepository associadoRepository;

    public List<Associado> findByCargoPolitico(CargoPolitico cargo) {
        return associadoRepository.findByCargoPolitico(cargo);
    }

    public List<Associado> findAll() {
        return associadoRepository.findAll();
    }

    public Associado findById(Long id) {
        return associadoRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("ID NOT FOUND!"));
    }

    public Associado save(Associado associado) {
        try {
            return associadoRepository.save(associado);
        } catch (MethodArgumentNotValidException e) {
            throw new MethodArgumentNotValidException(e.getMessage());
        }

    }

    public Associado updateById(Long id, Associado associado) {
        Associado atualizarAssociado = findById(id);
        try {
            atualizarAssociado.setNome(associado.getNome());
            atualizarAssociado.setCargoPolitico(associado.getCargoPolitico());
            atualizarAssociado.setDataDeNascimento(associado.getDataDeNascimento());
            atualizarAssociado.setSexo(associado.getSexo());
            return atualizarAssociado;
        } catch (MethodArgumentNotValidException e) {
            throw new MethodArgumentNotValidException(e.getMessage());
        }
    }

    public void deleteById(Long id) {
        findById(id);
        associadoRepository.deleteById(id);
    }
}