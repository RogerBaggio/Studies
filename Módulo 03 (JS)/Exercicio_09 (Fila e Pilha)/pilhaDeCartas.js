console.log("Executando JS...");
console.log("Pilha de Cartas.");

// Main Script >

const cardList = [
  "As de Ouros ♦",
  "As de Espadas ♠",
  "As de Copas ♥",
  "As de Paus ♣",
  "2 de Ouros ♦",
  "2 de Espadas ♠",
  "2 de Copas ♥",
  "2 de Paus ♣",
  "3 de Ouros ♦",
  "3 de Espadas ♠",
  "3 de Copas ♥",
  "3 de Paus ♣",
  "4 de Ouros ♦",
  "4 de Espadas ♠",
  "4 de Copas ♥",
  "4 de Paus ♣",
  "5 de Ouros ♦",
  "5 de Espadas ♠",
  "5 de Copas ♥",
  "5 de Paus ♣",
  "6 de Ouros ♦",
  "6 de Espadas ♠",
  "6 de Copas ♥",
  "6 de Paus ♣",
  "7 de Ouros ♦",
  "7 de Espadas ♠",
  "7 de Copas ♥",
  "7 de Paus ♣",
  "8 de Ouros ♦",
  "8 de Espadas ♠",
  "8 de Copas ♥",
  "8 de Paus ♣",
  "9 de Ouros ♦",
  "9 de Espadas ♠",
  "9 de Copas ♥",
  "9 de Paus ♣",
  "10 de Ouros ♦",
  "10 de Espadas ♠",
  "10 de Copas ♥",
  "10 de Paus ♣",
  "J de Ouros ♦",
  "J de Espadas ♠",
  "J de Copas ♥",
  "J de Paus ♣",
  "Q de Ouros ♦",
  "Q de Espadas ♠",
  "Q de Copas ♥",
  "Q de Paus ♣",
  "K de Ouros ♦",
  "K de Espadas ♠",
  "K de Copas ♥",
  "K de Paus ♣",
];

alert(
  "Bem vindo ao Exerício 09 B - Pilha de Cartas!\n\n" +
    "Este sistema não serve pra nada além de exemplificar algumas manipulações básicas de Arrays em JavaScript.\n\n" +
    "Confira as operações possíveis no menu seguinte."
);

const inputExp = /^[1-5]+$/;
var deckCards = cardList;
var drawnCards = [];
var option;

do {
  option = mainMenu();

  if (option == "1") {
    alert("Opção escolhida foi:\n\n1 - Exibir lista de cartas no baralho.");
    //TODO: opção 1 - Exibir lista de cartas no baralho.
    //showDeckCardList();
  } else if (option == "2") {
    alert("Opção escolhida foi:\n\n2 - Exibir lista de cartas na sacadas.");
    //TODO: opção 2 - Exibir lista de cartas na sacadas.
    //showDrawnCardList();
  } else if (option == "3") {
    alert("Opção escolhida foi:\n\n3 - Sacar carta aleatoria do baralho.");
    //TODO: opção 3 - Sacar carta aleatoria do baralho.
    //drawnCardFromDeck();
  } else if (option == "4") {
    alert("Opção escolhida foi:\n\n4 - Devolver carta selecionada ao baralho.");
    //TODO: opção 4 - Devolver carta selecionada ao baralho.
    //returnCardToDeck();
  } else if (option == "5") {
    alert("Opção escolhida foi:\n\n5 - Sair do sistema de pilha de cartas.");
    //TODO: opção 5 - Sair.
    break;
  }
} while (checkifproceed());

alert("Ok, bye.\n\nObrigado e até a próxima!");

// Functions >

function mainMenu() {
  let msg =
    "Insira o valor da opção que deseja:\n" +
    "\n 1 - Exibir lista de cartas no baralho." +
    "\n 2 - Exibir lista de cartas na sacadas." +
    "\n 3 - Sacar carta aleatoria do baralho." +
    "\n 4 - Devolver carta selecionada ao baralho." +
    "\n 5 - Sair do sistema de pilha de cartas." +
    "\n\n Cartas no baralho: " +
    deckCards.length +
    " // Cartas sacadas: " +
    drawnCards.length;

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

console.log("JS executado com sucesso.");
