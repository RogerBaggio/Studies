console.log("Executando JS...");
console.log("Teste de velocidades.");

// Main Script >

const nomeVeiculo1 = prompt("Qual o nome do primeiro veículo?");
const velocidadeVeiculo1 = coletarVelocidade();

const nomeVeiculo2 = prompt("Qual o nome do segundo veículo?");
const velocidadeVeiculo2 = coletarVelocidade();

alert(compararVelocidades());

function coletarVelocidade() {
  let velocidade = prompt("Velocidade do veículo :");

  while (isNaN(velocidade)) {
    velocidade = prompt(
      "Velocidade do veículo (utilize apenas apenas números):"
    );
  }
  return velocidade;
}

// Functions >

function compararVelocidades() {
  let texto =
    "Veículo: " +
    nomeVeiculo1 +
    ". Velocidade: " +
    velocidadeVeiculo1 +
    ". \nVeículo: " +
    nomeVeiculo2 +
    ". Velocidade: " +
    velocidadeVeiculo2 +
    ".\nResultado: ";

  if (velocidadeVeiculo1 == velocidadeVeiculo2) {
    return texto + "Ambos os veículos possuem mesma velocidade.";
  } else if (velocidadeVeiculo1 > velocidadeVeiculo2) {
    return texto + "Veículo " + nomeVeiculo1 + " é mais o rápido.";
  } else {
    return texto + "Veículo " + nomeVeiculo2 + " é mais o rápido.";
  }
}

console.log("JS executado com sucesso.");
