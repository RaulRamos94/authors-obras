const formulario = document.querySelector("form")
const inome = document.querySelector(".nome")
const icpf = document.querySelector(".cpf")
const igenero = document.querySelector(".genero")
const iemail = document.querySelector(".email")
const idataNascimento = document.querySelector(".dataNascimento")
const inacionalidae = document.querySelector(".nacionalidae")
const buttonCadastrarAutor = document.querySelector("buttonCadastrarAutor")

function cadastrarAutor(){
    fetch("http://localhost:8080/authors",
    {
        headers:{
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        method: "POST",
        body: JSON.stringify({
            nome: inome.value,
            cpf: icpf.value,
            genero: igenero.value,
            email: iemail.value,
            dataNascimento: idataNascimento.value,
            nacionalidade: inacionalidae.value
        })
    })
};

function limparForm(){
    inome.value = "",
    icpf.value = "",
    igenero.value = "",
    iemail.value = "",
    idataNascimento.value = "",
    inacionalidae.value = "";
}

formulario.addEventListener("submit", function (event){
    event.preventDefault();
    cadastrarAutor();
});


