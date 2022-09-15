import java.util.*;

class PROVA1Q01 {
    static int numeroSolitario(int[] num) {
        int numSol = 0;
        int numAnalisado;
        int cont = 0;

        for (int i = 0; i < num.length; i++) {
            numAnalisado = num[i];
            for (int j = 0; j < num.length; j++) {
                if (num[j] == numAnalisado) {
                    cont++;

                }

            }

            if ((cont % 2) == 1) {
                numSol = num[i];
                break;
            }
        }

        return numSol;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totNum;
        int numeros[];

        while (sc.hasNext() == true) {
            totNum = sc.nextInt();

            if (totNum == 0)
                break;

            numeros = new int[totNum];
            for (int i = 0; i < totNum; i++) {
                numeros[i] = sc.nextInt();

            }

            System.out.println(numeroSolitario(numeros));

        }

        sc.close();

    }

}
