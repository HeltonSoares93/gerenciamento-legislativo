package com.legislativo_alepe.projeto_alepe.service;

import com.legislativo_alepe.projeto_alepe.model.Projeto;
import com.legislativo_alepe.projeto_alepe.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {
    @Autowired
    private ProjetoRepository repository;

    public List<Projeto> findAllProjetos() {
        return repository.findAll();
    }

    public Optional<Projeto> findById(Long id) {
        return repository.findById(id);
    }

    public Projeto salvarProjeto(Projeto projeto) {
        return repository.save(projeto);
    }

    public void deleteProjeto(Long id) {
        repository.deleteById(id);
    }

    public List<Projeto> findByDeputado(String nome) {
        return repository.findByDeputado(nome);
    }

    public List<Projeto> findByTeor(String palavraChave) {
        return repository.findByTeorContainingIgnoreCase(palavraChave);
    }

    public List<Projeto> findByEmenta(String palavraChave) {
        return repository.findByEmentaContainingIgnoreCase(palavraChave);
    }

}
