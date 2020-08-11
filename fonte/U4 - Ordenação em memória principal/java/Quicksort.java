/**
 * Algoritmo de ordenacao Quicksort
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Quicksort extends Geracao {

	/**
	 * Construtor.
	 */
   public Quicksort(){
      super();
   }


	/**
	 * Construtor.
	 * @param int tamanho do array de numeros inteiros.
	 */
   public Quicksort(int tamanho){
      super(tamanho);
   }


	/**
	 * Algoritmo de ordenacao Quicksort.
	 */
	public static void quicksort() {
      quicksort(0, n-1);
   }

	/**
	 * Algoritmo de ordenacao Quicksort.
    * @param int esq inicio do array a ser ordenado
    * @param int dir fim do array a ser ordenado
	 */
    private static void quicksort(int esq, int dir) {
        int i = esq, j = dir;
        int pivo = array[(dir+esq)/2];
        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        if (esq < j)  quicksort(esq, j);
        if (i < dir)  quicksort(i, dir);
    }
 

	public static void main(String[] args) throws Exception {
      Quicksort quicksort = new Quicksort(10000000);
		quicksort.aleatorio();
		//quicksort.mostrar();
		
		long comeco = now();
		quicksort.quicksort();
		long fim = now();

		//quicksort.mostrar();
		System.out.println("Tempo para ordenar: " + (fim-comeco)/1000.0 + " s.");
	}
}
