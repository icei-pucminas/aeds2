/**
 * Principal para Arvore Binaria de Pesquisa
 * @author Max do Val Machado
 */
import java.util.*;

public class Principal2 {
    public static void main(String[] args) throws Exception {
        ArvoreBinaria a = new ArvoreBinaria();

        Random gerador = new Random();
        gerador.setSeed(0);
        for(int i = 1; i <= 100000; i++){
            int valor;
            do {
                valor = Math.abs(gerador.nextInt());
            } while (a.pesquisar(valor) == true);

            a.inserir(valor);

            if(i % 1000 == 0){
                double log2 = (Math.log(i) / Math.log(2));
                log2 *= 1.39;
                System.out.println("Número de nós = " + i + " --- log(i,2) = " + log2 + " --- h = " + a.getAltura());
            }
        }
    }
}
