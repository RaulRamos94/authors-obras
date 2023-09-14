package com.example.AuthorsObras.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.AuthorsObras.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

    // @Query("SELECT COUNT(cpf) FROM Autor WHERE cpf = :cpf")
    // Optional<Autor> cpfCadastrado(Autor cpf);

}
