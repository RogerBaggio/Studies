console.log("Executando JS...");
console.log("Página Robo da Taboada.");

// Main Script>

alert(
  'Bem vindo ao "Robô Taboada 1 a 20"!\n\n' +
    "Insira um número de 1 a 20 no prompt seguinte e clique em OK para ver o resultado das multiplicações deste número por 1 até 20."
);

const inputExp = /^[1-9]$|^0[1-9]$|^1[0-9]$|^20$/;
const msg = "Qual valor deseja multiplicar por 1 até 20?";
var value;
var proceed;

do {
  value = retrieveInputNumber();

  if (Object.is(value, null)) {
    break;
  }

  alert(calcMultiplication(value));

  proceed = confirm("Deseja realizar a taboada de mais algum número?");
} while (proceed);

alert("Ok!\n\nAté a próxima!");

// Functions >

function retrieveInputNumber() {
  let val = prompt(msg);

  if (Object.is(val, null)) {
    return val;
  }

  while (!val.match(inputExp)) {
    val = prompt(
      "O VALOR INSERIDO É INVALIDO.\nUtilize apenas valores de 1 a 20.\n\n" +
        msg
    );
    if (Object.is(val, null)) {
      return val;
    }
  }
  return val;
}

function calcMultiplication(val) {
  let msg =
    "Os resultados das multiplicações de " + val + " por 1 até 20 são:\n";

  for (let i = 1; i <= 20; i++) {
    let result = val + " x " + i + " = " + val * i + ".\n";
    msg += result;
  }
  return msg;
}

console.log("JS executado com sucesso.");
