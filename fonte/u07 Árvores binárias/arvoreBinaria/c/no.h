/**
 * No da arvore binaria
 * @author Max do Val Machado
 */

typedef struct No {
      int elemento;
	struct No *esq, *dir;
} No;

/**
 * Criacao do novo no
 * @param elemento Conteudo do no.
 */
No* novoNo(int);
