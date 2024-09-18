package com.github.jaguere.ms_aluno.repository;

import com.github.jaguere.ms_aluno.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
}
