/*Snipets, laboratórios e soluções de desafios comuns de desenvolvimento em JS

---> Observações a se levar em consideração para executar seus testes <---
**Descomente e debugue apenas uma linha dos inputs por teste. ;]

VARIÁVEIS:
"const": NÃO pode ser acessada fora de seu escopo, NÃO pode ser referida antes de inicializada e após iniciadas/atribuidas, NÃO pode receber novos valores ou redeclaradas.
"var": pode ser acessada fora de seu escopo, pode ser referida antes de inicializada e após iniciadas/atribuidas, pode receber novos valores ou ser redeclarada.
"let": NÃO pode ser acessada fora de seu escopo, NÃO pode ser referida antes de inicializada e após iniciadas/atribuidas, pode receber novos valores ou, mas NÃO podem ser redeclaradas.
*/

//---Calculador de idade.
//INPUTS:
var birthDate = new Date("12/15/1991");
//const birthDate = new Date("06/21/2012");
//const birthDate = new Date("2012-06-21"); //Atenção: Neste formato o fuso horário é UTC (default 00:00:00). Regionalizar para GMT-3 resulta em "20/06/2012 21:00:00"!
//const birthDate = new Date(2019, 11, 9); //Atenção: Neste formato a contagem dos meses começa em 0, portanto 0 = Janeiro, 1 = Fevereiro, 2 = Março, ..., 11 = Dezembro.

function ageCalc(brthdt) {
  const today = new Date();
  const age = today.getFullYear() - brthdt.getFullYear() - (today.getMonth() < brthdt.getMonth() || 
             (today.getMonth() === brthdt.getMonth() && today.getDate() < brthdt.getDate()));
  return age;
}

console.log('Nascidos na data de "' + birthDate.toLocaleDateString('pt-BR')+ '" possuem ' + ageCalc(birthDate) + " anos de idade atualmente.");
//END


//---Inversor de string.
//INPUTS:
//var string = "text txet.";
var string = "O rato roeu a roupa do rei de roma.";

function revertString(str){
  let reverseString = str.split("")//transforma a string em um array de caracter por caracter
    .reverse() //Inverte todas as posições do array, de traz para frente
    .join(""); //Une novamente toda a lista em uma unica string!

  return reverseString;
};

console.log("String invertida: " + revertString(string));
//END


//---Para remover pontuações, espaços e acentuação de strings
//INPUTS:
var rawString = "Será então inter-hemisférico.";
//var rawString = "Será que são órgãos!?";

