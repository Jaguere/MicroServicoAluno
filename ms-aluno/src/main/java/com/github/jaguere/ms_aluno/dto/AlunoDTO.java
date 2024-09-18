package com.github.jaguere.ms_aluno.dto;

import com.github.jaguere.ms_aluno.model.Aluno;
import com.github.jaguere.ms_aluno.model.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO {
    private Long id;
    @NotNull(message = "Campo Obrigatório")
    private String nome;
    @NotNull(message = "Campo Obrigatório")
    private String email;
    @NotNull(message = "Campo Obrigatório")
    @Size(min = 8,message = "A senha deve ter no mínimo 8 caracteres")
    private String password;
    @NotNull(message = "Campo Obrigatório")
    @Size(min=5,max = 5,message = "O RM deve ter 5 dígitos")
    private String rm;
    private String turma;
    @Enumerated(EnumType.STRING)
    private Status status;


}
