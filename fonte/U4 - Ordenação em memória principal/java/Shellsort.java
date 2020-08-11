/**
 * Algoritmo de ordenacao Shellsort
 * @author Max do Val Machado
 * @version 2 01/2015
 */

class Shellsort extends Geracao {

   /**
    * Construtor.
    */
   public Shellsort(){
      super();
   }


   /**
    * Construtor.
    * @param int tamanho do array de numeros inteiros.
    */
   public Shellsort(int tamanho){
      super(tamanho);
   }


   /**
    * Algoritmo de ordenacao Shellsort.
    */
   public static void shellsort() {
      int h = 1;

      do { h = (h * 3) + 1; } while (h < n);

      do {
         h /= 3;
         for(int cor = 0; cor < h; cor++){
            insercaoPorCor(cor, h);
         }
      } while (h != 1);
   }


   /**
    * Metodo que efetua a insercao nos pseudo-arrays do Shellsort.
    * @param int cor cor do pseudo array.
    * @param int h passo do shelsort
    */
   public static void insercaoPorCor(int cor, int h){
      for (int i = (h + cor); i < n; i+=h) {
         int tmp = array[i];
         int j = i - h;
         while ((j >= 0) && (array[j] > tmp)) {
            array[j + h] = array[j];
            j-=h;
         }
         array[j + h] = tmp;
      }
   }


   public static void main(String[] args) {
      Shellsort shellsort = new Shellsort(100000000);
      shellsort.aleatorio();
      //shellsort.mostrar();

      long comeco = now();
      shellsort.shellsort();
      long fim = now();

      //shellsort.mostrar();
      System.out.println("Tempo para ordenar: " + (fim-comeco)/1000.0 + " s.");
   }
}
