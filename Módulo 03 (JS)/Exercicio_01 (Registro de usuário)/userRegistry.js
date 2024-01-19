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

/*function age(birthdate) {
  const today = new Date();
  const age = today.getFullYear() - birthdate.getFullYear() - 
             (today.getMonth() < birthdate.getMonth() || 
             (today.getMonth() === birthdate.getMonth() && today.getDate() < birthdate.getDate()));
  return age;
}*/
