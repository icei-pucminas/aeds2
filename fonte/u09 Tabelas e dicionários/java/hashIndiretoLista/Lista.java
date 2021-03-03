/**
 * Celula simplesmente encadeada
 * @author Joao Paulo Domingos Silva
 * @version 1.1 02/2012
 */
class Celula {
	public int elemento; // Elemento inserido na celula.
	public Celula prox; // Aponta a celula prox.

	/**
	 * Construtor da classe.
	 * @param elemento Elemento inserido na celula.
	 */
	Celula(int elemento) {
		this.elemento = elemento;
		this.prox = null;
	}

	/**
	 * Construtor da classe.
	 * @param elemento Elemento inserido na celula.
	 * @param prox Aponta a celula prox.
	 */
	Celula(int elemento, Celula prox) {
		this.elemento = elemento;
		this.prox = prox;
	}
}

/**
 * Lista dinamica simplesmente encadeada
 * @author Joao Paulo Domingos Silva
 * @version 1.1 02/2012
 */
public class Lista {
	private Celula primeiro; // Primeira celula: SEM elemento valido.
	private Celula ultimo; // Ultima celula: COM elemento valido.

	/**
	 * Construtor da classe: Instancia uma celula (primeira e ultima).
	 */
	public Lista() {
		primeiro = new Celula(-1);
		ultimo = primeiro;
	}

	/**
	 * Mostra os elementos separados por espacos.
	 */
	public void mostrar() {
		System.out.print("[ "); // Comeca a mostrar.
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
			System.out.print(i.elemento + " ");
		}
		System.out.println("] "); // Termina de mostrar.
	}

	/**
	 * Procura um elemento e retorna se ele existe.
	 * @param x Elemento a pesquisar.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	public boolean pesquisar(int x) {
		boolean retorno = false;
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
         if(i.elemento == x){
            retorno = true;
            i = ultimo;
         }
		}
		return retorno;
	}

	/**
	 * Insere um elemento na primeira posicao da sequencia.
	 * @param elemento Elemento a inserir.
	 */
	public void inserirInicio(int elemento) {
		Celula tmp = new Celula(elemento);
      tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if (primeiro == ultimo) {
			ultimo = tmp;
		}
      tmp = null;
	}

	/**
	 * Insere um elemento na ultima posicao da sequencia.
	 * @param elemento Elemento a inserir.
	 */
	public void inserirFim(int elemento) {
		Celula tmp = new Celula(elemento);
		ultimo.prox = tmp;
		ultimo = ultimo.prox;
      tmp = null;
	}

	/**
	 * Insere elemento em um indice especifico.
	 * Considera que primeiro elemento esta no indice 0.
	 * @param x Elemento a inserir.
	 * @param posicao Meio da insercao.
	 * @throws Exception Se <code>posicao</code> for incorreta.
	 */
   public void inserirMeio(int x, int posicao) throws Exception {
      Celula i;
      int cont;

		// Caminhar ate chegar na posicao anterior a insercao
      for(i = primeiro, cont = 0; (i.prox != ultimo && cont < posicao); i = i.prox, cont++);
		
		// Se indice for incorreto:
		if (posicao < 0 || posicao > cont + 1) {
			throw new Exception("Erro ao inserir (posicao " + posicao + "(cont = " + cont + ") invalida)!");

      } else if (posicao == cont + 1) {
         inserirFim(x);
		}else{
         Celula tmp = new Celula(x);
         tmp.prox = i.prox;
         i.prox = tmp;
         tmp = i = null;
      }
   }

	/**
	 * Remove um elemento da primeira posicao da sequencia.
	 * @return Elemento removido.
	 * @throws Exception Se a sequencia nao contiver elementos.
	 */
	public int removerInicio() throws Exception {
      int resp = -1;

		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		}else{
         primeiro = primeiro.prox;
         resp = primeiro.elemento;
      }

		return resp;
	}

	/**
	 * Remove um elemento da ultima posicao da sequencia.
	 * @return Elemento removido.
	 * @throws Exception Se a sequencia nao contiver elementos.
	 */
	public int removerFim() throws Exception {
      int resp =  -1;
      Celula i = null;

		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		} else {

         resp = ultimo.elemento;

		   // Caminhar ate a penultima celula:
         for(i = primeiro; i.prox != ultimo; i = i.prox);

         ultimo = i;
         i = ultimo.prox = null;
      }

		return resp;
	}

	/**
	 * Remove elemento de um indice especifico.
	 * Considera que primeiro elemento esta no indice 0.
	 * @param posicao Meio da remocao.
	 * @return Elemento removido.
	 * @throws Exception Se <code>posicao</code> for incorreta.
	 */
	public int removerMeio(int posicao) throws Exception {
      Celula i;
      int resp = -1, cont;

		if (primeiro == ultimo){
			throw new Exception("Erro ao remover (vazia)!");
      }else{

		   // Caminhar ate chegar na posicao anterior a insercao
         for(i = primeiro, cont = 0; (i.prox != ultimo && cont < posicao); i = i.prox, cont++);

         // Se indice for incorreto:
		   if (posicao < 0 || posicao > cont + 1) {
            throw new Exception("Erro ao remover (posicao " + posicao + " invalida)!");

         } else if (posicao == cont + 1) {
            resp = removerFim();
         }else{
            Celula tmp = i.prox;
            resp = tmp.elemento;
            i.prox = tmp.prox;
            tmp.prox = null;
            i = tmp = null;
         }
      }

		return resp;
	}
}
