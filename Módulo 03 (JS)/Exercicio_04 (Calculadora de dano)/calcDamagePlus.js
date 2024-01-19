console.log("Carregando JS...");

// Main script -------------------------------------------------->

var player1 = { nm: "", pwr: "", def: "", hp: "", crit: "", shld: "" };
var player2 = player1;

player1.nm = coletarNome("primeiro");
player1.pwr = coletarValor("ataque", player1.nm);
player1.def = coletarValor("defesa", player1.nm);
player1.hp = coletarValor("vida", player1.nm);
player1.crit = coletarValorCrit(player1.nm);
player1.shld = hasShield(player1.nm);

console.log(
  "P1 - nome: " +
    player1.nm +
    ". Ataque: " +
    player1.pwr +
    ". Defesa: " +
    player1.def +
    ". Vida: " +
    player1.hp +
    ". Sorte: " +
    player1.crit +
    ". Escudo: " +
    player1.shld
);

player2.nm = coletarNome("segundo");
player2.pwr = coletarValor("ataque", player2.nm);
player2.def = coletarValor("defesa", player2.nm);
player2.hp = coletarValor("vida", player2.nm);
player2.crit = coletarValorCrit(player2.nm);
player2.shld = hasShield(player2.nm);

console.log(
  "P2 - nome: " +
    player2.nm +
    ". Ataque: " +
    player2.pwr +
    ". Defesa: " +
    player2.def +
    ". Vida: " +
    player2.hp +
    ". Sorte: " +
    player2.crit +
    ". Escudo: " +
    player2.shld
);

// Functions -------------------------------------------------->

function coletarNome(position) {
  let nome = prompt("Qual nome do " + position + " personagem?");
  while (nome.length === 0 || !nome.trim()) {
    nome = prompt(
      "Qual nome do " +
        position +
        " personagem?\nInsira um nome válido, por favor."
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

function coletarValorCrit(nome) {
  let valor = prompt(
    "Quantos pontos de sorte tem o personagem " +
      nome +
      "?\n(Insira um valor de 1 a 10.)"
  );
  while (isNaN(valor) || valor <= 0 || valor >= 11) {
    valor = prompt(
      "Quantos pontos de sorte tem o personagem " +
        nome +
        "?\n(Insira um valor de 1 a 10, por favor.)"
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

function fight(char1, char2) {
  let p1 = char1;
  let p2 = char2;

  //while (hpP1 >= 1 || hpP2 >= 1) {}
}

function damageCalc(attacker, defender) {
  let atkr = attacker;
  let defr = defender;
  let results = { hp: "", crit: "", damage: "" };
  let isCrit = criticalHit(atkr.crit);

  if (isCrit) {
    results.crit = isCrit;
    atkr.pwr = atkr.pwr * 2;
  }

  if (defr.shld) {
    defr.def = defr.def * 1.5;
  }

  if (atkr.pwr > defr.def) {
    results.damage = atkr.pwr - defr.def;
    results.hp = defr.hp - results.damage;
  }

  return results;
}

function criticalHit(critRate) {
  let chance = Math.floor(Math.random() * 11);

  if (critRate >= chance) {
    return true;
  } else {
    return false;
  }
}

/*
começar luta{
  calcular ataque
  checar sobrevivencia
  calcular contra ataque
  checar sobrevivencia
  reiniciar ciclo ...
  anunciar resultado (e estatisticas?)
}

calcular ataque(atacante, defensor){
 atacante.ataque > defesa?
 *possui escudo? defesa = defesa*1.5
 *atacante.golpe critico? atacante.ataque =  ataque*2
 
 dano = ataque - defesa
 
 hp = hp - dano
}

checar sobrevivencia{

}
*/

console.log("JS carregado com sucesso.");
