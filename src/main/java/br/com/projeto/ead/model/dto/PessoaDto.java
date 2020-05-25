package br.com.projeto.ead.model.dto;

import br.com.projeto.ead.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDto {

    private Long id;

    private String nome;

    private Calendar nascimento;

    public PessoaDto(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.nascimento = pessoa.getNascimento();
    }

    public static Page<PessoaDto> covert(Page<Pessoa> pessoas) {
        return pessoas.map(PessoaDto::new);
    }
}
