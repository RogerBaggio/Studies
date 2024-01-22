console.log("Executando JS...");

// Main Script>

const inputExp = /^[1-6]+$/;

const measure = collectValue();

const option = optionSelect();

const resultMsg = measureConversor(measure, option);

alert(resultMsg);

// Functions >

function collectValue() {
  let msg = "Insira o valor em METROS a ser convertido:";
  let value = prompt(msg);

  while (isNaN(value) || value <= 0) {
    value = prompt(msg +"\n(Utilize apenas apenas números e maiores que zero.)");
  }
  return Number(value.trim());  
}

function optionSelect(){
  let msg = "Selecione uma opção de medida para qual o valor deverá ser convertido:"+
    "\n 1 - converter para MILIMETROS. (*1000)"+
    "\n 2 - converter para CENTIMETROS. (*100)"+
    "\n 3 - converter para DECIMETROS. (*10)"+
    "\n 4 - converter para DECAMETROS. (/10)"+
    "\n 5 - converter para HECTOMETROS. (/100)"+
    "\n 6 - converter para QUILOMETROS. (/1000)";
  
    let opt = prompt(msg);

  while (!opt.match(inputExp)) {
    opt = prompt("OPÇÃO INSERIDA É INVALIDA.\n"+ msg);
  }

  return Number(opt);
}

function measureConversor(value, opt){
let message = value + " metro(s) equivale a ";

  switch (opt) {
    case 1:
      message = message + (value * 1000) +" milimetros.";
      break;
    case 2:
      message = message + (value * 100) +" centimetros.";
      break;
    case 3:
      message = message + (value * 10) +" decimetros.";
      break;
    case 4:
      message = message + (value / 10) +" decametros.";
      break;
    case 5:
      message = message + (value / 100) +" hecmetros.";
      break;
    case 6:
      message = message + (value / 1000) +" quilometros.";
      break;
  }
  return message;
}

console.log("JS carregado com sucesso.");