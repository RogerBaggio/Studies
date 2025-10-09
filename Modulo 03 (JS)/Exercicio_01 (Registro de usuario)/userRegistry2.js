console.log("Executando JS...");
console.log("Cadastro de usuários 2.0.");

// Main Script >

const firstName = collectInfo("o primeiro nome");
const lastName = collectInfo("o ultimo nome");
const occupation = collectInfo("a ocupação");

alert("Nome: " + firstName + " " + lastName + "\nOcupação: " + occupation);

// functions

function collectInfo(infoField) {
  let msg = "Insira " + infoField + " do usuário:";
  let input = prompt(msg);

  while (Object.is(input, null) || !validateInput(input)) {
    input = prompt("POR FAVOR, INSIRA UMA INFORMAÇÃO VALIDA!\n" + msg);
  }
  return input;
}

function validateInput(text) {
  let valid = false;
  if (text.match(/^[a-zA-Z]*$/)) {
    valid = true;
  }
  return valid;
}

console.log("JS executado com sucesso.");
