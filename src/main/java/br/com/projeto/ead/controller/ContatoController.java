package br.com.projeto.ead.controller;

import br.com.projeto.ead.model.dto.ContatoDto;
import br.com.projeto.ead.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    ContatoService service;

    @GetMapping
    public Page<ContatoDto> listar(@RequestParam(required = false) String telefone,
                                     @RequestParam(required = false) String email,
                                     @PageableDefault(sort = "id")Pageable paginacao){
        return service.listar(telefone,email,paginacao);
    }
    @GetMapping("/{id}")
    public ContatoDto detalhar (@PathVariable Long id) throws Exception {
        return service.detalhar(id);
    }

    @PostMapping
    public ResponseEntity<ContatoDto> cadastrar(ContatoDto contatoDto, UriComponentsBuilder uri){
        return service.cadastrar(contatoDto,uri);
    }
}
