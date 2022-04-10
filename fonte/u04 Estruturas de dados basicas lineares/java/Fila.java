/**
 * Fila estatica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Fila {
   private int[] array;
   private int primeiro; // Remove do indice "primeiro".
   private int ultimo; // Insere no indice "ultimo".


   /**
    * Construtor da classe.
    */
   public Fila () {
      this(6);
   }


   /**
    * Construtor da classe.
    * @param tamanho Tamanho da fila.
    */
   public Fila (int tamanho){
      array = new int[tamanho+1];
      primeiro = ultimo = 0;
   }


   /**
    * Insere um elemento na ultima posicao da fila.
    * @param x int elemento a ser inserido.
    * @throws Exception Se a fila estiver cheia.
    */
   public void inserir(int x) throws Exception {

      //validar insercao
      if (((ultimo + 1) % array.length) == primeiro) {
         throw new Exception("Erro ao inserir!");
      }

      array[ultimo] = x;
      ultimo = (ultimo + 1) % array.length;
   }


   /**
    * Remove um elemento da primeira posicao da fila e movimenta 
    * os demais elementos para o primeiro da mesma.
    * @return resp int elemento a ser removido.
    * @throws Exception Se a fila estiver vazia.
    */
   public int remover() throws Exception {

      //validar remocao
      if (primeiro == ultimo) {
         throw new Exception("Erro ao remover!");
      }

      int resp = array[primeiro];
      primeiro = (primeiro + 1) % array.length;
      return resp;
   }


   /**
    * Mostra os array separados por espacos.
    */
   public void mostrar (){
      System.out.print("[ ");

      for(int i = primeiro; i != ultimo; i = ((i + 1) % array.length)) {
         System.out.print(array[i] + " ");
      }

      System.out.println("]");
   }

   public void mostrarRec(){
      System.out.print("[ ");
      mostrarRec(primeiro);
      System.out.println("]");
   }

   public void mostrarRec(int i){
      if(i != ultimo){
         System.out.print(array[i] + " ");
         mostrarRec((i + 1) % array.length);
      }
   }


   /**
    * Retorna um boolean indicando se a fila esta vazia
    * @return boolean indicando se a fila esta vazia
    */
   public boolean isVazia() {
      return (primeiro == ultimo); 
   }
}
