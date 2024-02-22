console.log("Executando JS...");
console.log("Cadastro de Imóveis.");

// Main Script >

const inputExp = /^[1-5]+$/;
const immobilePropertiesList = [];

class ImmobileProperty {
  constructor(name, owner, address, bedrooms, bathrooms, garage, backyard) {
    this.propertyName = name;
    this.ownerName = owner;
    this.propertyAddress = address;
    this.bedroomsQuantity = bedrooms;
    this.bathroomsQuantity = bathrooms;
    this.hasGarage = garage;
    this.hasBackyard = backyard;
  }
}
//TODO: REMOVER MOCK -->
immobilePropertiesList.push(
  new ImmobileProperty(
    "Apartamento Butantã",
    "Roger",
    "Rua Prof. Giconda Mussolini 291",
    2,
    2,
    true,
    false
  )
);

var immobileProperty = {
  name: "Casa ES",
  owner: "Carol",
  address: "Av. Geronimo Monteiro 1824",
  bedrooms: 2,
  bathrooms: 1,
  garage: false,
  backyard: true,
};

immobilePropertiesList.push(
  new ImmobileProperty(
    immobileProperty.name,
    immobileProperty.owner,
    immobileProperty.address,
    immobileProperty.bedrooms,
    immobileProperty.bathrooms,
    immobileProperty.garage,
    immobileProperty.backyard
  )
);
//TODO: REMOVER MOCK <--

alert(
  "Bem vindo ao Exerício 10 - Cadastro de Imóveis.\n\n" +
    "Este exercício simula de maneira básica o cadastro de imóveis para exemplificar manipulações de objetos e arrays de objetos em JavaScript.\n\n" +
    "Confira as operações possíveis no menu seguinte."
);

do {
  option = mainMenu();

  if (option == "1") {
    showImmobilePropertiesList();
  } else if (option == "2") {
    registerProperty();
  } else if (option == "3") {
    changeImmobilePropertyInfo();
  } else if (option == "4") {
    deleteImmobilePropertyRegistry();
  } else if (option == undefined) {
    checkifproceed() ? option : (option = "5");
  }
} while (option !== "5");

alert("Opção escolhida foi:\n\n5 - Sair do sistema de cadastro de imóveis.");

alert("Ok, bye.\n\nObrigado e até a próxima!");

// Functions >

function mainMenu() {
  let msg =
    "Insira o valor da operação que deseja realizar:" +
    "\n 1 - Exibir lista de imóveis cadastrados." +
    "\n 2 - Cadastrar novo imóvel." +
    "\n 3 - Alterar informações de imóvel." +
    "\n 4 - Remover imóvel cadastrado do sistema." +
    "\n 5 - Sair do sistema de cadastro de imóveis." +
    "\n\n Imóveis castrados no sistema: " +
    immobilePropertiesList.length;

  let opt = prompt(msg);

  while (checkMatchingMenuOption(opt)) {
    if (Object.is(opt, null)) {
      return;
    }
    opt = prompt("OPÇÃO INSERIDA É INVÁLIDA.\n" + msg);
  }
  return opt;
}

function checkMatchingMenuOption(opt) {
  let unmatch;
  if (isNaN(opt) || opt <= 0 || opt >= 6) {
    console.log("opt: " + opt + " //unmatch = true (inside)");
    unmatch = true;
  } else {
    console.log("opt: " + opt + " //unmatch = false (inside)");
    unmatch = false;
  }
  return unmatch;
}

function checkifproceed() {
  let proceed = confirm("Deseja continuar com as operações?");
  return proceed;
}

function showImmobilePropertiesList() {
  if (checkIfEmptyList()) {
    return;
  }

  let input;
  let msg = "Opção 1 - Lista de imóveis cadastrados.\n\n";
  msg += createPropertiesList();
  msg +=
    "\nDeseja visualizar algum registro?\n" +
    "Digite abaixo o número do registro ou clique em cancelar para voltar.";

  input = prompt(msg);

  if (Object.is(input, null)) {
    return;
  }

  while (checkIfInvalid(input, immobilePropertiesList.length)) {
    input = prompt(
      "POR FAVOR, INSIRA UM VALOR VÁLIDO.\n" +
        'Ex.: insira "1" para o 1° imóvel da lista, "2" para o 2°, etc...\n\n' +
        msg
    );
    if (Object.is(input, null)) {
      return;
    }
  }

  msg = returnImmobilePropertyRegistry(input);
  alert(msg);
}

