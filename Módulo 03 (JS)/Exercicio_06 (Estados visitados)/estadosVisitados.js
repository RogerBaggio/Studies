console.log("Executando JS...");

// Main Script>

const statesList = buildStateList();

const playQuiz = confirm(
  "Olá viajante!\n" +
    "\nVamos fazer uma pesquisa de quantos estados você já conheceu?\n"
);

if (playQuiz) {
  const name = prompt("Ok!\nPara começarmos, insira teu nome abaixo:");

  alert(
    "Certo " +
      name +
      "! \nSerão feitas 27 perguntas, uma para cada estado brasileiro." +
      "\nUtilize OK para os estados que já visitou e CANCELAR para os que ainda não teve a oportunidade de conhecer."
  );

  const answers = statesInquiry();

  alert("Muito bem.\nProntinho, " + name + " já temos o resultado!");

  alert(
    "Você conheceu um total de " +
      answers.known.length +
      " estados brasileiros!"
  );
  if (answers.known.length > 0) {
    alert("São eles:\n" + answers.known.join(", \n") + ".");
  }

  alert(
    "E você ainda não visitou " +
      answers.notKnown.length +
      " dos estados brasileiros."
  );
  if (answers.notKnown.length > 0) {
    alert("São eles:\n" + answers.notKnown.join(", \n") + ".");
  }

  if (answers.known.length > 17) {
    alert(
      "Parabéns " +
        name +
        "\n Você pode se considerar um viajante experiênte!\n" +
        "Conheceu mais de dois terços dos estados do Brasil!\nCaraca! Que façanha!"
    );
  } else if (answers.known.length > 8 && answers.known.length < 18) {
    alert(
      "Você já visitou mais de um terço dos estados do Brasil!\n" +
        name +
        " você pode se considerar um explorador de bagagem! Haha!"
    );
  } else {
    alert(
      name +
        ", você visitou menos de um terço dos estados do Brasil.\n" +
        "Há muito chão para percorrer ainda, sua jornada está só começando!\n"
    );
  }
} else {
  alert(
    "Ok, tudo bem!\nVamos deixar esta pesquisa para um outro momento então."
  );
}

alert("É isso.\nAté logo viajante!\nCuide-se bem em sua jornada! ;]");

// Functions >

function buildStateList() {
  //TODO: Criar lista consultando e recuperando valores via API
  let list = [
    "Acre (AC)",
    "Alagoas (AL)",
    "Amapá (AP)",
    "Amazonas (AM)",
    "Bahia (BA)",
    "Ceará (CE)",
    "Distrito Federal (DF)",
    "Espirito Santo (ES)",
    "Goiás (GO)",
    "Maranhão (MA)",
    "Mato Grosso (MT)",
    "Mato Grosso do Sul (MS)",
    "Minas Gerais (MG)",
    "Pará (PA)",
    "Paraíba (PB)",
    "Paraná (PR)",
    "Pernanbuco (PE)",
    "Piauí (PI)",
    "Rio de Janeiro (RJ)",
    "Rio Grande do Norte (RN)",
    "Rio Grande do Sul (RS)",
    "Rondônia (RO)",
    "Roraima (RR)",
    "Santa Catarina (SC)",
    "São Paulo (SP)",
    "Sergipe (SE)",
    "Tocantins (TO)",
  ];

  return list;
}

function statesInquiry() {
  let statesVisited = {
    known: [],
    notKnown: [],
  };

  for (let i = 0; i < statesList.length; i++) {
    let ans = confirm("Você já visitou " + statesList[i] + "?");

    if (ans) {
      statesVisited.known[statesVisited.known.length] = statesList[i];
    } else {
      statesVisited.notKnown[statesVisited.notKnown.length] = statesList[i];
    }
  }
  return statesVisited;
}

console.log("JS executado com sucesso.");
