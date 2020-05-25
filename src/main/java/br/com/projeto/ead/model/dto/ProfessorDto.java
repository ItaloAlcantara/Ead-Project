package br.com.projeto.ead.model.dto;

import br.com.projeto.ead.model.Classe;
import br.com.projeto.ead.model.Instituicao;
import br.com.projeto.ead.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDto {

    private Long id;

    private Pessoa pessoa;

    private Instituicao instituicao;

    private Classe classe;
}
