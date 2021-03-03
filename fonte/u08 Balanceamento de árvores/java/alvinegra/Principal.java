import java.util.*;

/**
 * Principal para Arvore Binaria de Pesquisa
 * @author Max do Val Machado
 */
public class Principal {
	public static void main(String[] args) throws Exception {
      Alvinegra arvore = new Alvinegra();

      /*
      arvore.inserir(1);
      arvore.inserir(2);
      arvore.inserir(3);
      arvore.mostrarPre();

      arvore = new Alvinegra();
      arvore.inserir(1);
      arvore.inserir(3);
      arvore.inserir(2);
      arvore.mostrarPre();

      arvore = new Alvinegra();
      arvore.inserir(2);
      arvore.inserir(1);
      arvore.inserir(3);
      arvore.mostrarPre();

      arvore = new Alvinegra();
      arvore.inserir(2);
      arvore.inserir(3);
      arvore.inserir(1);
      arvore.mostrarPre();

      arvore = new Alvinegra();
      arvore.inserir(3);
      arvore.inserir(1);
      arvore.inserir(2);
      arvore.mostrarPre();

      arvore = new Alvinegra();
      arvore.inserir(3);
      arvore.inserir(2);
      arvore.inserir(1);
      arvore.mostrarPre();
      */

      arvore = new Alvinegra();
      arvore.inserir(4);
      arvore.inserir(35);
      arvore.inserir(10);
      arvore.inserir(13);
      arvore.inserir(3);
      arvore.inserir(30);
      arvore.inserir(15);
      arvore.inserir(12);
      arvore.inserir(7);
      arvore.inserir(40);
      arvore.inserir(20);
      arvore.mostrarPre();


      /*
      arvore = new Alvinegra();
      Random gerador = new Random();
      gerador.setSeed(4);
      for(int i = 0; i < 4000; i++){
         int elemento;
         do {
            elemento = ((int)Math.abs(gerador.nextInt())) % 100000;
         } while (arvore.pesquisar(elemento) == true);
         arvore.inserir(elemento);
         arvore.mostrarPre();
      }
      */
	}
}
