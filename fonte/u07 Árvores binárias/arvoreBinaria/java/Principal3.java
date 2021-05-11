/**
 * Principal para Arvore Binaria de Pesquisa
 * @author Max do Val Machado
 */
import java.util.*;

public class Principal3 {
   public static void main(String[] args) throws Exception {
      ArvoreBinaria a1 = new ArvoreBinaria();
      ArvoreBinaria a2 = new ArvoreBinaria();

      Random gerador = new Random();
      gerador.setSeed(4);
      for(int i = 1; i <= 100000; i++){
         int valor = Math.abs(gerador.nextInt());
         if(a1.pesquisar(valor) == false){
            a1.inserir(valor);
            a2.inserir(valor);
         }
         if(i % 100 == 0){
            a1.remover(valor);
            a2.remover(valor);
            a1.remover(a1.getRaiz());
            a2.remover(a2.getRaiz());
         }

         if(ArvoreBinaria.igual(a1, a2) == false){
            System.out.println("Árvores diferentes...");
         }

      }
   }
}
