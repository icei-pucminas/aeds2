import java.util.*;
public class TreeSort {
	private No raiz; 
   private int n;

	public TreeSort() {
		raiz = null;
      n = 0;
	}

	public int[] sort() {
      int[] array = new int[n];
      n = 0;
		sort(raiz, array);
      return array;
	}

	private void sort(No i, int[] array) {
		if (i != null) {
			sort(i.esq, array);
			array[n++] = i.elemento;
			sort (i.dir, array);
		}
	}

	public void inserir(int x) {
      n++;
		raiz = inserir(x, raiz);
	}

	private No inserir(int x, No i) {
		if (i == null) {
         i = new No(x);

      } else if (x < i.elemento) {
         i.esq = inserir(x, i.esq);

      } else if (x >= i.elemento) {
         i.dir = inserir(x, i.dir);
      }

		return i;
	}

   public static void main(String[] args){
      TreeSort a = new TreeSort();
      Random gerador = new Random();
      gerador.setSeed(0);
      System.out.print("\nArray: ");
      for(int i = 1; i <= 100; i++){
         int valor = Math.abs(gerador.nextInt() % 1000);
         a.inserir(valor);
         System.out.print(valor + " ");
      }
      System.out.print("\nArray ordenado: ");
      int[] array = a.sort();
      for(int i = 0; i < array.length; i++){
         System.out.print(array[i] + " ");
      }
   }
}
