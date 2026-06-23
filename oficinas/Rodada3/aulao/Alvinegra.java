class No {
	public int elemento;
	public boolean cor;
	public No esq, dir;
}

class Alvinegra {
	private No raiz;
	public boolean contaBrancosAteFolhas() {
		//IMPLEMENTAR
		int qtd = contaBrancosRec(raiz);
		if(qtd == -1) return false;
		else return true;
	}

	public int contaBrancosRec(No i){
		if(i.esq == null && i.dir == null){
			// é um nó folha
			if(i.cor == false) // o nó é branco, retorna 1
				return 1;
			else // o nó é preto, retorna 0
				return 0;
		} else {
			if(i.esq != null && i.dir != null){
				// o nó tem os dois filhos
				int qtdEsq = contaBrancosRec(i.esq);
				if(qtdEsq == -1) return -1;
				int qtdDir = contaBrancosRec(i.dir);
				if(qtdEsq != qtdDir){
					return -1;
				} else { // qtd da direita é igual a qtd da esquerda
					if(i.cor == false) return qtdEsq + 1;
					else return qtdEsq;
				}
			} else if(i.esq == null){
				// o nó só tem o filho da direita	
				int qtdDir = contaBrancosRec(i.dir); // qtd de nos brancos a direita
				if(qtdDir == -1) return -1;
				if(i.cor == false) return qtdDir + 1;
				else return qtdDir;
			} else {
				// o nó só tem o filho da esquerda	
				int qtdEsq = contaBrancosRec(i.esq); // qtd de nos brancos a esquerda
				if(qtdEsq == -1) return -1;
				if(i.cor == false) return qtdEsq + 1;
				else return qtdEsq;
			}
		}
	}
}
