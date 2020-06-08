package br.com.projeto.ead.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "contato",indexes = @Index(name = "pk_contato_id",unique = true,columnList = "id"))
@SequenceGenerator(name = "id", sequenceName = "SEQ_CONTATO", allocationSize = 1)
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id")
    private Long id;

    @NotNull
    private String telefone;

    @NotNull
    private String email;
}
