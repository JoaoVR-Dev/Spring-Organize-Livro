package com.cruddelivro.spring.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "editora")
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long editoraId;

    @Column(name = "editoraNome", nullable = false)
    private String editoraNome;

    public Editora(){}
    public Editora(Long editoraId, String editoraNome) {
        this.editoraId = editoraId;
        this.editoraNome = editoraNome;
    }

    public String getEditoraNome() {
        return editoraNome;
    }

    public void setEditoraNome(String editoraNome) {
        this.editoraNome = editoraNome;
    }
}
