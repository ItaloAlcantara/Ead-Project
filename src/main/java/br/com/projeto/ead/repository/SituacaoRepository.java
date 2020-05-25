package br.com.projeto.ead.repository;

import br.com.projeto.ead.model.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituacaoRepository extends JpaRepository <Situacao,Long> {
}
