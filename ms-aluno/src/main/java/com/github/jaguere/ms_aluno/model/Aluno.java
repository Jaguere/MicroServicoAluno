package com.github.jaguere.ms_aluno.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbAluno")
@Entity
public class Aluno {
    @Id
    private Long id;
    private String nome;
    private String email;
    private String password;
    private String rm;
    private Status status;
    private String turma;
}
