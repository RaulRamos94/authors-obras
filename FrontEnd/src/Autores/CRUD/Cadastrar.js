function CadastrarAutor({botao, eventoTeclado, cadastrarAutor}) {
    return(
        <form>
            <input type="text" onChange={eventoTeclado} name="nome"  placeholder="Nome" className="form-control"/>
            <input type="text" onChange={eventoTeclado} name="genero" placeholder="Genero" className="form-control"/>
            <input type="text" onChange={eventoTeclado} name="email" placeholder="E-mail" className="form-control"/>
            <input type="text" onChange={eventoTeclado} name="dataNascimento" placeholder="Data De Nascimento" className="form-control"/>
            <input type="text" onChange={eventoTeclado} name="cpf" placeholder="CPF" className="form-control"/>
            <input type="text" onChange={eventoTeclado} name="nacionalidade" placeholder="Nacionalidade" className="form-control"/>

            {
                botao ? <input type="button" value="Cadastrar" onClick={cadastrarAutor} className="btn btn-primary"/> : 
                <div>
                    <input type="button" value="Listar" className="btn btn-secondary"/>
                    <input type="button" value="Alterar" className="btn btn-warning"/>
                    <input type="button" value="Remover" className="btn btn-danger"/>
                    <input type="button" value="Cancelar" className="btn btn-secondary"/>
                </div>
            } 
        </form>
    )
}

export default CadastrarAutor;