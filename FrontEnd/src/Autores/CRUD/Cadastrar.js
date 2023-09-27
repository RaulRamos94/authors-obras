function CadastrarAutor({botao}) {
    return(
        <form>
            <input type="text" placeholder="Nome" className="form-control"/>
            <input type="text" placeholder="Genero" className="form-control"/>
            <input type="text" placeholder="E-mail" className="form-control"/>
            <input type="date" placeholder="Data De Nascimento" className="form-control"/>
            <input type="text" placeholder="CPF" className="form-control"/>
            <input type="text" placeholder="Nacionalidade" className="form-control"/>

            {
                botao ? <input type="button" value="Cadastrar" className="btn btn-primary"/> : 
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