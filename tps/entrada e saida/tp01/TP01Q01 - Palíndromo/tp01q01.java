
/*
 * Palíndromo - Crie um método iterativo que recebe uma string 
 * como parâmetro e retorna true se essa ́e um “Palíndromo”. 
 * Na saída padrão, para cada linha de entrada, escreva uma linha
 * de saída com SIM/NÃO indicando se a linha ́e um palíndromo. 
 * Destaca-se que uma linha de entrada pode ter caracteres não letras.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class tp01q01 {
    public static boolean isPalindrome(String sentence) {
        /*
         * A boolean function that calculates if a 
         * sentence is a palindrome or not
         */

        String invertedSentence = "";

        for (int i = sentence.length() - 1; i >= 0; i--) {
            char letter = sentence.charAt(i);
            // System.out.print(letter);
            invertedSentence += letter;
        }
        // System.out.print(invertedSentence + '\n');

        return invertedSentence.equals(sentence);
    }

    public static void main(String[] args) {
        /*
         * Main fuction that calls isPalindrome function,
         * and returns "SIM" if the sentence sent is a palindrome.
         */

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) { 
                if ("FIM".equals(line)) { 
                    break;
                }
                //System.out.println(line); 
                System.out.println(((isPalindrome(line)) ? "SIM" : "NAO"));
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler a entrada: " + e.getMessage());
        }

    }
}