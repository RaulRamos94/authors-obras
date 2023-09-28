import './App.css';
import {useEffect, useState} from 'react';
import Formulario from './Autores/Formulario';
import ViewAutores from './Autores/ViewAutores';


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
  
  //Alterar autor
  const atualizarAutor = () => {
    fetch("http://localhost:8080/authors/atualizarAutor",{
      method: "put",
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
        alert("Autor alterado com sucesso!")

        //Cópia Vetor de produtos
        let vetorTempo = [...autores];

        //Indice
        let indice = vetorTempo.findIndex((p) => {
        return p.idAutor === objAutor.idAutor;
        });

        //Alterar Autor do vetorTempo
        vetorTempo[indice] = objAutor;

        //Atualizar o vetor autores
        setAutores(vetorTempo);
        limparFormulario();
      }
    })
  }

  //Excluir Autor
  const excluirAutor = () => {
    fetch("http://localhost:8080/authors/excluirAutor/"+objAutor.idAutor,{
      method: "delete",
      headers:{
        "Content-type":"application/json",
        "Accept":"application/json"
      }
    })
    .then(retorno => retorno.json())
    .then(retornoConvertido =>{

      //Mensagem
      alert("Autor excluido com sucesso!")

      //Cópia Vetor de produtos
      let vetorTempo = [...autores];

      //Indice
      let indice = vetorTempo.findIndex((p) => {
        return p.idAutor === objAutor.idAutor;
      });

      //Remover Autor vetorTempo
      vetorTempo.splice(indice, 1);

      //Atualizar o vetor autores
      setAutores(vetorTempo);

      //Limpar Formulario
      limparFormulario();
    })
  }

  //Limpar Formulario
  const limparFormulario = ()=> {
    setBtnCadastrar(true);
    setObjAutor(autor);
  }
  
  //Selecionar Autor
  const selecionarAutor = (indice) => {
    setObjAutor(autores[indice]);
    setBtnCadastrar(false);
  }

  return (
    <div>
      <Formulario botao={btnCadastrarAutor} eventoTeclado={aoDigitar} cadastrarAutor={cadastrarAutor} obj={objAutor} cancelar={limparFormulario} alterar={atualizarAutor}  remover={excluirAutor}/>
      <ViewAutores vetor={autores} selecionar={selecionarAutor}/>
    </div>
  );
}

export default App;
