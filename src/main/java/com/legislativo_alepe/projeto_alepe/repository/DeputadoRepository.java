package com.legislativo_alepe.projeto_alepe.repository;

import com.legislativo_alepe.projeto_alepe.model.Deputado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeputadoRepository extends JpaRepository<Deputado, Long> {

    List<Deputado> findByNome(String nome);
    List<Deputado> findByPartido(String partido);

}
