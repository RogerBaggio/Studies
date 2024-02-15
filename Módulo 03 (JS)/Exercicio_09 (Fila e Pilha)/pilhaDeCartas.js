console.log("Executando JS...");
console.log("Pilha de Cartas.");

// Main Script >

const inputExp = /^[1-5]+$/;
const cardList = [
  "As de ♦",
  "As de ♠",
  "As de ♥",
  "As de ♣",
  "2 de ♦",
  "2 de ♠",
  "2 de ♥",
  "2 de ♣",
  "3 de ♦",
  "3 de ♠",
  "3 de ♥",
  "3 de ♣",
  "4 de ♦",
  "4 de ♠",
  "4 de ♥",
  "4 de ♣",
  "5 de ♦",
  "5 de ♠",
  "5 de ♥",
  "5 de ♣",
  "6 de ♦",
  "6 de ♠",
  "6 de ♥",
  "6 de ♣",
  "7 de ♦",
  "7 de ♠",
  "7 de ♥",
  "7 de ♣",
  "8 de ♦",
  "8 de ♠",
  "8 de ♥",
  "8 de ♣",
  "9 de ♦",
  "9 de ♠",
  "9 de ♥",
  "9 de ♣",
  "10 de ♦",
  "10 de ♠",
  "10 de ♥",
  "10 de ♣",
  "J de ♦",
  "J de ♠",
  "J de ♥",
  "J de ♣",
  "Q de ♦",
  "Q de ♠",
  "Q de ♥",
  "Q de ♣",
  "K de ♦",
  "K de ♠",
  "K de ♥",
  "K de ♣",
];

alert(
  "Bem vindo ao Exerício 09 B - Pilha de Cartas!\n\n" +
    "Este sistema não serve pra nada além de exemplificar algumas manipulações básicas de Arrays em JavaScript.\n\n" +
    "Confira as operações possíveis no menu seguinte."
);

var deckCards = cardList;
var drawnCards = [];
var option;

do {
  option = mainMenu();

  if (option == "1") {
    alert("Opção escolhida foi:\n\n1 - Exibir lista de cartas no baralho.");
    showCardList(deckCards, "no baralho");
  } else if (option == "2") {
    alert("Opção escolhida foi:\n\n2 - Exibir lista de cartas na sacadas.");
    showCardList(drawnCards, "em sua mão");
  } else if (option == "3") {
    alert("Opção escolhida foi:\n\n3 - Sacar carta aleatoria do baralho.");
    drawCards();
  } else if (option == "4") {
    alert("Opção escolhida foi:\n\n4 - Devolver carta selecionada ao baralho.");
    returnCard();
  } else if (option == undefined) {
    checkifproceed() ? option : (option = "5");
  }
} while (option != "5");

alert("Opção escolhida foi:\n\n5 - Sair do sistema de pilha de cartas.");

alert("Ok, bye.\n\nObrigado e até a próxima!");

// Functions >

function mainMenu() {
  let msg =
    "Insira o valor da opção que deseja:" +
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

function showCardList(cardList, source) {
  if (checkIfEmptyList(cardList, source)) {
    return;
  }

  let msg = "Lista de cartas " + source + ":\n\n";
  msg += createCardList(cardList);

  alert(msg);
  return;
}

function createCardList(cardList) {
  let list = "";
  for (let i = 0; i < cardList.length; i++) {
    list += i + 1 + '° carta: "' + cardList[i] + '". ';
  }
  return list;
}

function checkIfEmptyList(cardList, source) {
  let isEmpty = false;
  if (cardList.length === 0) {
    alert("No momento, não há cartas " + source + " à serem listadas.");
    isEmpty = true;
  }
  return isEmpty;
}

function drawCards() {
  let card;
  if (deckCards.length > 0) {
    card = deckCards.splice(Math.floor(Math.random() * deckCards.length), 1);
    drawnCards = drawnCards.concat(card);
    alert('Você sacou a carta "' + card + '".');
    return;
  }
  alert("Não há cartas restantes no baralho à serem sacadas.");
}

function returnCard() {
  let msg = "Selecione uma das cartas a seguir para retornar ao baralho:\n\n";
  let input;
  let selectedCard;

  if (drawnCards.length > 0) {
    msg += createCardList(drawnCards);
    input = prompt(msg);

    if (Object.is(input, null)) {
      return;
    }

    while (checkIfInvalid(input)) {
      input = prompt(
        "POR FAVOR, INSIRA UM VALOR VÁLIDO.\n" +
          'Ex.: insira "1" para 1° carta da lista, "2" para 2°, etc...\n' +
          msg
      );
      if (Object.is(input, null)) {
        return;
      }
    }

    selectedCard = drawnCards.splice(input - 1, 1);
    deckCards.push(selectedCard);

    alert('Você devolveu a carta "' + selectedCard + '" ao baralho.');

    return;
  }
  alert("Não há cartas sacadas à serem retornadas ao baralho.");
}

function checkIfInvalid(input) {
  if (isNaN(input) || input.length === 0 || !input.trim()) {
    return true;
  } else if (Number(input) > drawnCards.length || Number(input) <= 0) {
    return true;
  }
  return false;
}
console.log("JS executado com sucesso.");
