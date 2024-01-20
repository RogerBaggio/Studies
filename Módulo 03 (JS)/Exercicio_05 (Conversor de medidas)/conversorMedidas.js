console.log("Executando JS...");

// Main Script>

const measure = collectValue();
console.log("'"+measure+"'");

const option = optionSelect();

const convertedMeasureMsg = measureConversor(measure, option);

alert(convertedMeasureMsg);

// Functions >

function collectValue() {
  let value = prompt("Insira o valor em METROS a ser convertido:");

  while (isNaN(value) || value <= 0) {
    value = prompt(
      "Insira o valor em METROS a ser convertido:\n(Utilize apenas apenas números e maiores que zero, por favor.):"
    );
  }
  return value.trim();
}

function optionSelect(){
  let opt = prompt("Selecione uma opção de medida para qual o valor deverá ser convertido:"+
    "\n 1 - converter para MILIMETROS. (*1000)"+
    "\n 2 - converter para CENTIMETROS. (*100)"+
    "\n 3 - converter para DECIMETROS. (*10)"+
    "\n 4 - converter para DECAMETROS. (/10)"+
    "\n 5 - converter para HECTOMETROS. (/100)"+
    "\n 6 - converter para QUILOMETROS. (/1000)"
  ).trim();

  console.log("Before while - opt value: '"+opt+ "' typeof opt: "+typeof(opt));

  while ((isNaN(opt)) || Number(opt) <= 0 || Number(opt) >= 7 || opt.length === 0) {
    
    console.log("Inside while - opt value: '"+opt+ "' typeof opt: "+typeof(opt));
    
    selection = prompt("OPÇÃO INSERIDA É INVALIDA."+
      "\nSelecione uma opção de medida para qual o valor deverá ser convertido:"+
      "\n 1 - converter para MILIMETROS. (*1000)"+
      "\n 2 - converter para CENTIMETROS. (*100)"+
      "\n 3 - converter para DECIMETROS. (*10)"+
      "\n 4 - converter para DECAMETROS. (/10)"+
      "\n 5 - converter para HECTOMETROS. (/100)"+
      "\n 6 - converter para QUILOMETROS. (/1000)"
    );
  }

  return Number(opt);
}

function measureConversor(value, selection){
let convertedValueMessage;

  switch (Number(selection)) {
    case 1:
      convertedValueMessage = value * 1000 +" milimetros";
      console.log("MILIMETROS selecionado (* 1000)");
      break;
    case 2:
      convertedValueMessage = value * 100 +" centimetros";
      console.log("CENTIMETROS selecionado (* 100)");
      break;
    case 3:
      convertedValueMessage = value * 10 +" decimetros";
      console.log("DECIMETROS selecionado (* 10)");
      break;
    case 4:
      convertedValueMessage = value / 10 +" decametros";
      console.log("DECAMETROS selecionado (/ 10)");
      break;
    case 5:
      convertedValueMessage = value / 100 +" hecmetros";
      console.log("HECTOMETROS selecionado (/ 100)");
      break;
    case 6:
      convertedValueMessage = value / 1000 +" quilometros";
      console.log("QUILOMETROS selecionado (/ 1000)");
      break;
  }

  console.log("Value :"+ value+". Converted value: "+convertedValueMessage);

  return convertedValueMessage;
}

console.log("JS carregado com sucesso.");
