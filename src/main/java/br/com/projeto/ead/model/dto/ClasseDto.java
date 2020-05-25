package br.com.projeto.ead.model.dto;

import br.com.projeto.ead.model.Aluno;
import br.com.projeto.ead.model.Professor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ClasseDto {

    private Long id;

    private Professor professor;

    private Aluno aluno;
}
