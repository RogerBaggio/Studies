console.log("Executando JS...");
console.log("Caculadora Básica.");

// Main Script >

const firstValue = prompt("Qual é o primeiro número?");
const secondValue = prompt("Qual é o segundo número?");

const x = parseFloat(firstValue);
const y = parseFloat(secondValue);

const soma = x + y;
const subtracao = x - y;
const multiplicacao = x * y;
const divisao = x / y;

alert(
  "Os valores enviados foram: " +
    firstValue +
    " e " +
    secondValue +
    "," +
    "\nportanto o resultado das 4 operações básicas entre estes valores são: " +
    "\n Soma: " +
    soma +
    "." +
    "\n Subtração: " +
    subtracao +
    "." +
    "\n Multiplicação: " +
    multiplicacao +
    "." +
    "\n Divisão: " +
    divisao +
    "."
);

console.log("JS executado com sucesso.");
