package br.com.projeto.ead.model.dto;

import br.com.projeto.ead.model.Classe;
import br.com.projeto.ead.model.Pessoa;
import br.com.projeto.ead.model.Situacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AlunoDto {

    private Long id;

    private Pessoa pessoa;

    private Classe classe;

    private Situacao situacao;
}
