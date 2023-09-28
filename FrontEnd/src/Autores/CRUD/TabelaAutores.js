function TabelaAutores({vetor, selecionar}) {

    return(
       <table className="table">
        <thead>
            <tr>
                <th>idAutor</th>
                <th>Nome</th>
                <th>Genero</th>
                <th>E-mail</th>
                <th>Data de Nascimento</th>
                <th>CPF</th>
                <th>Nacionalidade</th>
            </tr>
        </thead>

        <tbody>{
                vetor.map((obj, indice) => (
                    <tr key={indice}>
                        <td>{obj.idAutor}</td>
                        <td>{obj.nome}</td>
                        <td>{obj.genero}</td>
                        <td>{obj.email}</td>
                        <td>{obj.dataNascimento}</td>
                        <td>{obj.cpf}</td>
                        <td>{obj.nacionalidade}</td>
                        <td><button onClick={() => {selecionar(indice)}} className="btn btn-success">Selecionar</button></td>
                    </tr>
                    ))
                }
        </tbody>

       </table> 

    )
    
}

export default TabelaAutores;