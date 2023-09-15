package com.example.AuthorsObras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AuthorsObras.model.Obra;

public interface ObraRepository extends JpaRepository<Obra, Long>{
    
}
