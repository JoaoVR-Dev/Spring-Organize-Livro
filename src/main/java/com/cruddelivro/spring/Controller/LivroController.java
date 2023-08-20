package com.cruddelivro.spring.Controller;


import ch.qos.logback.core.joran.conditional.ElseAction;
import com.cruddelivro.spring.Models.Livro;
import com.cruddelivro.spring.Repository.LivroRepository;
import com.cruddelivro.spring.dtos.LivrosRecordsDto;
import jakarta.validation.Valid;
import org.apache.catalina.startup.ListenerCreateRule;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LivroController {

    @Autowired
    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<Livro> saveLivro(@RequestBody @Valid LivrosRecordsDto livrosRecordsDto) {
        Livro livro = new Livro();
        BeanUtils.copyProperties(livrosRecordsDto, livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroRepository.save(livro));
    }

    @GetMapping("/find")
    public List<Livro> listaDeLivro() {
        return livroRepository.findAll();
    }

    @GetMapping("/findbyautor")
    public List<Livro> listaDelivro(@RequestParam String nomeAutor) {
        return livroRepository.findByAutor(nomeAutor);
    }

    @GetMapping("/findbynome")
    public Optional<Livro> listaDelivros(@RequestParam String nomeLivro) {
        return livroRepository.findByNome(nomeLivro);
    }

    @PutMapping("/updateautor")
    public ResponseEntity<String> atualizarAutorLivro(
            @RequestParam String nomeLivro,
            @RequestParam String nomeAutor
    ) {
        Optional<Livro> livroOptional = livroRepository.findByNome(nomeLivro);
        if (livroOptional.isPresent()) {
            Livro livro = livroOptional.get();
            System.out.println("Pegou" + livro);
            livro.setNomeAutor(nomeAutor);
            livroRepository.save(livro);
            return ResponseEntity.ok("Nome do Autor Alterado com Sucesso!!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletelivro")
    public ResponseEntity<String> deletelivro(
            @RequestParam String nomeLivro
    ){
        Optional<Livro> livroOptional = livroRepository.findByNome(nomeLivro);
        if(livroOptional.isPresent()){
            Livro livro = livroOptional.get();
            livroRepository.delete(livro);
            return ResponseEntity.ok("Livro Excluido!!");
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
