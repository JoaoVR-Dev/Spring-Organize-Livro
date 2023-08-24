package com.cruddelivro.spring.Controller;

import com.cruddelivro.spring.Models.Editora;
import com.cruddelivro.spring.Repository.EditoraRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class EditoraController {

    private EditoraRepository editoraRepository;

    public EditoraController(EditoraRepository editoraRepository) {
        this.editoraRepository = editoraRepository;
    }

    @GetMapping("/findeditora")
    public List<Editora> findEditora(){
        return editoraRepository.findAll();
    }
}
