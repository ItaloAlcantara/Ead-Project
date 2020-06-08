package br.com.projeto.ead.controller;

import br.com.projeto.ead.model.dto.ContatoDto;
import br.com.projeto.ead.model.dto.PessoaDto;
import br.com.projeto.ead.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public Page<PessoaDto> listar (@RequestParam(required = false) String nome,  @PageableDefault(sort = "nome") Pageable paginacao){
        return service.lista(nome,paginacao);
    }

    @GetMapping("/{id}")
    public PessoaDto detalhar(@PathVariable Long id) throws Exception {   return service.detalhar(id); }

    @PostMapping
    public ResponseEntity<PessoaDto> cadastrar(@RequestBody @Valid PessoaDto pessoaDto,UriComponentsBuilder uri){
        return service.cadastrar(pessoaDto,uri);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaDto> atualizar (@RequestBody PessoaDto pessoaDto, @PathVariable Long id) throws Exception {
        return service.atualizar(pessoaDto,id); }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar (@PathVariable Long id) throws Exception { return service.deletar(id);}

}
