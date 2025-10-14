//Estrutura básica e parametros da função array.map():
/*
array.map((elemento, índice, arrayOriginal) => {
    <sua logica de transformação aqui>
    return novoElemento;
})
*/

//---Uso simples de map()
const numbers = [2, 4, 6, 8, 10];

const doubles = numbers.map(number => number*number);
console.log(doubles); //resultado: [4, 16, 36, 64, 100]
//END


//---map() com console em cada iteração 
//(é necessário utilizar 'return' para atribuir o retorno da função quando {} é utilizado ou o retorno será 'undefined')
const squares = numbers.map((number, index) => {
    const result = number * number;
    console.log(`Iteração ${index}: ${number}² = ${result}`);
    return result;
});
console.log(squares); //resultado: [4, 16, 36, 64, 100]
//END


//---Utilizando map() para transformar "orders" em lista de "costumers" com datas formatadas
const orders = [
    {id: "13", name: "Roger Baggio",     product: ["Produto tipo 01"],                    value: 10.00, orderDate:"Wed Sep 03 2025 12:23:43", status:"Enviado"},
    {id: "05", name: "Caroline Goltara", product: ["Produto tipo 02", "Produto tipo 04"], value: 60.00, orderDate:"Mon Aug 18 2025 18:44:25", status:"Concluído"},
    {id: "23", name: "Vivi",             product: ["Produto tipo 01"],                    value: 10.00, orderDate:"Sun Sep 28 2025 07:32:34", status:"Pendente"},
    {id: "33", name: "Nena",             product: ["Produto tipo 01", "Produto tipo 04"], value: 50.00, orderDate:"Sat Oct 04 2025 15:21:41", status:"Pendente"},
    {id: "01", name: "Jojo Caroline",    product: ["Produto tipo 02", "Produto tipo 03"], value: 50.00, orderDate:"Fri Jul 11 2025 11:33:11", status:"Concluído"},
] //lista de objetos "orders"

const costumers = orders.map(order => ({
    costumer: order.name,
    date: new Date(order.orderDate).toLocaleDateString("pt-BR",{
        day: "numeric",
        month: "long",
        year: "numeric"
    })
}));
console.log(costumers); //Log simples 
//(Possível que alguns consoles exibam apenas "[{…}, {…}, {…}, {…}, {…}]" sem a possibilidade de expandir cada objeto para visualizarmos seu conteudo)
//END


//---utilizando map() para exibir log dos objetos da lista "costumers" extraida de "orders"!
const logs = costumers.map((obj, index) => {
    const log = obj[index];
    console.log(`Índice ${index} - Consumidor: ${obj.costumer}. Data do pedido: ${obj.date}.`)
});


//---Utilizando map() para resolver o problema two sum (https://leetcode.com/problems/two-sum)
//(Solução mais eficiente que 2 laços de for aninhados)
const numbersList = [0, 2, 5, 7, 8];
const target = 9;

const twoSum = sumOfTwo(numbersList,target);

function sumOfTwo(list, value){
    let result = new Map();
    
    for(let i = 0; i < list.length; i++){
        let difference =  value - list[i];
        if (result.has(difference)){
            return [result.get(difference), i];
        }
        result.set(list[i], i);
    }
    return result;
};
console.log(twoSum); //Resultado esperado [1, 3] (indices dos numeros 2 e 7 na lista, soma resultante é o "target", 9);
//END