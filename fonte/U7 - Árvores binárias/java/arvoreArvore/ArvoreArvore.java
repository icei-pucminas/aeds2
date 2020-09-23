/**
 * Arvore de arvore
 * @author Max do Val Machado
 */
public class ArvoreArvore {
	private No raiz; // Raiz da arvore.

	/**
	 * Construtor da classe.
	 */
	public ArvoreArvore() {
		raiz = null;
      inserir('M');
      inserir('T');
      inserir('F');
      //os outros 23 caracteres.
	}

	/**
	 * Metodo publico iterativo para pesquisar elemento.
	 * @param elemento Elemento que sera procurado.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	public boolean pesquisar(String elemento) {
		return pesquisar(raiz, elemento);
	}

	private boolean pesquisar(No no, String x) {
      boolean resp;
		if (no == null) { 
         resp = false;

      } else if (x.charAt(0) == no.elemento) { 
         resp = pesquisarSegundaArvore(no.outro, x); 

      } else if (x.charAt(0) < no.elemento) { 
         resp = pesquisar(no.esq, x); 

      } else { 
         resp = pesquisar(no.dir, x); 
      }
      return resp;
	}

	private boolean pesquisarSegundaArvore(No2 no, String x) {
      boolean resp;
		if (no == null) { 
         resp = false;

      } else if (x.equals(no.elemento)) { 
         resp = true; 

      } else if (x.compareTo(no.elemento) < 0) { 
         resp = pesquisarSegundaArvore(no.esq, x); 

      } else { 
         resp = pesquisarSegundaArvore(no.dir, x); 
      }
      return resp;
	}

   private void inserir(char c){
      System.out.println(c);
      //implementar
   }
}
