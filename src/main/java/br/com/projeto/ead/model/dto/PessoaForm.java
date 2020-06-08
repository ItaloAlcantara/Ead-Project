package br.com.projeto.ead.model.dto;

import br.com.projeto.ead.model.Pessoa;
import lombok.*;

import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PessoaForm {

    private String nome;
    private Calendar nascimento;


}
