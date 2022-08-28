import java.util.Random;

public class TP1Q04 {

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'); // verifica se o
                                                                                                                        // pub.in chegou ao
                                                                                                                        // FIM
    }

    public static String trocarChar(String s) {                 //metodo que realiza a troca de letras
        Random gerador = new Random();
        gerador.setSeed(4);

        char[] stringNova = s.toCharArray();                //conversao de string para char[]

        char letra1 = (char) (96 + Math.abs(gerador.nextInt()) % 26);               //geração de duas letras aleatórias
        char letra2 = (char) (96 + Math.abs(gerador.nextInt()) % 26);

        for (int i = 0; i < s.length(); i++) {                  //loop que percorre o char[], verificando se a primeira ou segunda letra existem
            if (stringNova[i] == letra1)                        //se sim, são efetuadas as trocas
                stringNova[i] = letra2;

            else if (stringNova[i] == letra2)
                stringNova[i] = letra1;

        }

        return stringNova.toString();                       //return com o char[] modificado convertido em string
    }

    public static void main(String[] args) {

        String[] entrada = new String[1000];
        int numEntrada = 0;

        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsidera a ultima linha contendo a palavra FIM

        for (int i = 0; i < numEntrada; i++)    //saida de dados com os resultados da função para cada entrada diferente
        {
            MyIO.println(entrada[i]);
        }

    }
}
