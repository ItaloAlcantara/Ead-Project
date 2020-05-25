package br.com.projeto.ead.service;

import br.com.projeto.ead.model.Pessoa;
import br.com.projeto.ead.model.dto.PessoaDto;
import br.com.projeto.ead.repository.PessoaRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private DozerBeanMapper mapper;

    public Page<PessoaDto> lista (@RequestParam(required = false) String nome, @PageableDefault (sort = "nome") Pageable paginacao){

        if(nome.isEmpty()) {
            return  repository.findAll(paginacao).map(pessoa -> mapper.map(pessoa,PessoaDto.class));
        }else {
            Page<Pessoa> pessoas = repository.findByNome(nome);
            return  repository.findByNome(nome).map(pessoa -> mapper.map(pessoa,PessoaDto.class));
        }
    }

    public ResponseEntity<PessoaDto> cadastrar (@RequestBody @Valid PessoaDto pessoaDto, UriComponentsBuilder uriComponentsBuilder){

        Pessoa pessoa = mapper.map(pessoaDto,Pessoa.class);
        repository.save(pessoa);

        URI uri = uriComponentsBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(new PessoaDto(pessoa));
    }

    public PessoaDto detalhar(@RequestParam Long id) throws Exception {

        Pessoa pessoa = ifExist(id);
        return mapper.map(pessoa,PessoaDto.class);
    }

    public ResponseEntity deletar(@RequestParam Long id) throws Exception{
        repository.delete(ifExist(id));
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<PessoaDto> atualizar(@RequestBody PessoaDto pessoaDto, @RequestParam Long id) throws Exception {
        Pessoa pessoa = ifExist(id);
        mapper.map(pessoa,PessoaDto.class);
        repository.save(pessoa);
        return ResponseEntity.ok(new PessoaDto(pessoa));
    }


    public Pessoa ifExist(Long id) throws Exception {
        if(repository.findById(id).isPresent())
            return repository.findById(id).get();
        throw new Exception();
    }
}
