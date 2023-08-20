package com.cruddelivro.spring.dtos;
import jakarta.validation.constraints.NotBlank;
public record LivrosRecordsDto(@NotBlank String nomeLivro,@NotBlank String nomeAutor) {

}
