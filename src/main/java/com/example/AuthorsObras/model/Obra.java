package com.example.AuthorsObras.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Gerador de Getters e Setters
@NoArgsConstructor //Cria o construtor vazio
@AllArgsConstructor //Cria o construtor preenchido
@Entity //Define a classe como uma entidade
@Table(name = "tb_obras") //Defini o nome da tabela no BD
public class Obra {
    
    @Id //Define o atributo mapeado como id da classe
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gerador de id
    private Long idObra;

    @Column(nullable = false) //Define que esse atributo é obrigatorio e que será uma coluna na tabela com no maximo 50 caracteres. 
    private String nome;

    @Column(nullable = false, length = 240) //Define que esse atributo é obrigatorio e que será uma coluna na tabela com no maximo 240 caracteres. 
    private String descricao;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy") //Formato de digitacao aceito
    private LocalDate dataPublicacao;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy") //Formato de digitacao aceito
    private LocalDate dataExposicao;

    @ManyToMany(mappedBy = "obras")
    private List<Autor> autores; 

}
