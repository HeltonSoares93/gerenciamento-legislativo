package com.legislativo_alepe.projeto_alepe.service;

import com.legislativo_alepe.projeto_alepe.model.Deputado;
import com.legislativo_alepe.projeto_alepe.repository.DeputadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeputadoService {

    @Autowired
    private DeputadoRepository repository;

    public List<Deputado> findAllDeputados() {
        return repository.findAll();
    }

    public Optional<Deputado> findById(Long id) {
        return repository.findById(id);
    }

    public List<Deputado> findByNome(String nome) {
        return repository.findByNome(nome);
    }

    public List<Deputado> findByPartido(String partido) {
        return repository.findByPartido(partido);
    }

    public Deputado salvarDeputado(Deputado deputado) {
        return repository.save(deputado);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }


}
