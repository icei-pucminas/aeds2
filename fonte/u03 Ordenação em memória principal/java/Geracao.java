/**
 * Geracao de elementos de um array
 * @author Max do Val Machado
 * @version 3 08/2020
 */

import java.util.*;

class Geracao {
   protected int[] array;
   protected int n;


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
	public void crescente() {
		for (int i = 0; i < n; i++) {
			array[i] = i;
		}
	}


	/**
	 * Produz um array ordenado de modo decrescente.
	 */
	public void decrescente() {
		for (int i = 0; i < n; i++) {
			array[i] = n - 1 - i;
		}
	}


	/**
	 * Produz um array com numeros aleatorios.
	 */
	public void aleatorio() {
		Random rand = new Random();
	   crescente();	
		for (int i = 0; i < n; i++) {
         swap(i, Math.abs(rand.nextInt()) % n);
		}
	}


	/**
	 * Efetua a leitura dos elementos via entrada padrao.
	 */
	public void entradaPadrao() {
      n = MyIO.readInt();
      array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = MyIO.readInt();
		}
	}

	/**
	 * Recebe um Efetua a leitura dos elementos via entrada padrao.
	 */
   public void entrada(int[] vet){
      n = vet.length;
      array = new int[n];
      for(int i = 0; i < n; i++){
         array[i] = vet[i];
      }
   }


	/**
	 * Mostra os k primeiros elementos do array.
	 * @param int k indica a quantidade de elementos do array a serem mostrados.
	 */
	public void mostrar(int k) {
		System.out.print("[");
		
		for (int i = 0; i < k; i++) {
         System.out.print(" ("+i+")" + array[i]);
		}
		
		System.out.println("]");
	}


	/**
	 * Mostra os elementos do array.
	 */
   public void mostrar() {
      System.out.print("[");

      for (int i = 0; i < n; i++) {
         System.out.print(" ("+i+")" + array[i]);
      }

      System.out.println("]");
   }


   /**
    * Troca o conteudo de duas posicoes do array
    * @param i int primeira posicao
    * @param j int segunda posicao
    */
   public void swap(int i, int j) {
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
   }


   /**
    * Retorna o timestamp atual
    * @return timestamp atual
    */
   public long now(){
      return new Date().getTime();
   }


   /**
    * Retorna verdadeiro/falso indicando se o array esta ordenado
    * @return boolean indicando se o array esta ordenado
    */
   public boolean isOrdenado(){
      boolean resp = true;
      for(int i = 1; i < n; i++){
         if(array[i] < array[i-1]){
            i = n;
            resp = false;
         }
      }
      return resp;
   }

   /*
    * Metodo a ser implementado nas subclasses
    */
   public void sort(){
      System.out.println("Método a ser implementado nas subclasses.");
   }
}
