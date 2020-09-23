

class ColetaLixo {
	private Celula primeiro;

	public ColetaLixo () {
		primeiro = new Celula();
	}

	public void inserir(int x) {
		primeiro.prox = new Celula(x);
		primeiro = primeiro.prox;
	}

	public static void main (String [] args) {
		ColetaLixo coletaLixo = new ColetaLixo ();

		while(true){
			coletaLixo.inserir(0);
		}
	}
}


