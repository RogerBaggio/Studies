console.log("Executando JS...");
console.log("Cadastro de usuários.");

// Main Script >

const nome = prompt("Nome do usuário");
const sobrenome = prompt("Sobrenome do usuário");
const atuacao = prompt("Área de atuação do usuário");
const anoNasc = prompt("Ano de nascimento:");
const anoAtual = new Date().getFullYear();

const idade = parseFloat(anoAtual) - parseFloat(anoNasc);

alert(
  "Usuário cadastrado com sucesso!\n" +
    "\nNome do usuário: " +
    nome +
    " " +
    sobrenome +
    "\nÁrea de atuação do usuário: " +
    atuacao +
    "\nIdade do usuário: " +
    idade
);

console.log("JS executado com sucesso.");
