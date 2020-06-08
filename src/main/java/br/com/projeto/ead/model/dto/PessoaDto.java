package br.com.projeto.ead.model.dto;

import br.com.projeto.ead.model.Contato;
import br.com.projeto.ead.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.Calendar;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDto {

    private Long id;

    private String nome;

    private Calendar nascimento;

    private List<Contato> contatos;

}
