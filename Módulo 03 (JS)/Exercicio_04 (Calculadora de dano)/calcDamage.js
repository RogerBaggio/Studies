console.log("Executando JS...");

// Main script >

const attacker = { nm: "", atk: "" };
const defender = { nm: "", hp: "", def: "", shld: "" };

attacker.nm = coletarNome("atacante");
attacker.atk = coletarValor("ataque", attacker.nm);

console.log(
  "Attacker - nome: " + attacker.nm + ". Ataque: " + attacker.atk + "."
);

defender.nm = coletarNome("defensor");
defender.hp = coletarValor("vida", defender.nm);
defender.def = coletarValor("defesa", defender.nm);
defender.shld = hasShield(defender.nm);

console.log(
  "Defender - nome: " +
    defender.nm +
    ". Vida: " +
    defender.hp +
    ". Defesa: " +
    defender.def +
    ". Escudo: " +
    defender.shld +
    "."
);

alert(
  "Status dos personagens:\n \nNome do Atacante: " +
    attacker.nm +
    ".\nAtaque: " +
    attacker.atk +
    ".\n \nNome do defensor: " +
    defender.nm +
    ".\nVida: " +
    defender.hp +
    ". Defesa: " +
    defender.def +
    ". Escudo: " +
    defender.shld +
    "."
);

alert("A batalha foi calculada!");

alert(battleResult(attacker, defender));

// Functions >

function coletarNome(position) {
  let nome = prompt("Qual nome do personagem " + position + "?");
  while (nome.length === 0 || !nome.trim()) {
    nome = prompt(
      "Qual nome do personagem " +
        position +
        "?\nInsira um nome válido, por favor."
    );
  }
  return nome;
}

function coletarValor(texto, nome) {
  let valor = prompt(
    "Quantos pontos de " + texto + " tem o personagem " + nome + "?"
  );
  while (isNaN(valor) || valor.length === 0 || !valor.trim()) {
    valor = prompt(
      "Quantos pontos de " +
        texto +
        " tem o personagem " +
        nome +
        "?\n*Utilize apenas algarismos, por favor."
    );
  }
  return valor;
}

function hasShield(nome) {
  let valor = confirm(
    "O personagem " + nome + " possui escudo?\n(Ok para Sim, Cancel para Não.)"
  );
  return valor;
}

function battleResult(char1, char2) {
  let hp;
  let result;
  let damage;
  
  if (Number(char1.atk) > Number(char2.def) && !Boolean(char2.shld)) {
    damage = char1.atk - char2.def;
  } else if (Number(char1.atk) > Number(char2.def) && Boolean(char2.shld)) {
    damage = (char1.atk - char2.def) / 2;
  } else {
    damage = 0;
  }

  hp = char2.hp - damage;

  result =
    "Resultado:\n \nO personagem " +
    char2.nm +
    " sofreu " +
    damage +
    " pontos de dano,\nportanto possui " +
    hp +
    " pontos de vida após o ataque de " +
    char1.nm +
    ".";

  console.log(result);
  return result;
}
console.log("JS carregado com sucesso.");
