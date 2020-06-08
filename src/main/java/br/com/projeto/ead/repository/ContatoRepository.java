package br.com.projeto.ead.repository;

import br.com.projeto.ead.model.Contato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato,Long> {
    Page<Contato> findByEmail(String email,Pageable paginacao);
    Page<Contato> findByTelefone(String telefone,Pageable paginacao);
}
