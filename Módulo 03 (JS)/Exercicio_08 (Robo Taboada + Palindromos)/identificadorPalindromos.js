console.log("Executando JS...");
console.log("Identificador de Palindromos.");

// Main Script>
alert(
  "Bem vindo ao Identificador de Palíndromos!\n\n" +
    "Primeiramente, que é um palíndromo?\nÉ toda palavra ou frase que pode ser lida de trás pra frente e que, independente da direção, mantém o seu sentido."
);

while (checkIfProceed()) {
  console.log("proceed = true");
  let input = prompt("Qual a palavra/frase bro?");

  if (Object.is(input, null)) {
    break;
  }

  checkIfPalindrome(input);
}

console.log("proceed = false'");
alert("Ok!\n\nAté a próxima!");

// Functions >

function checkIfProceed() {
  let prcd = confirm(
    "Deseja verificar se uma palavra ou frase é um palíndromo?"
  );
  return prcd;
}

function checkIfPalindrome(input) {
  console.log("Original string: " + input + ".");

  let splitedInput = Object.values(input.split(""));
  let reverseString;

  for (let i = 0; i < splitedInput.length; i++) {
    //TODO:Logica de inverter e recriar string invertida.
    console.log(splitedInput[i]);
  }
}

console.log("JS executado com sucesso.");
