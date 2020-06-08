package br.com.projeto.ead.service;

import br.com.projeto.ead.model.Contato;
import br.com.projeto.ead.model.dto.ContatoDto;
import br.com.projeto.ead.repository.ContatoRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;

    private DozerBeanMapper mapper;

    public Page<ContatoDto> listar (String telefone, String email, Pageable paginacao){
        if(!telefone.isEmpty()) {
            return repository.findByTelefone(telefone,paginacao).map(contato -> mapper.map(contato, ContatoDto.class));
        }
        if(!email.isEmpty()){
            return repository.findByEmail(email,paginacao).map(contato -> mapper.map(contato,ContatoDto.class));
        }
        return repository.findAll(paginacao).map(contato -> mapper.map(contato,ContatoDto.class));
    }

    public ContatoDto detalhar (Long id) throws Exception {
        return mapper.map(ifExists(id),ContatoDto.class);
    }

    public ResponseEntity<ContatoDto> cadastrar (ContatoDto contatoDto, UriComponentsBuilder builder){
        repository.save(mapper.map(contatoDto,Contato.class));

        URI uri =
                builder
                .path("/contato/{id}")
                .buildAndExpand(contatoDto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(contatoDto);
    }

    public ResponseEntity deletar(Long id) throws Exception {
        repository.delete(ifExists(id));
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<ContatoDto> atualizar (ContatoDto contatoDto,Long id) throws Exception {
        Contato contato = ifExists(id);
        mapper.map(contatoDto,contato);
        repository.save(contato);
        return ResponseEntity.ok(mapper.map(contato,ContatoDto.class));
    }


    public Contato ifExists (Long id) throws Exception {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        throw new Exception();
    }
}
