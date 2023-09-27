function TabelaAutores({vetor}) {

    return(
       <table className="table">
        <thead>
            <tr>
                
                <th>idAutor</th>
                <th>Nome</th>
                <th>Genero</th>
                <th>E-mail</th>
                <th>Data de Nascimento</th>
                <th>Nacionalidade</th>
                <th>CPF</th>
                
            </tr>
        </thead>

        <tbody>{
                vetor.map((obj) => (
                    <tr>
                        <td>{obj.idAutor}</td>
                        <td>{obj.nome}</td>
                        <td>{obj.genero}</td>
                        <td>{obj.email}</td>
                        <td>{obj.dataNascimento}</td>
                        <td>{obj.nacionalidade}</td>
                        <td>{obj.cpf}</td>
                        <td><button className="btn btn-success">Selecionar</button></td>
                    </tr>
                    ))
                }
        </tbody>

       </table> 

    )
    
}

export default TabelaAutores;