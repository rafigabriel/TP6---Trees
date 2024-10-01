
import java.util.*;
public class Hash {
    public static void main(String[] args) {
        System.out.println("============================HASHMAP===================================");
        //TIPO 1 DE HASH: HASMAP
        HashMap<String, Integer> map = new HashMap<>();
        //Adicionando as chaves e seus respectivos valores.
        map.put("Celular", 500);
        map.put("Tablet", 800);
        map.put("Computador", 1200);

        //Acessando uma chave qualquer dentro do hashmap:
        System.out.println("Preço do tablet: " + map.get("Tablet"));

        //Acessando todas as chaves dentro do hashmap:

        for (String key : map.keySet()) {
            System.out.println("Produtos: " + key + " || " + "Valor: " + map.get(key));
        }


        System.out.println("============================LINKEDHASHMAP===================================");
        //TIPO 2 DE HASH: LINKEDHASHMAP
        LinkedHashMap<String, Integer> products = new LinkedHashMap<>();
        products.put("Carro", 10000);
        products.put("Moto", 5000);
        products.put("Bicicleta", 200);

        for (String key : products.keySet()) {
            System.out.println("Veiculos: " + key + " || " + "Valor: " + products.get(key));
        }

        //A principal diferença entre HashMap e LinkedHashMap é: 
        //No LinkedHashMap, a ordem de inserção importa, enquanto no HashMap não importa tanto.
        //No LinkedHashMap, além de usar uma estrutura de tabela hash, também usa uma lista duplamente encadeada.
        //No LinkedHashMap, o uso da memória é maior pois é necessário manter a ordem das inserções.


        System.out.println("============================HASHSET===================================");
        //TIPO 3 DE HASH: HASHSET
        // No HashSet, não é inserido elementos duplicados, não mantém a ordem de inserção, é melhor pra verificar rapidamente se um elemento existe em um conjunto.
        //Permite apenas a inserção de um elemento.

        HashSet<String> alunos = new HashSet<>();
        alunos.add("Rafi");
        alunos.add("Pedro");
        alunos.add("Paulo");

        System.out.println("O aluno 'Rafi' faz parte da turma? " + alunos.contains("Rafi"));

        alunos.remove("Paulo");

        System.out.println("Quantidade de alunos na sala: " + alunos.size());

        System.out.println("Alunos na sala: ");
        for (String aluno : alunos) {
            System.out.println(aluno);
        }


        //TIPO 4 DE HASH: HASHTABLE
        System.out.println("============================HASHTABLE===================================");
        //A maior diferença entre o hashTable e HashMap, é o fato de que o HashTable é sincronizado e o Map não, e o HashTable não permite valores null. 
        Hashtable<Node, Integer> hashTable = new Hashtable<>();
        Node dois = new Node(2);
        Node tres = new Node(3);
        hashTable.put(dois, 2);
        hashTable.put(tres, 3);
        System.out.println(hashTable.get(tres));
        System.out.println(hashTable.isEmpty());
        System.out.println(hashTable.contains(2));
        hashTable.remove(dois);
        System.out.println(hashTable.contains(2));



    }
}
