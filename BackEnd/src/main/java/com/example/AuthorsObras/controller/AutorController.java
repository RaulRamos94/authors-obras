package com.example.AuthorsObras.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AuthorsObras.model.Autor;
import com.example.AuthorsObras.repository.AutorRepository;


@RestController
@RequestMapping(value = "/authors")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping //Cadastrar Autor
    public ResponseEntity<Autor> cadastrarAutor(@RequestBody Autor autor){
        return ResponseEntity.status(HttpStatus.CREATED).body(autorRepository.save(autor));
    }

    @GetMapping //Listar todos os Autores
    public ResponseEntity<Page<Autor>> listarAutores(Pageable paginacao){
        return ResponseEntity.status(HttpStatus.OK).body(autorRepository.findAll(paginacao));
    }

    @GetMapping("/{id}") //Listar Autor por Id
    public ResponseEntity<Autor> listarAutorPorId(@PathVariable("id") Long id){
        Optional<Autor> autor = autorRepository.findById(id);
        if(autor.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(autor.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}") //Atualizar cadastro do Autor por Id
    public ResponseEntity<Autor> atualizarAutor(@PathVariable("id") Long id, @RequestBody Autor autor){
        Optional<Autor> autorExistente = autorRepository.findById(id);

        if(autorExistente.isPresent()){
            autorExistente.get().setNome(autor.getNome());
            autorExistente.get().setGenero(autor.getGenero());
            autorExistente.get().setEmail(autor.getEmail());
            autorExistente.get().setDataNascimento(autor.getDataNascimento());
            autorExistente.get().setNacionalidade(autor.getNacionalidade());
            autorExistente.get().setCpf(autor.getCpf());
            autorExistente.get().setObras(autor.getObras());

            return ResponseEntity.status(HttpStatus.OK).body(autorRepository.save(autorExistente.get()));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @DeleteMapping("/{id}") //Excluir Autor por Id
    public ResponseEntity<String> excluirAutor(@PathVariable Long id){
        Optional<Autor> autor = autorRepository.findById(id);

        if(autor.isPresent()){
            autorRepository.deleteById(id);
            return ResponseEntity.ok().body("Autor excluído com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
               
    }
    
}
