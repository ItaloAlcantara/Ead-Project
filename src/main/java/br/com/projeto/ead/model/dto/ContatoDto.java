package br.com.projeto.ead.model.dto;

import br.com.projeto.ead.model.Contato;
import br.com.projeto.ead.model.Pessoa;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatoDto {

    private Long id;

    private String telefone;

    private String email;

    private Pessoa pessoa;

}
