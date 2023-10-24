class No {
   public char elemento;
	private NoAB raiz;
   public boolean folha;
   
   public No (){
      this(' ');
   }

   public No (char elemento){
      this.elemento = elemento;
		raiz = null;
      folha = false;
   }

   public No inserir(char x) throws Exception {
		raiz = inserir(x, raiz);
      return pesquisar(x);
	}

	private NoAB inserir(char x, NoAB i) throws Exception {
		if (i == null) {
         i = new NoAB(x);

      } else if (x < i.elemento) {
         i.esq = inserir(x, i.esq);

      } else if (x > i.elemento) {
         i.dir = inserir(x, i.dir);

      } else {
         throw new Exception("Erro ao inserir!");
      }

		return i;
	}

	public No pesquisar(char x) {
		return pesquisar(x, raiz);
	}

	private No pesquisar(int x, NoAB i) {
      No resp;
		if (i == null) {
         resp = null;

      } else if (x == i.elemento) {
         resp = i.no;

      } else if (x < i.elemento) {
         resp = pesquisar(x, i.esq);

      } else {
         resp = pesquisar(x, i.dir);
      }
      return resp;
	}

   public void setFilhoFolha(char x){
      setFilhoFolha(x, raiz);
   }
   public void setFilhoFolha(char x, NoAB i){
		if (i == null) {
         //nada...

      } else if (x == i.elemento) {
         i.no.folha = true;

      } else if (x < i.elemento) {
         setFilhoFolha(x, i.esq);

      } else {
         setFilhoFolha(x, i.dir);
      }
   }

	public int getN() {
      return getN(raiz);
	}
	private int getN(NoAB i) {
      int resp = 0;
		if (i != null) {
         resp = 1 + getN(i.esq) + getN(i.dir);
		}
      return resp;
	}

   public No[] getFilho(){
      int n = getN();
      No[] vet = new No[n];
      getFilho(vet, 0, raiz);
      return vet;
   }

   public int getFilho(No[] vet, int pos, NoAB i){
      if(i != null){
         vet[pos++] = i.no;
         pos = getFilho(vet, pos, i.esq);
         pos = getFilho(vet, pos, i.dir);
      }
      return pos;
   }
}
