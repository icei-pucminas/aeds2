class No {
   public int i, j, k;
   public int tamanho = 255;
   public No[] prox;
   public boolean folha;
   
   public No (){
      this(-1, -1, -1);
   }

   public No (int i, int j, int k){
      this(i, j, k, false);
   }

   public No (int i, int j, int k, boolean folha){
      this.i = i;
      this.j = j;
      this.k = k;
      this.folha = folha;

      prox = new No [tamanho];

      for (int l = 0; l < tamanho; l++){
         prox[l] = null;
      }
   }

   public static int hash (char x){
      return (int)x;
   }
}
