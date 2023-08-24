package com.cruddelivro.spring.Models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

//import java.io.Serializable;


@Entity
@Table(name = "livro")
public class Livro implements Serializable {
    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long livroId;
    @Column(name = "livroNome", nullable = false)
    private String livroNome;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Autor livroAutor;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Editora livroEditora;

    @Column(name = "livroLancamento")
    private Date livroLancamento;

    public Livro(){}

    public Livro(Long livroId, String livroNome, Autor livroAutor, Editora livroEditora, Date livroLancamento) {
        this.livroId = livroId;
        this.livroNome = livroNome;
        this.livroAutor = livroAutor;
        this.livroEditora = livroEditora;
        this.livroLancamento = livroLancamento;
    }

    public String getLivroNome() {
        return livroNome;
    }

    public void setLivroNome(String livroNome) {
        this.livroNome = livroNome;
    }

    public Autor getLivroAutor() {
        return livroAutor;
    }

    public void setLivroAutor(Autor livroAutor) {
        this.livroAutor = livroAutor;
    }

    public Editora getLivroEditora() {
        return livroEditora;
    }

    public void setLivroEditora(Editora livroEditora) {
        this.livroEditora = livroEditora;
    }

    public Date getLivroLancamento() {
        return livroLancamento;
    }

    public void setLivroLancamento(Date livroLancamento) {
        this.livroLancamento = livroLancamento;
    }
}
