public class Agenda {
	private No raiz; 

	public Agenda() {
		raiz = new No ('M');
		raiz.esq = new No ('G');
		raiz.dir = new No ('T');
		raiz.esq.esq = new No ('A');
		//inserir todas as 26 letras do alfabeto...
	}

	public boolean pesquisarNome(String nome) {
		return pesquisarNome(raiz, nome);
	}

	private boolean pesquisarNome(No no, String nome) {
      boolean resp;
		if (no == null) { 
         resp = false;
      } else if (Char.toUpper(nome.charAt(0)) == no.letra) { 
         resp = false;
         for(Celula i = no.primeiro.prox; (!resp && i != null); i = i.prox){
            if(i.contato.nome.equals(nome) == true){
               resp = true;
            }
         }
      } else if (Char.toUpper(nome.charAt(0)) < no.letra) { 
         resp = pesquisarNome(no.esq, nome); 

      } else { 
         resp = pesquisarNome(no.dir, nome); 
      }
      return resp;
	}

	public void inserir(Contato contato) throws Exception {
		if(Character.isLetter(contato.nome.charAt(0))){
			raiz = inserir(raiz, contato);	
		} else {
			throw new Exception("Erro ao inserir!");
		}
	}

	private No inserir(No no, Contato contato) throws Exception {
		// insere o nó com a letra
		if (no == null) {
			no = new no(Character.toUpperCase(contato.nome.charAt(0)));
			no.ultimo.prox = new Celula(contato);
			no.ultimo = no.ultimo.prox;	
		
		// insere o contatinho
		} else if (Character.toUpperCase(contato.nome.charAt(0)) == no.letra) { 
			no.ultimo.prox = new Celula(contato);
			no.ultimo = no.ultimo.prox;
		
		// letra menor, caminha para a esquerda
		} else if (Character.toUpperCase(contato.nome.charAt(0)) < no.letra) { 
			no.esq = inserir(no.esq, contato);

		// letra maior, caminha para a direita
		} else { 
			no.dir = inserir(no.dir, contato);
		}
		return no;
	}
	
	public boolean pesquisar(int cpf) {
		return pesquisar(raiz, cpf);
	}

	private boolean pesquisar(No no, int cpf) {
		boolean resp = false;
		if (no != null) {
			resp = pesquisar(no.primeiro.prox, cpf);
			if(resp == false){
				resp = pesquisar(no.esq, cpf);
				if(resp == false){
					resp = pesquisar(no.dir, cpf);
				}
			}
		}
		return resp;
	}

	private boolean pesquisar(Celula i, int cpf){
		//efeuar a pesquisa na lista a partir do i
	}

}