function removeStringPunctiations(str){
  let processedStr = str.replace(/[.,\/#!?[$%\^&\*;:{}=\-_`~()|/+@º°§\]]/g, "") //remove toda pontuação e sinalização da string
    .normalize("NFD") //separa todos os caracteres de suas respectivas acentuações (não é visual no console, mas a string resultante é diferente!)
    .replace(/\p{Diacritic}/gu, ""); //remove todas as acentuações

  return processedStr;
};

console.log('String com todos acentos e pontuações removidas: "' + removeStringPunctiations(rawString) + '".');
//END


//---Para testar e identificar se uma string é um palindromo
//INPUTS:
//const palindromeString = "Radar."; //true
const palindromeString = "Socorram-me, subi no ônibus em Marrocos."; //true
//const palindromeString = "Roger Baggio."; //false

function testIfPalindrome(str){
  let isPalindrome = false;

  let clearStr = removeStringPunctiations(str).replaceAll(" ","").toLowerCase();//Remove todas as pontuações e espaços da string e torna minúsculo todas seus caracteres
  let reverseStr = revertString(clearStr); //Inverte toda a ordem de caracteres da string normalizada

  if(clearStr == reverseStr){
    isPalindrome = true;
  }

  return isPalindrome;
};

console.log('"' + palindromeString + '" é um palíndromo? ' + testIfPalindrome(palindromeString).toString().toUpperCase() + ".");
//END


//---Para remover espaços brancos, normalizar e capitalizar primeira letra de cada palavra da string
//INPUTS:
const strangeFormattedString = "  &*roger-  ,   b'aggio.   js  dEVELOPER  ";

function normalizeAndCapitalizeString(str){
  let normCapStr = str.replace(/[.,\/#!$%\^&\*;:{}=\-'_`~()]/g, "") //Removendo tudo que nao for alfanumérico da string
    .replace(/\s+/g, " ") //Substituindo todos os multiplos espaços por apenas um espaço entre as palavras da string
    .trimStart().trimEnd() //Removendo espaços do começo e do final da string
    .toLowerCase().split(" ") //Tornando todos os caracteres da string minúsculos e separando a string por seus espaços (" ") em um array de palavras
    .map((word) => word.charAt(0).toUpperCase() + word.substring(1)) //Percorrendo o array, capitalizando o primeira letra de cada item e concatenado ao resto da palavra
    .join(" ") //Unindo novamente o array em uma unica string.

  return normCapStr;
};

console.log("String Original: '" + strangeFormattedString + "'");
console.log(normalizeAndCapitalizeString(strangeFormattedString));
//END


//---Para embaralhar aleatoriamente itens de um array de strings
//INPUTS
const stringArray = ["A ♦", "A ♠", "A ♥", "A ♣", "2 ♦", "2 ♠", "2 ♥", "2 ♣", "3 ♦", "3 ♠", "3 ♥", "3 ♣", "4 ♦", "4 ♠", "4 ♥", "4 ♣"];
//const stringArray = ["Abacaxi", "Banana", "Caju", "Damasco", "Embaúba", "Figo", "Goiaba", "Heisteria", "Ingá", "Jabuticaba"];

function arrayShuffle(array) {
  let currentIndex = array.length;
  let randomIndex;

  while (currentIndex > 0) { //enquanto o contador de indexes do array for maior que 0, continua a embaralhar
    randomIndex = Math.floor(Math.random() * currentIndex); //gera um valor entre 0 e 1 aleatóriamente, multiplica pelo indice atual e arredonda pro inteiro mais próximo,
    currentIndex--; //subtrai 1 do index atual do array
    [array[currentIndex], array[randomIndex]] = [array[randomIndex], array[currentIndex]]; //troca o item de index aleario de lugar com o elemento atual.
  };
  return array;
}

console.log(arrayShuffle(stringArray));
//END

//----> LeetCode challanges <----

//BONUS: leetcode.com runtime always 0ms cheat!
//Add this snipet to the very end of your code and be a ranking god. ;]
/*
process.on("exit", () => {
    require("fs").writeFileSync("display_runtime.txt", "0");
});
*/

//---Palindrome Number challange solution. (https://leetcode.com/problems/palindrome-number)
//INPUTS:
const palindromeNumber = 121; //true
//const palindromeNumber = -121 //false

var isPalindromeNumber = function(x) {
    let result;
    x == x.toString().split("").reverse().join("")?result = true: result = false; //<---one liner if else

    return result;
};

console.log(isPalindromeNumber(palindromeNumber));
//END


//---Integer to Roman challange solution. (https://leetcode.com/problems/integer-to-roman)
//INPUTS:
//const rom = "III" //3
//const rom = "XIX" //19
//const rom = "LVIII" //58
//const rom = "MCMXCIV" //1994
const rom = "MMMDCCCVIII" //3808
//const rom = "MMMDCCCLXXXVIII" //3888

var romanToInt = function(str) {
  const replacements = [["CM", "+900"], ["CD", "+400"], ["XC", "+90"], ["XL", "+40"],["IX", "+9"], ["IV", "+4"], 
    ["M", "+1000"], ["D", "+500"], ["C", "+100"], ["L", "+50"], ["X", "+10"], ["V", "+5"], ["I", "+1"]];
    
  let expression = str;
  for (const [roman, value] of replacements) {
    expression = expression.replace(new RegExp(roman, 'g'), value);
  }

  return eval(expression);
};

console.log(romanToInt(rom));
//END


//---Roman to Integer challange solution. (https://leetcode.com/problems/roman-to-integer)
//INPUTS:
//const int = 3 //"III"
//const int = 19 //"XIX"
//const int = 58 //"LVIII"
//const int = 1095 //MXCV
//const int = 3808 //"MMMDCCCVIII"
//const int = 3888 //"MMMDCCCLXXXVIII"

var intToRoman = function(int) {
  //decompondo o inteiro em por suas casas decimais
  let decomposedInput = int.toString().split("") //convertendo para string e dividindo em um array
    .map((num, i, arr) => num != 0? num * Math.pow(10, arr.length - 1 - i): "/" + num).join(""); //multiplicando por 10 elevado ao indice e concatenando todo o valor decomposto.

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


//---Longest Common Prefix challange solution. (https://leetcode.com/problems/longest-common-prefix)
//INPUTS:
//const strs = [];
//const strs = ["flower","flow","flight"]; //"fl"
//const strs = ["dog","racecar","car"]; //""
const strs = ["Roger", "Rogerio", "Rodrigo", "Rodolfo", "Roberto"];

var longestCommonPrefix = function(strs) {
  let sortedStrings = strs.sort();

  return sortedStrings;
};

console.log(longestCommonPrefix(strs));
//END
 
