package br.com.projeto.ead.model.dto;

import br.com.projeto.ead.model.Contato;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContatoDto {

    private Long id;
    private String telefone;
    private String email;

}
