package com.cruddelivro.spring.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "autor")
public class Autor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long autorId;

    @Column(name = "AutorNome", nullable = false)
    private String autorNome;

    @Column(name = "AutorNascimento")
    private Date autorNascimento;

    public Autor(){}

    public Autor(Long autorId, String autorNome, Date autorNascimento){
        this.autorId = autorId;
        this.autorNome = autorNome;
        this.autorNascimento = autorNascimento;
    }


    public String getAutorNome() {
        return autorNome;
    }

    public void setAutorNome(String autorNome) {
        this.autorNome = autorNome;
    }

    public Date getAutorNascimento() {
        return autorNascimento;
    }

    public void setAutorNascimento(Date autorNascimento) {
        this.autorNascimento = autorNascimento;
    }
}
