class Doidona {
	No raiz;
	boolean buscarVeiculo(Veiculo veiculo){
		//MÉTODO A SER IMPLEMENTADO
		char letra = veiculo.placa.charAt(0); // primeira letra da placa
		No no = buscarNo(letra);
		if(no == null){
			return false; // não encontrei a primeira letra
		} else {
			// encontrei o nó com a primeira letra
			return buscarT1(no.t1, veiculo); //retornamos o que a T1 falar
		}

	}

	boolean buscarT1(T1 t1, Veiculo veiculo){
		int posHash = t1.hashT1(veiculo.placa);
		if(t1.tabela[posHash] == null){
			// a posicao está vazia
			return false;
		} else {
			// a posicao tem algo
			if(t1.tabela[posHash].placa.equals(veiculo.placa) == true){
				// encontramos o veiculo na t1
				return true;
			} else {
				// temos que olhar no rehash
				int posRehash = t1.rehashT1(veiculo.placa);
				if(t1.tabela[posRehash] == null){
					// não tem nada no rehash
					return false;
				} else {
					// tem algo no rehash
					if(t1.tabela[posRehash].placa.equals(veiculo.placa) == true){
						// encontrei o veiculo no rehash da T1
						return true;
					} else {
						// retornar o que a T2 falar
						return buscarT2(t1.t2, veiculo);
					}
				}
			}
		}
	}

	boolean buscarT2(T2 t2, Veiculo veiculo){
		int posHash = t2.hashT2(veiculo.chassi);
		Lista lista = t2.tabela[posHash]; // lista em que o veiculo pode estar
		CelulaLista atual = lista.inicio.prox; // começando a busca após a célula cabeça
		while(atual != null){
			// busca em uma lista flexível
			if(atual.veiculo.placa.equals(veiculo.placa) == true){
				// encontrei o veículo na lista
				return true;
			}
			atual = atual.prox;
		}
		// se atual chegar em null, quer dizer que o veiculo não existe
		return false;
	}

	No buscarNo(char letra){
		return buscarNoRec(raiz, letra);	
	}

	No buscarNoRec(No i, char letra){
		No resp;
		if(i == null){
			resp = null;
		}
		else if(letra == i.letra){
			resp = i;
		} else {
			if(letra < i.letra){
				resp = buscarNoRec(i.esq, letra);
			} else {
				resp = buscarNoRec(i.dir, letra);
			}
		}
		return resp;
	}
}

class No {
	char letra;
	No esq, dir;
	T1 t1;
}

class Veiculo {
	String placa, modelo, chassi;
	String tipo; //carro ou moto
}

class CelulaLista {
	Veiculo veiculo;
	CelulaLista prox;
}

class T2 {
	Lista[] tabela;
	int hashT2(String chassi) {
		// já implementado
	}
}

class T1 {
	Veiculo[] tabela;
	T2 t2;
	int hashT1(String placa) {
		// já implementado
	}
	int rehashT1(String placa) {
		// já implementado
	}
}
