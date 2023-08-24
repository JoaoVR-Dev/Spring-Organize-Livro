package com.cruddelivro.spring.Repository;

import com.cruddelivro.spring.Models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query(value = "Select A from autor A WHERE A.autorNome LIKE %:autorNome%")
    Optional<Autor> findNameAutor(String autorNome);
}
