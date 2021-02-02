class NoAB {
	public char elemento;
	public NoAB esq, dir;
   public No no;


	/**
	 * Construtor da classe.
	 */
	public NoAB() {
      this.elemento = 0;
      this.esq = null;
      this.dir = null;
      this.no = null;
	}

	/**
	 * Construtor da classe.
	 * @param elemento char inserido na celula.
	 */
	public NoAB(char elemento) {
      this.elemento = elemento;
      this.esq = null;
      this.dir = null;
      this.no = new No(elemento);
	}
}
