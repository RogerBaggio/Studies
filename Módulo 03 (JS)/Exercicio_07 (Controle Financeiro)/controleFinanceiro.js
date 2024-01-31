console.log("Executando JS...");

// Main Script>

const inputExp = /^[1-3]+$/;
var balance = "0.00";
var operation;
var operationValue;

alert(
  "Bem vindo ao Controle Financeiro!\n\n" +
    "Insira um valor inicial em sua carteira e controle o saldo adicionando e subtraindo valores de acordo com as opções no menu a seguir."
);

balance = retrieveValue("start");

if (!Object.is(balance, null)) {
  //TODO:Exercicio com uso de DO WHILE.
  do {
    operation = selectOperation(balance);

    if (Object.is(operation, null)) {
      break;
    }

    if (isOperation(operation)) {
      operationValue = retrieveValue(operation);

      if (!Object.is(operationValue, null)) {
        balance = executeOperation(balance, operation, operationValue);
      }
    }
  } while (operation !== "3");
}

alert("Já vai? Ok.\n\nAté a próxima então!");

// Functions >

function retrieveValue(action) {
  let msg = createMessage(action);
  let value = prompt(msg);

  if (Object.is(value, null)) {
    return value;
  }

  while (!value.trim() || isNaN(value.replace(",", "."))) {
    value = prompt("ATENÇÃO,\nutilize apenas saldos numéricos!\n\n" + msg);
    if (Object.is(value, null)) {
      return value;
    }
  }
  return parseFloat(value.replace(",", ".")).toFixed(2);
}

function createMessage(action) {
  if (action == "start") {
    return (
      "Seu saldo atual: " +
      balance +
      "\n\nInsira o valor inicial de sua carteira:"
    );
  }
  return (
    "Seu saldo atual: " +
    balance +
    "\n\nQual valor deseja " +
    (action == "1" ? "ADICIONAR" : "SUBTRAIR") +
    " de sua carteira?"
  );
}

function selectOperation(blnc) {
  let msg =
    "Seu saldo atual: " +
    blnc +
    "\n\nSelecione a operação que deseja realizar em seu saldo:" +
    "\n 1 - Adicionar valor." +
    "\n 2 - Subtrair valor." +
    "\n 3 - Sair.";

  let oprt = prompt(msg);

  if (Object.is(oprt, null)) {
    return oprt;
  }

  while (!oprt.match(inputExp)) {
    oprt = prompt("OPÇÃO INSERIDA É INVALIDA.\n" + msg);
    if (Object.is(oprt, null)) {
      return oprt;
    }
  }
  return oprt;
}

function isOperation(oprt) {
  return oprt == "1" || oprt == "2" ? true : false;
}

function executeOperation(blnc, oprt, oprtVal) {
  //TODO:Exercicio com uso de SWITCH CASE.
  let newBlnc;

  switch (oprt) {
    case "1":
      newBlnc = Number(blnc) + Number(oprtVal);
      break;
    case "2":
      newBlnc = Number(blnc) - Number(oprtVal);
      break;
  }
  return parseFloat(newBlnc).toFixed(2);
}

console.log("JS executado com sucesso.");
