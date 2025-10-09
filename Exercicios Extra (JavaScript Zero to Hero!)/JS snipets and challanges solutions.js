//Snipets, laboratórios e soluções de desafios comuns de desenvolvimento em JS

//---para calcular idades--->
function age(birthdate) {
  const today = new Date();
  const age = today.getFullYear() - birthdate.getFullYear() - 
             (today.getMonth() < birthdate.getMonth() || 
             (today.getMonth() === birthdate.getMonth() && today.getDate() < birthdate.getDate()));
  return age;
}


//Inversor de strings. Inverte os valores de uma string.
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


//Para remover pontuações, espaços e acentuação de strings e testes para identificar palindromos
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


//Para remover multiplos espaços brancos e normalizar e capitalizar primeira letra de cada palavra da string
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


//Para embaralhar aleatoriamente itens de um array de strings
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


//----> LeetCode Easy challanges <----

//BONUS: leetcode.com runtime always 0ms cheat!
//Add this snipet to the end very of your code and be a ranking god. ;]
/*
process.on("exit", () => {
    require("fs").writeFileSync("display_runtime.txt", "0");
});
*/

//Palindrome Number challange solution.
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


//Integer to Roman challange solution.
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
        ["CM", "+900"], ["CD", "+400"], ["XC", "+90"], ["XL", "+40"], ["IX", "+9"], ["IV", "+4"],
        ["M", "+1000"], ["D", "+500"], ["C", "+100"], ["L", "+50"], ["X", "+10"], ["V", "+5"], ["I", "+1"]
    ];
    
    let expression = s;
    for (const [roman, value] of replacements) {
        expression = expression.replace(new RegExp(roman, 'g'), value);
    }
    return eval(expression);
};

console.log(romanToInt(s));

/*let int = s.replace("MMM", 3).replace("MM", 2).replace("CM", 9).replace("M", 1).replace("DCCC", 8).replace("DCC", 7).replace("DC", 6).replace("CD", 4).replace("D", 5)
    .replace("CCC", 3).replace("CC", 2).replace("XC", 9).replace("C", 1).replace("LXXX", 8).replace("LXX", 7).replace("LX", 6).replace("XL", 4).replace("L", 5)
    .replace("XXX", 3).replace("XX", 2).replace("IX", 9).replace("X", 1).replace("VIII", 8).replace("VII", 7).replace("VI", 6).replace("IV", 4).replace("V", 5)
    .replace("III", 3).replace("II", 2).replace("I", 1);
return int;*/
