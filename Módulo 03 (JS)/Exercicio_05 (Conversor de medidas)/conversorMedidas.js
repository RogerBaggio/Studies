console.log("Executando JS...");

const medida = coletarValor();

function coletarValor() {
  let medida = prompt("Insira o valor de metragem a ser convertida:");

  while (isNaN(medida)) {
    medida = prompt(
      "Insira o valor de metragem a ser convertida:\n(Utilize apenas apenas números, por favor.):"
    );
  }
  return medida;
}
/*metro para milimetro *1000
metro para centimetro *100
metro para decimetros *10
metro para decametros /10
metro para hectometros /100
metro para quilometros /1000


*/
