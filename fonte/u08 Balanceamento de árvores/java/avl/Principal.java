/**
 * Principal para Arvore Binaria de Pesquisa
 * @author Max do Val Machado
 */
public class Principal {
	public static void main(String[] args) {
		try {
			AVL avl = new AVL();
			avl.inserir(9);
			avl.caminharPre();
			avl.inserir(8);
			avl.caminharPre();
			avl.inserir(4);
			avl.caminharPre();
			avl.inserir(6);
			avl.caminharPre();
			avl.inserir(5);
			avl.caminharPre();
			avl.inserir(3);
			avl.caminharPre();
			avl.inserir(7);
			avl.caminharPre();
			avl.inserir(2);
			avl.caminharPre();
			avl.inserir(1);
			avl.caminharPre();
         /*
			avl.inserir(8);
			avl.caminharPre();
			avl.inserir(10);
			avl.caminharPre();
			avl.inserir(5);
			avl.caminharPre();
			avl.inserir(6);
			avl.caminharPre();
			avl.inserir(2);
			avl.caminharPre();
			avl.inserir(9);
			avl.caminharPre();
			avl.inserir(11);
			avl.caminharPre();
			avl.inserir(1);
			avl.caminharPre();
			avl.inserir(4);
			avl.caminharPre();
			avl.inserir(7);
			avl.caminharPre();
			avl.inserir(12);
			avl.caminharPre();
			avl.inserir(3);
			avl.caminharPre();

         for(int i = 40; i >= 21; i--){
			   avl.inserir(i);
			   avl.caminharPre();
            System.out.println("Inserindo o " + i + " (altura = " + avl.getAltura() +")");
         }

			avl.caminharCentral();
			avl.caminharPre();
			avl.caminharPos();

			avl.remover(6);
			avl.remover(2);
			avl.remover(4);

			avl.caminharCentral();
			avl.caminharPre();
			avl.caminharPos();
         */  
		}
		catch(Exception erro) {
			System.out.println(erro.getMessage());
		}
	}
}
