class Celula {
   Contato contato;
   Celula prox;

   public Celula (){
      this(null, null);
   }

   public Celula(Contato contato){
      this(contato, null);
   }

   public Celula (Contato contato, Celula prox){
      this.contato = contato;
      this.prox = prox;
   }
}
