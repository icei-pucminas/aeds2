import java.util.*;
/**
 * Lista estatica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class PrincipalListaOrdenada {
   public static void main(String[] args) throws Exception {
		Random gerador = new Random();
      System.out.println("==== LISTA ESTATICA ====");
      ListaOrdenada lista = new ListaOrdenada(1000);

      for(int i = 0; i < 1000; i++){
         lista.inserir(Math.abs(gerador.nextInt()) % 1000);
      }

      System.out.print("Apos insercoes: ");
      lista.mostrar();
      System.out.print("Ordenada: " +  lista.isOrdenado());
   }
}
