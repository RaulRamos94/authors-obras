package com.example.AuthorsObras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AuthorsObras.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{
    
}
