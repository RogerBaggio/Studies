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

console.log("JS Snipets executado com sucesso.");
