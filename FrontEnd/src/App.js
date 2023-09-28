import './App.css';
import {useEffect, useState} from 'react';
import Autor from './Autores/CRUD/Cadastrar';
import TabelaAutores from './Autores/CRUD/TabelaAutores';

function App() {

  //Criando o objeto Autor
  const autor = {
    nome : '',
    genero : '',
    email : '',
    dataNascimento : '',
    nacionalidade : '',
    cpf : ''
  }

  //UseState
  const [btnCadastrarAutor, setBtnCadastrar] = useState(true);
  const [objAutor, setObjAutor] = useState(autor)
  const [autores, setAutores] = useState([]);

  //Cadastrar Autor
  const cadastrarAutor = () => {
    fetch("http://localhost:8080/authors/cadastrarAutor",{
      method: "post",
      body: JSON.stringify(objAutor),
      headers:{
        "Content-type":"application/json",
        "Accept":"application/json"
      }
    })
    .then(retorno => retorno.json())
    .then(retornoConvertido =>{
      if (retornoConvertido.mensagem !== undefined){
        alert(retornoConvertido.mensagem)
      }else{
        setAutores([...autores, retornoConvertido])
        alert("Autor cadastrado com sucesso!")
        limparFormulario();
      }
    })
  }

  //Listar Autores
  useEffect(() => {
    fetch("http://localhost:8080/authors/listarAutores")
    .then(listarAutores => listarAutores.json())
    .then(autoresConvertidos => setAutores(autoresConvertidos))
  }, []);

  const aoDigitar = (e) => {
    setObjAutor({...objAutor, [e.target.name]:e.target.value});
  }

  //Limpar Formulario
  const limparFormulario = ()=> {
    setObjAutor(autor);
  }
  
  const selecionarAutor = (indice) => {
    setObjAutor(autores[indice]);
    setBtnCadastrar(false);
  }




  return (
    <div>
      <Autor botao={btnCadastrarAutor} eventoTeclado={aoDigitar} cadastrarAutor={cadastrarAutor} obj={objAutor}/>
      <TabelaAutores vetor={autores} selecionar={selecionarAutor}/>
    </div>
  );
}

export default App;
