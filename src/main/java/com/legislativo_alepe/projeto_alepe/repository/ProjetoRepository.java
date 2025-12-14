package com.legislativo_alepe.projeto_alepe.repository;

import com.legislativo_alepe.projeto_alepe.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    // Foi necessário escrever manualmente a QUERY para que o spring acessasse o
    // atributo 'nome' da classe 'Deputado'
    // Temos aqui JPQL (Java Persistence Query Language)
    @Query("SELECT p from Projeto p WHERE LOWER(p.deputado.nome) LIKE LOWER(CONCAT('%',:nome,'%')) ")
    List<Projeto> findByDeputado(String nome);

    List<Projeto> findByTeorContainingIgnoreCase(String palavraChave);

    List<Projeto> findByEmentaContainingIgnoreCase(String palavraChave);

}
