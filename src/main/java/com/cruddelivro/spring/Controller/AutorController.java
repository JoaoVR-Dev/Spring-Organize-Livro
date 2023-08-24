package com.cruddelivro.spring.Controller;

import com.cruddelivro.spring.Models.Autor;
import com.cruddelivro.spring.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.EscapedErrors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class AutorController {
    @Autowired
    private AutorRepository autorRepository;


    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }
    @GetMapping("/findallautor")
    public List<Autor> findAutor(){
        return autorRepository.findAll();
    }

    @GetMapping("/findautorbyname")
    public Optional<Autor> findAutorName(@RequestParam String autorNome){
    return autorRepository.findNameAutor(autorNome);
    }

    @PostMapping("/createautor")
    public Autor insertAutor(@RequestBody Autor autor){
        Autor autorSave = autorRepository.save(autor);
        return autorSave;
    }
    @DeleteMapping("/deleteautor")
    public Autor deleteAutor(@RequestParam Long autorId){
        Optional<Autor> autor = autorRepository.findById(autorId);
        autorRepository.delete(autor.get());
        return autor.get();
    }

    @PutMapping("/updateautor")
    public ResponseEntity<String> editAutor(@RequestParam Long autorId, @RequestParam String autorNome){
        Optional<Autor> autores = autorRepository.findById(autorId);
        if(autores.isPresent()){
            Autor autor = autores.get();
            autor.setAutorNome(autorNome);
            autorRepository.save(autor);
            return ResponseEntity.ok("Autor Editado!!");
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
