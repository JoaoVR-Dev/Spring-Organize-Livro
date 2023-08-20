package com.cruddelivro.spring.Repository;
import com.cruddelivro.spring.Models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LivroRepository extends JpaRepository<Livro, UUID> {
    @Query(value = "Select L from Livro L WHERE L.nomeAutor LIKE %:nomeAutor%")
    List<Livro> findByAutor(String nomeAutor);

    @Query(value = "Select L from Livro L WHERE L.nomeLivro LIKE %:nomeLivro%")
    Optional<Livro> findByNome(String nomeLivro);
}
