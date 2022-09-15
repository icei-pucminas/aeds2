import java.util.Scanner;

class quadroDeMedalhas {

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'); // verifica se o
                                                                                                    // pub.in chegou ao
                                                                                                    // FIM
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String[] entrada = new String[1000];
        int i = -1;
        // leitura e contagem de linhas
        do {
            i++;
            entrada[i] = sc.nextLine();
        } while (!isFim(entrada[i]));
    }
}