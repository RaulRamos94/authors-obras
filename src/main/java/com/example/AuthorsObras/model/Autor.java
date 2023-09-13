package com.example.AuthorsObras.model;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.example.AuthorsObras.constraints.Genero;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //Gerador de Getters e Setters
@NoArgsConstructor //Cria o construtor vazio
@AllArgsConstructor //Cria o construtor preenchido
@Entity //Define a classe como uma entidade
@Table(name = "tb_autores") //Define o nome da tabela no BD
public class Autor {
    
    @Id //Define o atributo mapeado como id da classe
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gerador de id
    private Long idAutor;

    @Column(nullable = false, length = 50) //Define que esse atributo é obrigatorio e que será uma coluna na tabela com no maximo 50 caracteres. 
    private String nome;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING) //O valor do Enum será convertido para String
    private Genero genero;
    
    @Email(message = "Email não é válido", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$") //Email não obrigatorio, regex para verificacao de email valido
    @Column(unique = true) //Define que o email é unico
    private String email;

    @Column(nullable = false) //Preenchimento obrigatorio
    @JsonFormat(pattern = "dd/MM/yyyy") //Formato de digitacao aceito
    private LocalDate dataNascimento;
    
    //Regex para definir opcões de paises validas
    @Pattern(regexp = "^(AF|AX|AL|DZ|AS|AD|AO|AI|AQ|AG|AR|AM|AW|AU|AT|AZ|BS|BH|BD|BB|BY|BE|BZ|BJ|BM|BT|BO|BQ|BA|BW|BV|BR|IO|BN|BG|BF|BI|KH|CM|CA|CV|KY|CF|TD|CL|CN|CX|CC|CO|KM|CG|CD|CK|CR|CI|HR|CU|CW|CY|CZ|DK|DJ|DM|DO|EC|EG|SV|GQ|ER|EE|ET|FK|FO|FJ|FI|FR|GF|PF|TF|GA|GM|GE|DE|GH|GI|GR|GL|GD|GP|GU|GT|GG|GN|GW|GY|HT|HM|VA|HN|HK|HU|IS|IN|ID|IR|IQ|IE|IM|IL|IT|JM|JP|JE|JO|KZ|KE|KI|KP|KR|KW|KG|LA|LV|LB|LS|LR|LY|LI|LT|LU|MO|MK|MG|MW|MY|MV|ML|MT|MH|MQ|MR|MU|YT|MX|FM|MD|MC|MN|ME|MS|MA|MZ|MM|NA|NR|NP|NL|NC|NZ|NI|NE|NG|NU|NF|MP|NO|OM|PK|PW|PS|PA|PG|PY|PE|PH|PN|PL|PT|PR|QA|RE|RO|RU|RW|BL|SH|KN|LC|MF|PM|VC|WS|SM|ST|SA|SN|RS|SC|SL|SG|SX|SK|SI|SB|SO|ZA|GS|SS|ES|LK|SD|SR|SJ|SZ|SE|CH|SY|TW|TJ|TZ|TH|TL|TG|TK|TO|TT|TN|TR|TM|TC|TV|UG|UA|AE|GB|US|UM|UY|UZ|VU|VE|VN|VG|VI|WF|EH|YE|ZM|ZW)$", message= "País invalido")
    @Column(nullable = false) //Preenchimento obrigatorio
    private String nacionalidade;

    @CPF(message = "CPF inválido")
    @Column(unique = true)
    private String cpf;

    @ManyToMany
    @JoinTable(name = "autores_obras", joinColumns = {@JoinColumn(name = "idAutor")}, inverseJoinColumns = {@JoinColumn(name = "idObra")})
    private List<Obra> obras; 

}
