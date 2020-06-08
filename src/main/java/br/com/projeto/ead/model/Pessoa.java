package br.com.projeto.ead.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Table(name = "pessoa",indexes = @Index(name = "pk_pessoa_id",unique = true,columnList = "id"))
@SequenceGenerator(name = "id", sequenceName = "SEQ_PESSOA", allocationSize = 1)
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
    private Long id;

    @NotNull(message = "Campo obrigatorio")
    private String nome;

    @NotNull(message = "Campo obrigatorio")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Calendar nascimento;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pessoa",fetch = FetchType.EAGER)
    @JsonManagedReference(value = "pessoa-contato")
    private List<Contato> contatos;

}
