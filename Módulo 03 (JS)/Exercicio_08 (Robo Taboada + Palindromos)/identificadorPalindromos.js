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

  let reverseString = input.split("");
  console.log("reverseString after split(): " + reverseString);

  reverseString.reverse();

  console.log("reverseString after reverse(): " + reverseString);

  reverseString.toString().replace(",", "");

  console.log("reverseString after toString(): " + reverseString);
}

console.log("JS executado com sucesso.");
