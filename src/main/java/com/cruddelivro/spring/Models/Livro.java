package com.cruddelivro.spring.Models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

//import java.io.Serializable;


@Entity
@Table(name = "livro")
public class Livro implements Serializable {
    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID livroId;
    @Column(name = "nomeLivro",nullable = false)
    private String nomeLivro;
    @Column(name = "nomeAutor", nullable = false)
    private String nomeAutor;

    public Livro() {

    }
    public Livro(UUID livroId, String nomeLivro, String nomeAutor) {
        this.livroId = livroId;
        this.nomeLivro = nomeLivro;
        this.nomeAutor = nomeAutor;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public UUID getLivroId() {
        return livroId;
    }

    public void setLivroId(UUID livroId) {
        this.livroId = livroId;
    }



}
