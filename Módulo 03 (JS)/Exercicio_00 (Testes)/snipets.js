console.log("Executando JS Snipets...");

//-------------JS Snipets------------->

//---Inversor de strings--->

//O codigo a seguir inverte os valores de uma palava em uma string.
//Bugproof a não ser que a string contenha uma virgula, que será removida da string invertida...

/*let string = "text";
  console.log("string: "+string);
  let splitedString = string.split(); // resulta em um objeto key value com as letras da string.

  console.log("splitedString keys: " + Object.keys(splitedString));
  console.log("splitedString values: " + Object.values(splitedString));

  let reverseString = Object.values(splitedString).reverse().toString().replaceAll(",", "");
  console.log("reverseString: "+reverseString);*/

//---Para remover pontuações, espaços e acentuação de strings--->

/*str.normalize("NFD").replace(/\p{Diacritic}/gu, "");
  str.normalize("NFD").replace(/[\u0300-\u036f]/g, "");
  str.replace(/[\s.,\/#!$%\^&\*;:{}=\-_`~()]/g,"");*/

//---Snipet de testes para identificador de palindromos--->

/*let clnInpt = "Ótimo, só eu, que os omito.";
    console.log(clnInpt);
    clnInpt = clnInpt.toLowerCase();
    console.log(clnInpt);
    clnInpt = clnInpt.replace(/[\s.,\/#!$%\^&\*;:{}=\-_`~()]/g,"");
    console.log(clnInpt);
    clnInpt = clnInpt.normalize("NFD");
    console.log(clnInpt);
    clnInpt = clnInpt.replace(/\p{Diacritic}/gu, "");
    console.log(clnInpt);*/

//---Para remover multiplos espaços brancos e normalizar e capitalizar primeira letra de cada palavra da string--->

/*let nameString = "  5 &*roger-  ,   b'aggio.   j s  dEVELOPER";
  console.log("Original string: '" + nameString + "'");
  nameString = nameString.replace(/[.,\/#!$%\^&\*;:{}=\-_`~()]/g, "");
  console.log("Non-alphanumeric removed: '" + nameString + "'");
  nameString = nameString.replace(/\s+/g, " ");
  console.log("Duplicated spaces removed: '" + nameString + "'");
  nameString = nameString.trimStart();
  console.log("Leading spaces removed: '" + nameString + "'");
  nameString = nameString.trimEnd();
  console.log("Trailing spaces removed: '" + nameString + "'");
  nameString = nameString.toLowerCase();
  console.log("All string to lower case: '" + nameString + "'");
  nameString = nameString
    .split(" ")
    .map((word) => word.charAt(0).toUpperCase() + word.substring(1))
    .join(" ");
  console.log("Capitalized first letters: '" + nameString + "'");*/

//---Para embaralhar aleatoriamente itens de um array de strings--->

/*var cardList = [
  "A ♦",
  "A ♠",
  "A ♥",
  "A ♣",
  "2 ♦",
  "2 ♠",
  "2 ♥",
  "2 ♣",
  "3 ♦",
  "3 ♠",
  "3 ♥",
  "3 ♣",
  "4 ♦",
  "4 ♠",
  "4 ♥",
  "4 ♣",
];
arrayShuffle(cardList);
console.log(cardList);

function arrayShuffle(array) {
  let currentIndex = array.length, randomIndex;

  //enquanto houver itens para embaralhar.
  while (currentIndex > 0) {
    //seleciona um elemento ainda restante.
    randomIndex = Math.floor(Math.random() * currentIndex);
    currentIndex--;

    // e troca de lugar com o elemento atual.
    [array[currentIndex], array[randomIndex]] = [array[randomIndex], array[currentIndex],];
  }

  return array;
}*/

console.log("JS Snipets executado com sucesso.");
