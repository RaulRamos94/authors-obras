package com.example.AuthorsObras.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AuthorsObras.model.Obra;
import com.example.AuthorsObras.repository.ObraRepository;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/obras")
public class ObraController {

    @Autowired
    private ObraRepository obraRepository;

    @PostMapping //Cadastrar Obra
    public ResponseEntity<Obra> cadastrarObra(@RequestBody Obra obra){
        return ResponseEntity.status(HttpStatus.CREATED).body(obraRepository.save(obra));
    }

    @GetMapping //Listar todas as Obras
    public ResponseEntity<Page<Obra>> listarObraes(Pageable paginacao){
        return ResponseEntity.status(HttpStatus.OK).body(obraRepository.findAll(paginacao));
    }

    @GetMapping("/{id}") //Listar Obra por Id
    public ResponseEntity<Obra> listarObraPorId(@PathVariable("id") Long id){
        Optional<Obra> obra = obraRepository.findById(id);
        if(obra.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(obra.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}") //Atualizar cadastro da Obra por Id
    public ResponseEntity<Obra> atualizarObra(@PathVariable("id") Long id, @RequestBody Obra obra){
        Optional<Obra> obraExistente = obraRepository.findById(id);

        if(obraExistente.isPresent()){
            obraExistente.get().setNome(obra.getNome());
            obraExistente.get().setDescricao(obra.getDescricao());
            obraExistente.get().setDataPublicacao(obra.getDataPublicacao());
            obraExistente.get().setDataExposicao(obra.getDataExposicao());
            obraExistente.get().setAutores(obra.getAutores());            

            return ResponseEntity.status(HttpStatus.OK).body(obraRepository.save(obraExistente.get()));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @DeleteMapping("/{id}") //Excluir Obra por Id
    public ResponseEntity<String> excluirObra(@PathVariable Long id){
        Optional<Obra> obra = obraRepository.findById(id);

        if(obra.isPresent()){
            obraRepository.deleteById(id);
            return ResponseEntity.ok().body("Obra excluída com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
               
    }
    
}
