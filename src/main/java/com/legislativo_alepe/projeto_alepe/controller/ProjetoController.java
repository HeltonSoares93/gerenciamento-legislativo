package com.legislativo_alepe.projeto_alepe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.legislativo_alepe.projeto_alepe.model.Projeto;
import com.legislativo_alepe.projeto_alepe.service.ProjetoService;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

  @Autowired
  private ProjetoService service;

  @GetMapping
  public ResponseEntity<List<Projeto>> findAllProjetos() {
    return ResponseEntity.ok().body(service.findAllProjetos());
  }

  @PostMapping
  public ResponseEntity<Projeto> salvarProjeto(@RequestBody Projeto projeto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarProjeto(projeto));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Projeto> atualizarProjeto(@PathVariable("id") Long id, @RequestBody Projeto projeto) {
    Optional<Projeto> projetoExiste = service.findById(id);
    if (projetoExiste.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    projeto.setId(id);
    return ResponseEntity.ok().body(service.salvarProjeto(projeto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarProjeto(@PathVariable("id") Long id) {
    Optional<Projeto> projetoExiste = service.findById(id);
    if (projetoExiste.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    service.deleteProjeto(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/deputado")
  public ResponseEntity<List<Projeto>> listarProjetoPorDeputado(@RequestParam("deputado") String deputado) {
    List<Projeto> projetoDeputadoExiste = service.findByDeputado(deputado);
    if (projetoDeputadoExiste.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(projetoDeputadoExiste);
  }

  @GetMapping("/teor")
  public ResponseEntity<List<Projeto>> listarTeorPorPalavraChave(@RequestParam("teor") String palavraChave) {
    List<Projeto> projetoDeputadoExiste = service.findByTeor(palavraChave);
    if (projetoDeputadoExiste.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(projetoDeputadoExiste);
  }

  @GetMapping("/ementa")
  public ResponseEntity<List<Projeto>> listarEmentaPorPalavraChave(@RequestParam("ementa") String palavraChave) {
    List<Projeto> projetoDeputadoExiste = service.findByEmenta(palavraChave);
    if (projetoDeputadoExiste.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(projetoDeputadoExiste);
  }
}
