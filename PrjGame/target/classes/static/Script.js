document.getElementById('cadastroForm').addEventListener('submit', cadastrarJogo)
function cadastrarJogo(event){
    event.preventDefault();
const name = document.getElementById('name').value;
const plataforma = document.getElementById('plataforma').value;
 fetch('http://localhost:8080/jogo', {
    method:'POST',
    headers: {
        'Content-Type':'application/json',
    },
    body: JSON.stringify({ name, plataforma }),
 })
 .then(Response=> Response.json())
 .then(data => {
    alert('Jogo cadastrado com sucesso !! :)');
    document.getElementById('cadastroForm').reset();
   
 })
 .catch(error=>{
    console.error('Erro ao cadastrar jogo',error);
 });

}
function pesquisarJogo(){
    const searchId = document.getElementById('searchId').value;
    fetch(`http://localhost:8080/jogo/${searchId}`)
    .then(response =>{
        if(response.status === 404){
            return Promise.reject('Jogo não encontrado. :( ');
        }
        return response.json();
    })
    .then(data =>{
        const resultadoPesquisa = document.getElementById('resultadoPesquisa');
        resultadoPesquisa.innerHTML = `
        <h3>ID: ${data.id}</h3>
        <p>Nome: ${data.name}</p>
        <p>Plataforma: ${data.plataforma}</p>
        `;
    })
    .catch(error =>{
        console.error('Erro ao pesquisar jogo', error);
        const resultadoPesquisa = document.getElementById('resultadoPesquisa');
        resultadoPesquisa.innerHTML= 'Jogo não encontrado.';
    });
}

