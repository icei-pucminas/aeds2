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


   public void inserir(String s){
      inserir(s, raiz);
   }

   public void inserir(String s, No i) throws Exception {
		if (i == null) {
         throw new Exception("Erro ao inserir: caractere invalido!");

      } else if (s.charAt(0) < i.elemento) {
         inserir(x, i.esq);

      } else if (s.charAt(0) > i.elemento) {
         inserir(x, i.dir);

      } else {
         i.outro = inserir(s, i.outro);
      }
   }


	private No inserir(String s, No2 i) throws Exception {
		if (i == null) {
         i = new No2(x);

      } else if (s.compareTo(i.elemento) < 0) {
         i.esq = inserir(x, i.esq);

      } else if (s.compareTo(i.elemento) > 0) {
         i.dir = inserir(x, i.dir);

      } else {
         throw new Exception("Erro ao inserir: elemento existente!");
      }

		return i;
	}


   public boolean hasStringTam10(){
      return hasStringTam10(raiz);
   }

   public boolean hasStringTam10(No i){
      boolean resp = false;
      if(i != null){
         resp = hasStringTam10(i.outro) || hasStringTam10(i.esq) || hasStringTam10(i.dir);
      }
      return resp;
   }

   public boolean hasStringTam10(No2 i){
      boolean resp = false;
      if(i != null){
         resp = i.elemento.length() == 10 || hasStringTam10(i.esq) || hasStringTam10(i.dir);
      }
      return resp;
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

   public int contPalavra(char letra){
      return contPalavra(letra, raiz);
   }

   public int contPalavra(char letra, No i) throws Exception {
      int resp = 0;

		if (i == null) {
         throw new Exception("Erro ao pesquisar: caractere invalido!");

      } else if (letra < i.elemento) {
         resp = contPalavra(letra, i.esq);

      } else if (letra > i.elemento) {
         resp = contPalavra(letra, i.dir);

      } else {
         resp = contPalavra(i.outro);
      }

      return resp;
   }

   public int contPalavra(No2 i){
      int resp = 0;
      if(i != null){
         resp = 1 + contPalavra(i.esq) + contPalavra(i.dir);
      }
      return resp;
   }


}
