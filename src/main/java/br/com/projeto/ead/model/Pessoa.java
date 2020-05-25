package br.com.projeto.ead.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Campo obrigatorio")
    private String nome;

    @NotNull(message = "Campo obrigatorio")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Calendar nascimento;

    public Pessoa(String nome,Calendar nascimento, Long id) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.id= id;
    }
}
