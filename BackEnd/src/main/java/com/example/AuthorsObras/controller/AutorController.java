package com.example.AuthorsObras.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.AuthorsObras.model.Autor;
import com.example.AuthorsObras.repository.AutorRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/authors")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping(value = "/cadastrarAutor") //Cadastrar Autor
    public ResponseEntity<Autor> cadastrarAutor(@RequestBody Autor autor){
        return ResponseEntity.status(HttpStatus.CREATED).body(autorRepository.save(autor));
    }

    @GetMapping(value = "/listarAutores") //Listar todos os Autores
    public List<Autor> listarAutores(){
        return autorRepository.findAll();
    }

    @GetMapping("/{id}") //Listar Autor por Id
    public ResponseEntity<Autor> listarAutorPorId(@PathVariable("id") Long id){
        Optional<Autor> autor = autorRepository.findById(id);
        if(autor.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(autor.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping(value = "/atualizarAutor/{id}")//Atualizar cadastro do Autor por Id
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
    
    @DeleteMapping(value = "/excluirAutor/{id}") //Excluir autor por Id
    public ResponseEntity<String> excluirAutor(@PathVariable Long id){
        Optional<Autor> autor = autorRepository.findById(id);

        if(autor.isPresent()){
            autorRepository.deleteById(id);
            return ResponseEntity.ok().body("Autor excluído com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
               
    }
    
}
