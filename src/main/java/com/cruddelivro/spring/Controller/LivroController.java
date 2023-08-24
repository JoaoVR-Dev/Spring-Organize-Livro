package com.cruddelivro.spring.Controller;
import com.cruddelivro.spring.Models.Livro;
import com.cruddelivro.spring.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class LivroController {

    @Autowired
    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping("/findall")
    public List<Livro> listaDeLivro() {
        return livroRepository.findAll();
    }


    @PostMapping("/createlivro")
    public Livro incluirLivro(@RequestBody Livro livro){
        Livro livroSave = livroRepository.save(livro);
        return livroSave;
    }

    @GetMapping("/findbynome")
    public Optional<Livro> listaDelivrosPorNome(@RequestParam String livroNome) {
        return livroRepository.findByNameLivro(livroNome);
    }


}