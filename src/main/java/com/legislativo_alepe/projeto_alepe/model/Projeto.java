package com.legislativo_alepe.projeto_alepe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_projetos")
@NoArgsConstructor
@AllArgsConstructor
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String ementa;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String teor;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String justificativa;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Deputado deputado;
}
