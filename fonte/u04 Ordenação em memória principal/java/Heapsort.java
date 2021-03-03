/**
 * Algoritmo de ordenacao Heapsort
 * @author Max do Val Machado
 * @version 3 08/2020
 */

class Heapsort extends Geracao {

   /**
    * Construtor.
    */
   public Heapsort(){
      super();
   }


   /**
    * Construtor.
    * @param int tamanho do array de numeros inteiros.
    */
   public Heapsort(int tamanho){
      super(tamanho);
   }


   /**
    * Algoritmo de ordenacao Heapsort.
    */
   @Override
   public void sort() {
      //Alterar o vetor ignorando a posicao zero
      int[] tmp = new int[n+1];
      for(int i = 0; i < n; i++){
         tmp[i+1] = array[i];
      }
      array = tmp;

      //Contrucao do heap
      for(int tamHeap = 2; tamHeap <= n; tamHeap++){
         construir(tamHeap);
      }

      //Ordenacao propriamente dita
      int tamHeap = n;
      while(tamHeap > 1){
         swap(1, tamHeap--);
         reconstruir(tamHeap);
      }

      //Alterar o vetor para voltar a posicao zero
      tmp = array;
      array = new int[n];
      for(int i = 0; i < n; i++){
         array[i] = tmp[i+1];
      }
   }


   public void construir(int tamHeap){
      for(int i = tamHeap; i > 1 && array[i] > array[i/2]; i /= 2){
         swap(i, i/2);
      }
   }


   public void reconstruir(int tamHeap){
      int i = 1;
      while(i <= (tamHeap/2)){
         int filho = getMaiorFilho(i, tamHeap);
         if(array[i] < array[filho]){
            swap(i, filho);
            i = filho;
         }else{
            i = tamHeap;
         }
      }
   }

   public int getMaiorFilho(int i, int tamHeap){
      int filho;
      if (2*i == tamHeap || array[2*i] > array[2*i+1]){
         filho = 2*i;
      } else {
         filho = 2*i + 1;
      }
      return filho;
   }
}
