/**
 * Metodo de ordenacao por contagem
 * @author Max do Val Machado
 * @version 3 08/2020
 */

class Countingsort extends Geracao {

	/**
	 * Construtor.
	 */
   public Countingsort(){
      super();
   }


	/**
	 * Construtor.
	 * @param int tamanho do array de numeros inteiros.
	 */
   public Countingsort(int tamanho){
      super(tamanho);
   }


	/**
	 * Algoritmo de ordenacao Countingsort.
	 */
   @Override
   public void sort() {
      //Array para contar o numero de ocorrencias de cada elemento
      int[] count = new int[getMaior() + 1];
      int[] ordenado = new int[n];

      //Inicializar cada posicao do array de contagem 
		for (int i = 0; i < count.length; count[i] = 0, i++);

      //Agora, o count[i] contem o numero de elemento iguais a i
      for (int i = 0; i < n; count[array[i]]++, i++);

      //Agora, o count[i] contem o numero de elemento menores ou iguais a i
      for(int i = 1; i < count.length; count[i] += count[i-1], i++);

      //Ordenando
      for(int i = n-1; i >= 0; ordenado[count[array[i]]-1] = array[i], count[array[i]]--, i--);

      //Copiando para o array original
      for(int i = 0; i < n; array[i] = ordenado[i], i++);
   }


	/**
	 * Retorna o maior elemento do array.
    * @return maior elemento
	 */
	public int getMaior() {
	   int maior = array[0];

		for (int i = 0; i < n; i++) {
         if(maior < array[i]){
            maior = array[i];
         }
		}
	   return maior;	
	}
}
