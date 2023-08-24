package com.cruddelivro.spring.Repository;
import com.cruddelivro.spring.Models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query(value = "Select L from Livro L WHERE L.livroNome LIKE %:livroNome%")
    Optional<Livro> findByNameLivro(String livroNome);

    //@Query(value = "Select L from Livro L WHERE L.nomeLivro LIKE %:nomeLivro%")
    //Optional<Livro> findByNome(String nomeLivro);
}
