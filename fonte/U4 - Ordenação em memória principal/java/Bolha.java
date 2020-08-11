/**
 * Metodo de ordenacao da bolha
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Bolha extends Geracao {

	/**
	 * Construtor.
	 */
   public Bolha(){
      super();
   }


	/**
	 * Construtor.
	 * @param int tamanho do array de numeros inteiros.
	 */
   public Bolha(int tamanho){
      super(tamanho);
   }


	/**
	 * Algoritmo de ordenacao Bolha.
	 */
	public static void bolha() {
		for (int i = (n - 1); i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
               swap(j, j+1);
				}
			}
		}
   }


	public static void main(String[] args) {
      Bolha bolha = new Bolha(100);
		bolha.aleatorio();
		bolha.mostrar();
		
		long comeco = now();
		bolha.bolha();
		long fim = now();
		
		bolha.mostrar();
		System.out.println("Tempo para ordenar: " + (fim-comeco)/1000.0 + " s.");
	}
}
