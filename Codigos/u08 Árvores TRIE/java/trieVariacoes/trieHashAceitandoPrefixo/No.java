class No {
   public char elemento;
   public int tamanho = 255;
   public No[] prox;
   public boolean folha;
   
   public No (){
      this(' ');
   }

   public No (char elemento){
      this.elemento = elemento;
      prox = new No [tamanho];
      for (int i = 0; i < tamanho; i++) prox[i] = null;
      folha = false;
   }

   public static int hash (char x){
      return (int)x;
   }
}
