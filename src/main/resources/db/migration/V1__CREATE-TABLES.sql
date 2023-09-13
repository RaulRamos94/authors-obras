CREATE TABLE IF NOT EXISTS tb_autores(

    idAutor BIGINT(20) NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    sexo VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL,
    dataNascimento DATE,
    nacionalidade VARCHAR(2) NOT NULL,
    cpf VARCHAR(20) NOT NULL,

    PRIMARY KEY(idAutor));

CREATE TABLE IF NOT EXISTS tb_obras(

    idObra BIGINT(20) NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(240) NOT NULL,
    dataPublicacao DATE,
    dataExposicao DATE,

    PRIMARY KEY(idObra));