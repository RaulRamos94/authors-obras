import './App.css';
import {useEffect, useState} from 'react';
import Autor from './Autores/CRUD/Cadastrar';
import TabelaAutores from './Autores/CRUD/TabelaAutores';

function App() {

  //UseState
  const [btnCadastrarAutor, setBtnCadastrar] = useState(true);
  const [autores, setAutores] = useState([]);

  //UseEffect
  useEffect(() => {
    fetch("http://localhost:8080/authors/listarAutores")
    .then(listarAutores => listarAutores.json())
    .then(autoresConvertidos => setAutores(autoresConvertidos))
  }, []);

  return (
    <div>
      <Autor botao={btnCadastrarAutor}></Autor>
      <TabelaAutores vetor={autores}/>
    </div>
  );
}

export default App;
