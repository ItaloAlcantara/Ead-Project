package br.com.projeto.ead.repository;

import br.com.projeto.ead.model.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituicaoReepository extends JpaRepository<Instituicao,Long> {
}
