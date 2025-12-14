package com.legislativo_alepe.projeto_alepe.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name = "tb_deputados")
@AllArgsConstructor
@NoArgsConstructor
public class Deputado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 65)
    private String nome;

    @Column(nullable = false, length = 55)
    private String email;

    @Column(nullable = false, length = 25)
    private String partido;

    @Column(nullable = false, length = 6)
    private String num_gabinete;


}