function checkIfEmptyList() {
  let isEmpty = false;
  if (immobilePropertiesList.length === 0) {
    alert(
      "No momento, não há imóveis cadastrados no sistema à serem listados."
    );
    isEmpty = true;
  }
  return isEmpty;
}

function createPropertiesList() {
  let list = "";
  for (let i = 0; i < immobilePropertiesList.length; i++) {
    list +=
      i +
      1 +
      ' - "' +
      immobilePropertiesList[i].propertyName +
      '", proprietário: "' +
      immobilePropertiesList[i].ownerName +
      '".\n';
  }
  return list;
}

function checkIfInvalid(input, lenghtSource) {
  if (isNaN(input) || input.length === 0 || !input.trim()) {
    return true;
  } else if (Number(input) > lenghtSource || Number(input) <= 0) {
    return true;
  }
  return false;
}

function returnImmobilePropertyRegistry(input) {
  let prop = immobilePropertiesList[input - 1];
  let msg =
    "Informações do registro de número " +
    input +
    ":\n" +
    "\n1 - Título: " +
    prop.propertyName +
    "\n2 - Nome do proprietário: " +
    prop.ownerName +
    "\n3 - Endereço: " +
    prop.propertyAddress +
    "\n4 - Quantidade de quartos: " +
    prop.bedroomsQuantity +
    "\n5 - Quantidade de banheiros: " +
    prop.bathroomsQuantity +
    "\n6 - Possui garagem? " +
    (prop.hasGarage ? "Sim" : "Não") +
    "\n7 - Possui quintal? " +
    (prop.hasBackyard ? "Sim" : "Não");

  return msg;
}

function registerProperty() {
  let msg = "Opção 2 - Cadastrar novo imóvel.";
  let prop = new ImmobileProperty(); //immobilePropertiesList[1];

  for (let value in prop) {
    let input = null;

    switch (value) {
      case "propertyName":
        msg += "\nQual o título deste novo registro de imóvel?";
        input = prompt(msg);

        if (Object.is(input, null)) {
          return;
        }

        while (input.length === 0 || !input.trim()) {
          input = prompt("POR FAVOR, INSIRA TÍTULO VÁLIDO.\n" + msg);
          if (Object.is(input, null)) {
            return;
          }
        }

        prop[value] = normalizeInputEntry(input);
        break;

      case "ownerName":
        msg = "Qual o nome do proprietário deste imóvel?";
        input = prompt(msg);
        if (Object.is(input, null)) {
          return;
        }

        while (input.length === 0 || !input.trim()) {
          input = prompt("POR FAVOR, INSIRA UM NOME VÁLIDO.\n" + msg);
          if (Object.is(input, null)) {
            return;
          }
        }

        prop[value] = normalizeInputEntry(input);
        break;

      case "propertyAddress":
        msg = "Qual o endereço deste imóvel?";
        input = prompt(msg);
        if (Object.is(input, null)) {
          return;
        }

        while (input.length === 0 || !input.trim()) {
          input = prompt("POR FAVOR, INSIRA UM ENDEREÇO VÁLIDO.\n" + msg);
          if (Object.is(input, null)) {
            return;
          }
        }

        prop[value] = normalizeInputEntry(input);
        break;

      case "bedroomsQuantity":
        msg = "Quantos quartos possui este imóvel?";
        input = prompt(msg);
        if (Object.is(input, null)) {
          return;
        }

        while (isNaN(input) || input.length === 0 || !input.trim()) {
          input = prompt("POR FAVOR, INSIRA APENAS NÚMEROS.\n" + msg);
          if (Object.is(input, null)) {
            return;
          }
        }

        prop[value] = input;
        break;

      case "bathroomsQuantity":
        msg = "Quantos banheiros possui este imóvel?";
        input = prompt(msg);
        if (Object.is(input, null)) {
          return;
        }

        while (isNaN(input) || input.length === 0 || !input.trim()) {
          input = prompt("POR FAVOR, INSIRA APENAS NÚMEROS.\n" + msg);
          if (Object.is(input, null)) {
            return;
          }
        }

        prop[value] = input;
        break;

      case "hasGarage":
        msg =
          'Este imóvel possui garagem?\nClique em OK para "SIM" ou Cancelar para "NÃO"';
        input = confirm(msg);

        prop[value] = input;
        break;

      case "hasBackyard":
        msg =
          'Este imóvel possui Quintal?\nClique em OK para "SIM" ou Cancelar para "NÃO"';
        input = confirm(msg);

        prop[value] = input;
        break;
      default:
        msg = "Qual o " + value + " deste imóvel?";
        input = prompt(msg);

        if (Object.is(input, null)) {
          return;
        }

        while (input.length === 0 || !input.trim()) {
          input = prompt("POR FAVOR, INSIRA UM " + value + " VÁLIDO.\n" + msg);
          if (Object.is(input, null)) {
            return;
          }
        }

        prop[value] = normalizeInputEntry(input);
    }
  }

  immobilePropertiesList.push(prop);
  return;
}

