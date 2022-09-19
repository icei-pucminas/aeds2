import java.util.*;
import java.io.*;

class q2 {

    static String lista(String lista) {
        String listaFinal;

        for(int i = 0; i < lista.length; i++)
        {
            String produto = lista.su

        }

        return listaFinal;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] compras = new String[1000];
        int totListas = sc.nextInt();

        for (int i = 0; i < totListas; i++) {
            while (sc.hasNext()) {
                compras[i] = sc.next();

            }

            System.out.println(lista(compras[i]));
            sc.nextLine();

        }

    }
}