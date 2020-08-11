/**
 * Geracao de elementos de um array
 * @author Max do Val Machado
 * @version 2 01/2015
 */

import java.util.*;

class Geracao {
   protected static int[] array;
   protected static int n;


	/**
	 * Construtor.
	 */
   public Geracao(){
      array = new int[100];
      n = array.length;
   }


	/**
	 * Construtor.
	 * @param int tamanho do array de numeros inteiros.
	 */
   public Geracao(int tamanho){
      array = new int[tamanho];
      n = array.length;
   }


	/**
	 * Produz um array ordenado de modo crescente.
	 */
	public static void crescente() {
		for (int i = 0; i < n; i++) {
			array[i] = i;
		}
	}

	/**
	 * Produz um array ordenado de modo decrescente.
	 */
	public static void decrescente() {
		
		for (int i = 0; i < n; i++) {
			array[i] = n - 1 - i;
		}
	}

	/**
	 * Produz um array de numeros aleatorios.
	 */
	public static void aleatorio() {
		Random gerador = new Random();
		
		for (int i = 0; i < n; i++) {
			array[i] = Math.abs(gerador.nextInt()) % 1000; // 0 a 999
		}
	}


	/**
	 * Efetua a leitura dos elementos via entrada padrao.
	 */
	public static void entradaPadrao() {
      n = MyIO.readInt();
      array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = MyIO.readInt();
		}
	}

   public static void entrada(int[] vet){
      n = vet.length;
      array = new int[n];
      for(int i = 0; i < n; i++){
         array[i] = vet[i];
      }
   }


	/**
	 * Mostra os array de um array.
	 * @param int k indica a quantidade de elementos do array a serem mostrados.
	 */
	public static void mostrar(int k) {
		System.out.print("[ ");
		
		for (int i = 0; i < k; i++) {
			System.out.print(array[i] + " ");
		}
		
		System.out.println("] ");
	}


	/**
	 * Mostra os array de um array.
	 */
   public static void mostrar() {
      System.out.print("[ ");

      for (int i = 0; i < n; i++) {
         System.out.print("("+i+")" + array[i] + " ");
      }

      System.out.println("] ");
   }


   /**
    * Troca o conteudo de duas posicoes do array
    * @param i int primeira posicao
    * @param j int segunda posicao
    */
   public static void swap(int i, int j) {
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
   }


   /**
    * Retorna o timestamp atual
    * @return timestamp atual
    */
   public static long now(){
      return new Date().getTime();
   }


   /**
    * Retorna verdadeiro/falso indicando se o array esta ordenado
    * @return boolean indicando se o array esta ordenado
    */
   public static boolean isOrdenado(){
      boolean resp = true;
      for(int i = 1; i < n; i++){
         if(array[i] < array[i-1]){
            i = n;
            resp = false;
         }
      }
      return resp;
   }
}
