console.log("Executando JS...");
console.log("Identificador de Palindromos.");

// Main Script>
alert(
  "Bem vindo ao Identificador de Palíndromos!\n\n" +
    "Primeiramente, que é um palíndromo?\nÉ toda palavra ou frase que pode ser lida de trás pra frente e que, independente da direção, mantém o seu sentido."
);

var input;
var reverseInput;

while (checkIfProceed()) {
  input = prompt("Qual seria a palavra ou frase que deseja conferir se é um palindromo?");

  if (Object.is(input, null)) {
    break;
  }

  reverseInput = generateReverseInput(input);

  if (checkIfPalindrome(input)){
    alert("SIM! É isso ai!\nO texto inserido é um palíndromo! :D\n\nConfira:\n"+
    "Texto inserido: "+input+"\n"+
    "Texto invertido: "+reverseInput+"\n"
    );
  } else {
    alert("NÃO. Ah, que pena...\nO texto inserido é não um palíndromo. ;|\n\nConfira:\n"+
    "Texto inserido: "+input+"\n"+
    "Texto invertido: "+reverseInput+"\n"
    );
  }
}

alert("Ok, bye.\n\nAté a próxima!");

// Functions >

function checkIfProceed() {
  let prcd = confirm(
    "Deseja continuar e verificar se uma palavra ou frase é um palíndromo?"
  );
  return prcd;
}

function generateReverseInput(input) {
  let splitedInput = Object.values(input.split(""));
  splitedInput.reverse();

  let reverseInput = "";

  for (let i = 0; i < splitedInput.length; i++) {
    reverseInput += splitedInput[i];
  }
  return reverseInput;
}

function checkIfPalindrome(input){
  let result = false;
  
  let cleanInput = generateCleanInput(input);
  let reverseCleanInput = generateReverseInput(cleanInput);

  if(cleanInput == reverseCleanInput){
    result = true;
  }
  return result;
}

function generateCleanInput(text){
  let clnInpt = text.toLowerCase();
  
  clnInpt = clnInpt.replace(/[\s.,\/#!$%\^&\*;:{}=\-_`~()]/g,"");
  clnInpt = clnInpt.normalize("NFD");
  clnInpt = clnInpt.replace(/\p{Diacritic}/gu, "");

  return clnInpt;
}

console.log("JS executado com sucesso."); 
