package com.github.jaguere.ms_aluno.repository;

import com.github.jaguere.ms_aluno.model.Aluno;
import com.github.jaguere.ms_aluno.repository.AlunoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class AlunoRepositoryTests {
    private Long existingId;
    private Long nonExistingId;
    private Long countTotalAluno;

    @BeforeEach
    void setup() throws Exception {
        existingId = 1L;
        nonExistingId = 100L;
        countTotalAluno = 3L;
    }

    @Autowired
    private AlunoRepository repository;

    @Test
    @DisplayName("Delete quando ID é valido")
    public void deleteWhenValid(){
        repository.deleteById(existingId);
        Optional<Aluno> result = repository.findById(existingId);

        Assertions.assertFalse(result.isPresent());

    }

    @Test
    @DisplayName("Save quando id for nulo deve salvar com incremento automatico")
    public void insertWhenIdNull() {

    }


}
