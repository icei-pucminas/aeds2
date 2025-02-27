
import java.util.Random;

/*
 * Alteração Aleatória - Crie um método iterativo que recebe
 * uma string, sorteia duas letras minúsculas aleatórias 
 * (código ASCII ≥ 'a' e ≤ 'z'), substitui todas as ocorrências
 * da primeira letra na string pela segunda e retorna a string 
 * com as alterações efetuadas. Na saída padrão, para cada linha
 * de entrada, execute o método desenvolvido nesta questão e mostre
 * a string retornada como uma linha de saída. Abaixo, observamos 
 * um exemplo de entrada supondo que para a primeira linha as letras 
 * sorteadas foram 'a' e 'q'. Para a segunda linha, foram 'e' e 'k'.
 * __________________________________________________________________________
 * Exemplo de Entrada:	               |Exemplo de Saída:
 * o rato roeu a roupa do rei de roma  |o rqto roeu q roupq do rei de romq
 * e qwe qwe qwe ewq ewq ewq	       |k qwk qwk qwk kwq kwq kwq
 *           FIM	                   |                FIM
 * ____________________________________|_____________________________________
 * A classe Random do Java gera números (ou letras) aleatórios e o 
 * exemplo abaixo mostra uma letra minúscula na tela. Em especial, 
 * destacamos que: seed é a semente para geração de números aleatórios;
 * nesta questão, por causa da correção automática, a seed será quatro;
 * a disciplina de Estatística e Probabilidade faz uma discussão sobre
 * "aleatório". code example bellow:
 *  Random gerador = new Random();
 *  gerador.setSeed(4);
 *  System.out.println((char)('a' + (Math.abs(gerador.nextInt()) % 26)));
 */

public class tp01q04 {
    public static String randomAlterator(String sentence, Random generator) {
        /*
         * A String function that takes a sentence and
         * randomizer it, using two random letters made 
         * by the random method. If it sees the first 
         * drawn letter in the sentece, it changes for
         * the second one. 
         */
        
        char firstDrawn = (char) ('a' + (Math.abs(generator.nextInt()) % 26));
        //char firstDrawn = 'e';
        char secondDrawn = (char) ('a' + (Math.abs(generator.nextInt()) % 26));
        //char secondDrawn = 'f';

        //MyIO.println(firstDrawn);
        //MyIO.println(secondDrawn);
        
        String changedSentence = "";

        for (int index = 0; index < sentence.length(); index++) {
            if (sentence.charAt(index) == firstDrawn) {
                changedSentence += secondDrawn;
            } else {
                changedSentence += sentence.charAt(index);
            }
        }

        //MyIO.println("Sentença original: "+ sentence);
        //MyIO.println("Sentença alterada: "+ changedSentence);

        return changedSentence;
    }

    public static void main(String[] args) {
        /*
         * A Main function that reads a sentence
         * and calls the random alterator method
         * for it. In the final, it prints the
         * changed sentence.
         */

        Random generator = new Random();
        generator.setSeed(4);

        String line = MyIO.readLine();

        while (!"FIM".equals(line)) {
            MyIO.println(randomAlterator(line, generator));

            line = MyIO.readLine();
        }
    }
}