function normalizeInputEntry(input) {
  let normalizedInput = input;
  normalizedInput = normalizedInput.replace(/[.,\/#!$%\^&\*;:{}=\-_`~()]/g, "");
  normalizedInput = normalizedInput.replace(/\s+/g, " ");
  normalizedInput = normalizedInput.trimStart();
  normalizedInput = normalizedInput.trimEnd();
  normalizedInput = normalizedInput.toLowerCase();

  normalizedInput = normalizedInput
    .split(" ")
    .map((word) => word.charAt(0).toUpperCase() + word.substring(1))
    .join(" ");

  return normalizedInput;
}

function changeImmobilePropertyInfo() {
  if (checkIfEmptyList()) {
    return;
  }

  let selectedRegistry;
  let infoPosition;

  let msg = "Opção 3 - Alterar informações de imóveis.\n\n";
  msg += createPropertiesList();
  msg +=
    "\nQual registro deseja alterar as informações?\n" +
    "Digite abaixo o número do registro ou clique em cancelar para voltar.";

  selectedRegistry = prompt(msg);

  if (Object.is(selectedRegistry, null)) {
    return;
  }

  while (checkIfInvalid(selectedRegistry, immobilePropertiesList.length)) {
    selectedRegistry = prompt(
      "POR FAVOR, INSIRA UM VALOR VÁLIDO.\n" +
        'Ex.: insira "1" para o 1° imóvel da lista, "2" para o 2°, etc...\n\n' +
        msg
    );
    if (Object.is(selectedRegistry, null)) {
      return;
    }
  }

  msg = returnImmobilePropertyRegistry(selectedRegistry);
  msg +=
    "\n\nDigite abaixo o número referente a informação que deseja alterar ou clique em cancelar para voltar ao menu principal.";

  infoPosition = prompt(msg);

  if (Object.is(infoPosition, null)) {
    return;
  }

  while (
    checkIfInvalid(
      infoPosition,
      Object.keys(immobilePropertiesList[selectedRegistry - 1]).length
    )
  ) {
    infoPosition = prompt(
      "POR FAVOR, INSIRA UM VALOR VÁLIDO.\n" +
        'Ex.: insira "1" para "Título", "2" para "Nome do proprietário", etc...\n\n' +
        msg
    );
    if (Object.is(infoPosition, null)) {
      return;
    }
  }

  changeInfoField(selectedRegistry, infoPosition);
  return;
}

function changeInfoField(selectedRegistry, infoPosition) {
  let newInfoValue;
  let msg =
    "Qual o novo valor deste campo para este registro?\n\nInformação atual do registro de número " +
    selectedRegistry +
    ":";
  if (Number(infoPosition) == 1) {
    msg +=
      "\n1 - Título: " +
      immobilePropertiesList[selectedRegistry - 1].propertyName;
    newInfoValue = prompt(msg);

    if (Object.is(newInfoValue, null)) {
      return;
    }

    while (newInfoValue.length === 0 || !newInfoValue.trim()) {
      newInfoValue = prompt("POR FAVOR, INSIRA UM TÍTULO VÁLIDO.\n" + msg);
      if (Object.is(newInfoValue, null)) {
        return;
      }
    }
    newInfoValue = normalizeInputEntry(newInfoValue);
    immobilePropertiesList[selectedRegistry - 1].propertyName = newInfoValue;
  }
  if (Number(infoPosition) == 2) {
    msg +=
      "\n2 - Nome do proprietário: " +
      immobilePropertiesList[selectedRegistry - 1].ownerName;
    newInfoValue = prompt(msg);

    if (Object.is(newInfoValue, null)) {
      return;
    }

    while (newInfoValue.length === 0 || !newInfoValue.trim()) {
      newInfoValue = prompt("POR FAVOR, INSIRA UM NOME VÁLIDO.\n" + msg);
      if (Object.is(newInfoValue, null)) {
        return;
      }
    }
    newInfoValue = normalizeInputEntry(newInfoValue);
    immobilePropertiesList[selectedRegistry - 1].ownerName = newInfoValue;
  }
  if (Number(infoPosition) == 3) {
    msg +=
      "\n3 - Endereço: " +
      immobilePropertiesList[selectedRegistry - 1].propertyAddress;
    newInfoValue = prompt(msg);

    if (Object.is(newInfoValue, null)) {
      return;
    }

    while (newInfoValue.length === 0 || !newInfoValue.trim()) {
      newInfoValue = prompt("POR FAVOR, INSIRA UM ENDEREÇO VÁLIDO.\n" + msg);
      if (Object.is(newInfoValue, null)) {
        return;
      }
    }
    newInfoValue = normalizeInputEntry(newInfoValue);
    immobilePropertiesList[selectedRegistry - 1].propertyAddress = newInfoValue;
  }
  if (Number(infoPosition) == 4) {
    msg +=
      "\n4 - Quantidade de quartos: " +
      immobilePropertiesList[selectedRegistry - 1].bedroomsQuantity;
    newInfoValue = prompt(msg);
    if (Object.is(newInfoValue, null)) {
      return;
    }

    while (
      isNaN(newInfoValue) ||
      newInfoValue.length === 0 ||
      !newInfoValue.trim()
    ) {
      newInfoValue = prompt("POR FAVOR, INSIRA APENAS NÚMEROS.\n" + msg);
      if (Object.is(newInfoValue, null)) {
        return;
      }
    }

    immobilePropertiesList[selectedRegistry - 1].bedroomsQuantity =
      newInfoValue;
  }
  if (Number(infoPosition) == 5) {
    msg +=
      "\n5 - Quantidade de banheiros: " +
      immobilePropertiesList[selectedRegistry - 1].bathroomsQuantity;
    newInfoValue = prompt(msg);
    if (Object.is(newInfoValue, null)) {
      return;
    }

    while (
      isNaN(newInfoValue) ||
      newInfoValue.length === 0 ||
      !newInfoValue.trim()
    ) {
      newInfoValue = prompt("POR FAVOR, INSIRA APENAS NÚMEROS.\n" + msg);
      if (Object.is(newInfoValue, null)) {
        return;
      }
    }

    immobilePropertiesList[selectedRegistry - 1].bathroomsQuantity =
      newInfoValue;
  }
  if (Number(infoPosition) == 6) {
    msg +=
      "\n6 - Possui garagem? " +
      (immobilePropertiesList[selectedRegistry - 1].hasGarage ? "Sim" : "Não") +
      '\n\nClique em OK para "SIM" ou Cancelar para "NÃO"';
    newInfoValue = confirm(msg);

    immobilePropertiesList[selectedRegistry - 1].hasGarage = newInfoValue;
  }
  if (Number(infoPosition) == 7) {
    msg +=
      "\n7 - Possui quintal? " +
      (immobilePropertiesList[selectedRegistry - 1].hasBackyard
        ? "Sim"
        : "Não") +
      '\n\nClique em OK para "SIM" ou Cancelar para "NÃO"';
    newInfoValue = confirm(msg);

    immobilePropertiesList[selectedRegistry - 1].hasBackyard = newInfoValue;
  }
}

function deleteImmobilePropertyRegistry() {
  if (checkIfEmptyList()) {
    return;
  }

  let selectedRegistry;
  let msg = "Opção 4 - Remover imóvel cadastrado do sistema.\n\n";
  msg += createPropertiesList();
  msg +=
    "\nQual registro deseja remover do sistema?" +
    "\nDigite abaixo o número do registro ou clique em cancelar para voltar.";

  selectedRegistry = prompt(msg);

  if (Object.is(selectedRegistry, null)) {
    return;
  }

  while (checkIfInvalid(selectedRegistry, immobilePropertiesList.length)) {
    selectedRegistry = prompt(
      "POR FAVOR, INSIRA UM VALOR VÁLIDO.\n" +
        'Ex.: insira "1" para o 1° imóvel da lista, "2" para o 2°, etc...\n\n' +
        msg
    );
    if (Object.is(selectedRegistry, null)) {
      return;
    }
  }

  msg = returnImmobilePropertyRegistry(selectedRegistry);
  msg +=
    '\n\nTem certeza que deseja deletar o registro acima?\nClique em OK para "SIM" ou Cancelar para "NÃO"';
  if (confirm(msg)) {
    immobilePropertiesList.splice(selectedRegistry - 1, 1);
    alert(
      "O registro de numero " + selectedRegistry + " foi deletado com sucesso."
    );
  }
}

console.log("JS executado com sucesso.");
