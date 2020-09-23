class No {
   public char elemento;
	private Celula primeiro;
	private Celula ultimo;
   public boolean folha;
   
   public No (){
      this(' ');
   }

   public No (char elemento){
      this.elemento = elemento;
		ultimo = primeiro = new Celula();
      folha = false;
   }

   public No inserir(char x){
		ultimo.prox = new Celula(x);
		ultimo = ultimo.prox;
      return ultimo.no;
   }

   public No pesquisar(char x){
		No resp = null;
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
         if(i.elemento == x){
            resp = i.no;
            i = ultimo;
         }
		}
		return resp;
   }

   public void setFilhoFolha(char x){
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
         if(i.elemento == x){
            i.no.folha = true;
            i = ultimo;
         }
		}
   }

   public No[] getFilho(){
      int n = 0;
		for (Celula i = primeiro.prox; i != null; i = i.prox, n++);
      No[] vet = new No[n];

      n = 0;
		for (Celula i = primeiro.prox; i != null; i = i.prox){
         vet[n++] = i.no;
		}
      
      return vet;
   }

	public void mostrar() {
		System.out.print("[ ");
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
			System.out.print(i.elemento + " ");
		}
		System.out.println("] ");
	}
}
