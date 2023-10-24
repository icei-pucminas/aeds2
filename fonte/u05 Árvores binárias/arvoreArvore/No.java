class No {
	public char elemento; // Conteudo do no.
	public No esq; // No da esquerda.
	public No dir; // No da direita.
   public No2 outro;
	
   /**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 */
	No(char elemento) {
		this.elemento = elemento;
		this.esq = this.dir = null;
      this.outro = null;
	}

	/**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 * @param esq No da esquerda.
	 * @param dir No da direita.
	 */
	No(char elemento, No esq, No dir) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
      this.outro = null;
	}
}






