console.log("Executando JS...");
console.log("Fila de Espera.");

// Main Script >
alert(
  "Bem vindo ao exercício Fila de Espera em JS!\n\n" +
    "Adicione aqui os nomes dos pacientes em ordem de chegada.\n\n" +
    "No menu, você poderá escolher entre adicionar um paciente, atender o próximo paciente da fila ou exibir a lista de atendimentos pendentes."
);

const inputExp = /^[1-4]+$/;
var patientList = [];
var option;

do {
  option = principalMenu();

  if (option == "1") {
    alert("Opção escolhida é 1");
    addPatient();
    //TODO: 1 Adicionar paciente - checar se prompt vazio. Cancel volta para menu. (.push)
  } else if (option == "2") {
    alert("Opção escolhida é 2");
    //TODO: 2 Atender paciente - exibir mensagem e nome. Se lista vazia, voltar para menu. (.pop)
  } else if (option == "3") {
    alert("Opção escolhida é 3");
    //TODO: 3 Exibir fila - Listar nomes da lista (1° - Nome, 2°...). Se fila vazia, voltar para menu.
  } else if (option == "4") {
    alert("Opção escolhida é 4");
    //TODO: 4 Sair - Mensagem de despedida. Fim de ciclo.
    break;
  }
} while (checkifproceed());

alert("Ok, bye.\n\nAté a próxima!");

// Functions >

function principalMenu() {
  let msg =
    "Insira o valor da opção que deseja:\n" +
    "\n 1 - Adicionar paciente na fila de atendimento." +
    "\n 2 - Atender próximo paciente da fila." +
    "\n 3 - Exibir lista de nomes na fila." +
    "\n 4 - Sair.";

  let opt = prompt(msg);

  while (Object.is(opt, null) || !opt.match(inputExp)) {
    opt = prompt("OPÇÃO INSERIDA É INVÁLIDA.\n" + msg);
  }
  return opt;
}

function checkifproceed() {
  let proceed = confirm("Deseja continuar utilizando o sistema?");
  return proceed;
}

function addPatient() {
  let ptnt = prompt("Qual o nome do paciente?");
  console.log("prompt: '" + ptnt + "'");
  console.log("!Object.is(ptnt, null): " + !Object.is(ptnt, null));
  console.log("!ptnt.length === 0: " + (ptnt.length === 0) ? true : false);
  console.log("!ptnt.trim(): " + !!ptnt.trim());

  //TODO: Filtrar nomes vazios e pular opeção qndo nulo (clique em cancel).
  if (!Object.is(ptnt, null) || !ptnt.length === 0 || !ptnt.trim()) {
    //TODO: 1 Adicionar paciente - checar se prompt vazio. Cancel volta para menu. (.push)
    alert("Nome é válido!");
  }
  return;
}

console.log("JS executado com sucesso.");
