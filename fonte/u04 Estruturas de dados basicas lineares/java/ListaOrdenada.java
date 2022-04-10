/**
 * Lista estatica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class ListaOrdenada {
   private int[] array;
   private int n;


   /**
    * Construtor da classe.
    */
   public ListaOrdenada () {
      this(6);
   }


   /**
    * Construtor da classe.
    * @param tamanho Tamanho da lista.
    */
   public ListaOrdenada (int tamanho){
      array = new int[tamanho];
      n = 0;
   }


   /**
    * Insere um elemento 
    * @param x int elemento a ser inserido.
    * @throws Exception Se a lista estiver cheia ou a posicao invalida.
    */
   public void inserir(int x) throws Exception {

      //validar insercao
      if(n >= array.length){
         throw new Exception("Erro ao inserir!");
      }

      //procurar a posicao de insercao e movimentando os demais elementos para o fim do array
      int pos;
      for(pos = n-1; pos >= 0 && array[pos] > x; pos--){
         array[pos+1] = array[pos];
      }
      array[pos+1] = x;
      n++;
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


   /**
    * Remove um elemento da primeira posicao da lista e movimenta 
    * os demais elementos para o inicio da mesma.
    * @return resp int elemento a ser removido.
    * @throws Exception Se a lista estiver vazia.
    */
   public int removerInicio() throws Exception {

      //validar remocao
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }

      int resp = array[0];
      n--;

      for(int i = 0; i < n; i++){
         array[i] = array[i+1];
      }

      return resp;
   }


   /**
    * Remove um elemento da ultima posicao da lista.
    * @return resp int elemento a ser removido.
    * @throws Exception Se a lista estiver vazia.
    */
   public int removerFim() throws Exception {

      //validar remocao
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }

      return array[--n];
   }


   /**
    * Remove um elemento de uma posicao especifica da lista e 
    * movimenta os demais elementos para o inicio da mesma.
    * @param pos Posicao de remocao.
    * @return resp int elemento a ser removido.
    * @throws Exception Se a lista estiver vazia ou a posicao for invalida.
    */
   public int remover(int pos) throws Exception {

      //validar remocao
      if (n == 0 || pos < 0 || pos >= n) {
         throw new Exception("Erro ao remover!");
      }

      int resp = array[pos];
      n--;

      for(int i = pos; i < n; i++){
         array[i] = array[i+1];
      }

      return resp;
   }


   /**
    * Mostra os elementos da lista separados por espacos.
    */
   public void mostrar (){
      System.out.print("[ ");
      for(int i = 0; i < n; i++){
         System.out.print(array[i] + " ");
      }
      System.out.println("]");
   }


   /**
    * Procura um elemento e retorna se ele existe.
    * @param x int elemento a ser pesquisado.
    * @return <code>true</code> se o array existir,
    * <code>false</code> em caso contrario.
    */
   public boolean pesquisar(int x) {
      boolean retorno = false;
      for (int i = 0; i < n && retorno == false; i++) {
         retorno = (array[i] == x);
      }
      return retorno;
   }
}
