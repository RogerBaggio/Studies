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
  option = mainMenu();

  if (option == "1") {
    alert(
      "Opção escolhida foi:\n\n1 - Adicionar paciente à fila de atendimento."
    );
    addPatient();
  } else if (option == "2") {
    alert(
      "Opção escolhida foi:\n\n2 - Atender próximo paciente da fila de atendimento."
    );
    assistPatient();
  } else if (option == "3") {
    alert(
      "Opção escolhida foi:\n\n3 - Exibir lista de nomes na fila de atendimento."
    );
    showNameList();
  } else if (option == "4") {
    alert(
      "Opção escolhida foi:\n\n4 - Sair do sistema de fila de atendimentos."
    );
    break;
  }
} while (checkifproceed());

alert("Ok, bye.\n\nObrigado e até a próxima!");

// Functions >

function mainMenu() {
  let msg =
    "Insira o valor da opção que deseja:\n" +
    "\n 1 - Adicionar paciente à fila de atendimento." +
    "\n 2 - Atender próximo paciente da fila de atendimento." +
    "\n 3 - Exibir lista de nomes na fila de atendimento." +
    "\n 4 - Sair do sistema de fila de atendimentos.";

  let opt = prompt(msg);

  while (Object.is(opt, null) || !opt.match(inputExp)) {
    if (Object.is(opt, null)) {
      return;
    }
    opt = prompt("OPÇÃO INSERIDA É INVÁLIDA.\n" + msg);
  }
  return opt;
}

function checkifproceed() {
  let proceed = confirm("Deseja continuar utilizando o sistema?");
  return proceed;
}

function addPatient() {
  let msg = "Qual o nome do paciente a ser registrado na fila?";
  let name = prompt(msg);

  if (Object.is(name, null)) {
    return;
  }

  while (name.length === 0 || !name.trim()) {
    name = prompt("POR FAVOR, INSIRA UM NOME VÁLIDO.\n" + msg);
    if (Object.is(name, null)) {
      return;
    }
  }

  name = normalizeNameEntry(name);
  patientList.push(name);

  return;
}

function normalizeNameEntry(name) {
  let normalizedName = name;
  normalizedName = normalizedName.replace(/[.,\/#!$%\^&\*;:{}=\-_`~()]/g, "");
  normalizedName = normalizedName.replace(/\s+/g, " ");
  normalizedName = normalizedName.trimStart();
  normalizedName = normalizedName.trimEnd();
  normalizedName = normalizedName.toLowerCase();

  normalizedName = normalizedName
    .split(" ")
    .map((word) => word.charAt(0).toUpperCase() + word.substring(1))
    .join(" ");

  return normalizedName;
}

function assistPatient() {
  let patient = patientList.shift();

  if (checkEmptyList()) {
    return;
  }

  confirm(
    patient +
      " será chamado para atendimento agora.\n" +
      "Portanto este paciente será removido da fila de atendimentos.\n\n" +
      "Obrigado."
  );
  return;
}

function checkEmptyList() {
  let isEmpty = false;
  if (patientList.length === 0) {
    alert("No momento, não há pacientes na fila de atendimento.");
    isEmpty = true;
  }
  return isEmpty;
}

function showNameList() {
  if (checkEmptyList()) {
    return;
  }

  let msg = "Lista de pacientes por ondem de chegada:\n\n";

  for (let i = 0; i < patientList.length; i++) {
    msg += i + 1 + "° paciente: " + patientList[i] + ".\n";
  }

  alert(msg);
  return;
}
console.log("JS executado com sucesso.");
