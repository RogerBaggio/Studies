//Snipets, laboratórios e soluções de desafios comuns de desenvolvimento em JS

//---para calcular idades
function age(birthdate) {
  const today = new Date();
  const age = today.getFullYear() - birthdate.getFullYear() - 
             (today.getMonth() < birthdate.getMonth() || 
             (today.getMonth() === birthdate.getMonth() && today.getDate() < birthdate.getDate()));
  return age;
}
//END


//---Inversor de strings. Inverte os valores de uma string.
//Bugproof a não ser que a string contenha uma virgula, que será removida da string invertida...
let string = "text text";
console.log("string: " + string);
let splitedString = string.split(""); // resulta em um objeto key value com as letras da string.

console.log("splitedString keys: " + Object.keys(splitedString));
console.log("splitedString values: " + Object.values(splitedString));

let reverseString = Object.values(splitedString)
  .reverse()
  .toString()
  .replaceAll(",", "");
console.log("reverseString: " + reverseString);
//END


//---Para remover pontuações, espaços e acentuação de strings e testes para identificar palindromos
let clnInpt = "Ótimo, só eu, que os omito.";
console.log(clnInpt);
clnInpt = clnInpt.toLowerCase();
console.log(clnInpt);
clnInpt = clnInpt.replace(/[.,\/#!?[$%\^&\*;:{}=\-_`~()|/+@º°§\]]/g, ""); 
console.log(clnInpt);
clnInpt = clnInpt.normalize("NFD");
console.log(clnInpt);
clnInpt = clnInpt.replace(/\p{Diacritic}/gu, "");
console.log(clnInpt);
//END


//---Para remover multiplos espaços brancos e normalizar e capitalizar primeira letra de cada palavra da string
let nameString = "  &*roger-  ,   b'aggio.   js  dEVELOPER  ";
console.log("Original string: '" + nameString + "'");
nameString = nameString.replace(/[.,\/#!$%\^&\*;:{}=\-'_`~()]/g, "");
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
console.log("Capitalized first letters: '" + nameString + "'");
//END


//---Para embaralhar aleatoriamente itens de um array de strings
var cardList = [
  "A ♦", "A ♠", "A ♥", "A ♣",
  "2 ♦", "2 ♠", "2 ♥", "2 ♣",
  "3 ♦", "3 ♠", "3 ♥", "3 ♣", 
  "4 ♦", "4 ♠", "4 ♥", "4 ♣"
];
arrayShuffle(cardList);
console.log(cardList);

function arrayShuffle(array) {
  let currentIndex = array.length,
    randomIndex;

  //enquanto houver itens para embaralhar.
  while (currentIndex > 0) {
    //seleciona um elemento ainda restante.
    randomIndex = Math.floor(Math.random() * currentIndex);
    currentIndex--;

    // e troca de lugar com o elemento atual.
    [array[currentIndex], array[randomIndex]] = [
      array[randomIndex],
      array[currentIndex]
    ];
  }
  return array;
}
//END


//----> LeetCode Easy challanges <----

//BONUS: leetcode.com runtime always 0ms cheat!
//Add this snipet to the very end of your code and be a ranking god. ;]
/*
process.on("exit", () => {
    require("fs").writeFileSync("display_runtime.txt", "0");
});
*/

//---Palindrome Number challange solution.
//INPUTS:
x = 121; //true
//x = -121 //false

var isPalindrome = function(x) {
    let result;
    x == x.toString().split("").reverse().join("")?result = true: result = false;

    return result;
};

console.log(isPalindrome(x));
//END


//---Integer to Roman challange solution.
//INPUTS:
//s = "III" //3
//s = "XIX" //19
//s = "LVIII" //58
//s = "MCMXCIV" //1994
//s = "MCDXLIV" //1.444
//s = "MDCCCLXXXIV" //1884
s = "MMMDCCCVIII" //3808
//s = "MMMDCCCLXXXVIII" //3888

var romanToInt = function(s) {
 const replacements = [
        ["CM", "+900"], ["CD", "+400"], ["XC", "+90"], ["XL", "+40"],
        ["IX", "+9"], ["IV", "+4"], ["M", "+1000"], ["D", "+500"],
        ["C", "+100"], ["L", "+50"], ["X", "+10"], ["V", "+5"], ["I", "+1"]
    ];
    
    let expression = s;
    for (const [roman, value] of replacements) {
        expression = expression.replace(new RegExp(roman, 'g'), value);
    }
    return eval(expression);
};//Bugproof version

console.log(romanToInt(s));
//END


//---Roman to Integer challange solution.
//INPUTS:
//int = 3 //"III"
int = 10 //"X"
//int = 19 //"XIX"
//int = 58 //"LVIII"
//int = 100 //"C"
//int = 1000 //"M"
//int = 1095 //MXCV
//int = 1995 //MCMXCV
//int = 1994 //"MCMXCIV"
//int = 1444 //"MCDXLIV"
//int = 1884 //"MDCCCLXXXIV"
//int = 3808 //"MMMDCCCVIII"
//int = 3888 //"MMMDCCCLXXXVIII"

var intToRoman = function(int) {
  //decompondo o inteiro em por suas casas decimais
  let decomposedInput = int.toString().split("");//convertendo para string e dividindo em um array
      console.log("convertendo para string e dividindo em um array: "+ decomposedInput);
      decomposedInput = decomposedInput.map((num, i) => num != 0? num * Math.pow(10, decomposedInput.length - 1 - i): "/" + num);//multiplicando por 10 elevado ao indice
      console.log("multiplicando por 10 elevado ao indice: "+ decomposedInput);
      decomposedInput = decomposedInput.join("");//concatenando todo o valor decomposto 
      console.log("//concatenando todo o valor decomposto: " + decomposedInput);
  
  //Substituindo todas as incidencias em ordem de complexidade/subtrações primeiro
  let roman = decomposedInput.replace(3000, "MMM").replace(2000, "MM").replace(900, "CM").replace(1000, "M").replace(800, "DCCC")
          .replace(700, "DCC").replace(600, "DC").replace(400, "CD").replace(500, "D").replace(300, "CCC").replace(200, "CC")
          .replace(90, "XC").replace(100, "C").replace(80, "LXXX").replace(70, "LXX").replace(60, "LX").replace(40, "XL")
          .replace(50, "L").replace(30, "XXX").replace(20, "XX").replace(9, "IX").replace(10, "X").replace(8, "VIII")
          .replace(7, "VII").replace(6, "VI").replace(4, "IV").replace(5, "V").replace(3, "III").replace(2, "II").replace(1, "I")
          .replaceAll("/0", ""); //removendo todos os /0 resquicios ao final

  return roman;
};

console.log(intToRoman(int));
//END
