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
    "Patamento Obuts",
    "Roger",
    "Rua Prof. Giconda Mussolini 291",
    2,
    2,
    true,
    false
  )
);

var immobileProperty = {
  name: "Casinha Pílito",
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
    showPropertiesList();
  } else if (option == "2") {
    //TODO: Cadastrar Imóvel
    registerProperty();
  } else if (option == "3") {
    //TODO: Alterar Imóvel
  } else if (option == "4") {
    //TODO: Remover Imóvel
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
    "\n 4 - Remover imóvel do sistema." +
    "\n 5 - Sair do sistema de cadastro de imóveis." +
    "\n\n Imóveis castrados no sistema: " +
    immobilePropertiesList.length;

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
  let proceed = confirm("Deseja continuar com as operações?");
  return proceed;
}

function showPropertiesList() {
  if (checkIfEmptyList()) {
    return;
  }

  let msg = "Lista de imóveis cadastrados:\n\n";
  msg += createPropertiesList();

  alert(msg);
  return;
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
      '° imóvel: "' +
      immobilePropertiesList[i].propertyName +
      '", proprietário: "' +
      immobilePropertiesList[i].ownerName +
      '".\n';
  }
  return list;
}

function registerProperty() {
  let msg = "Opção: 2 - Cadastrar imóvel.";
  let prop = immobilePropertiesList[1]; //new ImmobileProperty();

  for (let value in prop) {
    if (
      value == "propertyName" ||
      value == "ownerName" ||
      value == "propertyAddress"
    ) {
      //TODO: adicionar valor a propriedade do objeto
    } else if (value == "bedroomsQuantity" || value == "bathroomsQuantity") {
      //TODO: adicionar valor a propriedade do objeto
    } else if (value == "hasGarage" || value == "hasBackyard") {
      //TODO: adicionar valor a propriedade do objeto
    }
    alert(value + ": " + prop[value]);
    console.log(value + ": " + prop[value]);
  }

  //TODO: Adicionar objeto preenchido a lista
  return;
}

console.log("JS executado com sucesso.");
