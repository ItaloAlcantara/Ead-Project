package br.com.projeto.ead.repository;

import br.com.projeto.ead.model.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository <Classe,Long> {
}
