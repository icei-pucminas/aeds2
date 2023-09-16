/**
 * Metodo de ordenacao por contagem
 * @author Daniel Capanema
 * @version 1 04/2023
 */

class Radixsort extends Geracao {

	/**
	 * Construtor.
	 */
   public Radixsort(){
      super();
   }


	/**
	 * Construtor.
	 * @param int tamanho do array de numeros inteiros.
	 */
   public Radixsort(int tamanho){
      super(tamanho);
   }


	/**
	 * Algoritmo de ordenacao Countingsort.
	 */
   @Override
   public void sort() {
      int max = getMaior();
      for (int exp = 1; max/exp > 0; exp *= 10) {
         sort(exp);
     }
   }

   public void sort(int exp) {
      int[] count = new int[10];
      int[] output = new int[n];

      //Inicializar cada posicao do array de contagem 
      for (int i = 0; i < 10; count[i] = 0, i++);

      //Agora, o count[i] contem o numero de elemento iguais a i
      for (int i = 0; i < n; i++) {
          count[(array[i]/exp) % 10]++;
      }

      //Agora, o count[i] contem o numero de elemento menores ou iguais a i
      for (int i = 1; i < 10; i++) {
          count[i] += count[i-1];
      }

      //Ordenando
      for (int i = n-1; i >= 0; i--) {
          output[count[(array[i]/exp) % 10] - 1] = array[i];
          count[(array[i]/exp) % 10]--;
      }

      //Copiando para o array original
      for (int i = 0; i < n; i++) {
          array[i] = output[i];
      }
   }



	/**
	 * Retorna o maior elemento do array.
    * @return maior elemento
	 */
	public int getMaior() {
	   int maior = array[0];

		for (int i = 1; i < n; i++) {
         if(maior < array[i]){
            maior = array[i];
         }
		}
	   return maior;	
	}
}
