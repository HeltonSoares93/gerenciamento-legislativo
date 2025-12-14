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

import com.legislativo_alepe.projeto_alepe.model.Deputado;
import com.legislativo_alepe.projeto_alepe.service.DeputadoService;

@RestController
@RequestMapping("/deputados")
public class DeputadoController {

    @Autowired
    private DeputadoService service;

    @GetMapping
    public ResponseEntity<List<Deputado>> listarDeputados() {
        return ResponseEntity.ok().body(service.findAllDeputados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deputado> buscarDeputadoPorId(@PathVariable("id") Long id) {
        Optional<Deputado> deputadoSeExistir = service.findById(id);
        if (deputadoSeExistir.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(deputadoSeExistir.get());
    }

    @GetMapping("/partido")
    public ResponseEntity<List<Deputado>> buscarPorPartido(@RequestParam("partido") String partido) {
        List<Deputado> listaDeputados = service.findByPartido(partido);
        if (listaDeputados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(listaDeputados);
    }

    @PostMapping
    public ResponseEntity<Deputado> salvarDeputado(@RequestBody Deputado deputado) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarDeputado(deputado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Deputado> atualizarDeputado(@PathVariable("id") Long id, @RequestBody Deputado deputado) {
        Optional<Deputado> deputadoExiste = service.findById(id);
        if (deputadoExiste.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        deputado.setId(id);

        return ResponseEntity.ok().body(service.salvarDeputado(deputado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProjeto(@PathVariable("id") Long id) {
        Optional<Deputado> deputadoSeExistir = service.findById(id);
        if (deputadoSeExistir.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
