class Celula {
   Contato contato;
   Celula prox;

   public Celula (){
      this.contato = null;
      this.prox = null;
   }

   public Celula (Contato contato, Celula prox){
      this.contato = contato;
      this.prox = prox;
   }

   public Celula(Contato contato){
      this(contato, null);
   }
}
