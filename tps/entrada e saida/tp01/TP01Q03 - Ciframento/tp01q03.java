/*
 * Ciframento de César - O Imperador Júlio César foi um dos 
 * principais nomes do Império Romano. Entre suas contribuições,
 * temos um algoritmo de criptografia chamado “Ciframento de César”.
 * Segundo os historiadores, César utilizava esse algoritmo 
 * para criptografar as mensagens que enviava aos seus generais 
 * durante as batalhas. A ideia básica  ́e um simples deslocamento
 * de caracteres. Assim, por exemplo, se a chave utilizada para 
 * criptografar as mensagens for 3, todas as ocorrências do 
 * caractere ’a’ são substituídas pelo caractere ’d’, as do ’b’ 
 * por ’e’, e assim sucessivamente. Crie um método iterativo que 
 * recebe uma string como parâmetro e retorna outra contendo a entrada 
 * de forma cifrada. Neste exercício, suponha a chave de ciframento três.
 * Na saída padrão, para cada linha de entrada, escreva uma linha com a 
 * mensagem criptografada.
 */

public class tp01q03 {
    public static String caesarsCipher(String sentence, int key) {
        /*
         * A String function that takes a key and a sentence
         * and applies a Caesar's Cipher on it
         */

        String chipheredSentence = "";

        for (int index = 0; index < sentence.length(); index++) {
            int letterIntegerValue = sentence.charAt(index) + key;
            char letter = (char) letterIntegerValue;

            chipheredSentence += letter;
        }

        return chipheredSentence;
    }

    public static void main(String[] args) {
        /*
         * A Main function that reads line per line
         * from a default input and calls the cipher 
         * method to apply the cipher on it.
         * Also prints the ciphered sentence.
         */

        int key = 3;

        String line = MyIO.readLine();

        while (!line.equals("FIM")) {
            MyIO.println(caesarsCipher(line, key));

            line = MyIO.readLine();
        }
    }
}