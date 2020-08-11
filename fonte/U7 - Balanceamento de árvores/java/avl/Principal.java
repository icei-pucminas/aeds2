/**
 * Principal para Arvore Binaria de Pesquisa
 * @author Max do Val Machado
 */
public class Principal {
	public static void main(String[] args) {
		try {
			AVL avl = new AVL();
			avl.inserir(9);
			avl.mostrarPre();
			avl.inserir(8);
			avl.mostrarPre();
			avl.inserir(4);
			avl.mostrarPre();
			avl.inserir(6);
			avl.mostrarPre();
			avl.inserir(5);
			avl.mostrarPre();
			avl.inserir(3);
			avl.mostrarPre();
			avl.inserir(7);
			avl.mostrarPre();
			avl.inserir(2);
			avl.mostrarPre();
			avl.inserir(1);
			avl.mostrarPre();
         /*
			avl.inserir(8);
			avl.mostrarPre();
			avl.inserir(10);
			avl.mostrarPre();
			avl.inserir(5);
			avl.mostrarPre();
			avl.inserir(6);
			avl.mostrarPre();
			avl.inserir(2);
			avl.mostrarPre();
			avl.inserir(9);
			avl.mostrarPre();
			avl.inserir(11);
			avl.mostrarPre();
			avl.inserir(1);
			avl.mostrarPre();
			avl.inserir(4);
			avl.mostrarPre();
			avl.inserir(7);
			avl.mostrarPre();
			avl.inserir(12);
			avl.mostrarPre();
			avl.inserir(3);
			avl.mostrarPre();

         for(int i = 40; i >= 21; i--){
			   avl.inserir(i);
			   avl.mostrarPre();
            System.out.println("Inserindo o " + i + " (altura = " + avl.getAltura() +")");
         }

			avl.mostrarCentral();
			avl.mostrarPre();
			avl.mostrarPos();

			avl.remover(6);
			avl.remover(2);
			avl.remover(4);

			avl.mostrarCentral();
			avl.mostrarPre();
			avl.mostrarPos();
         */  
		}
		catch(Exception erro) {
			System.out.println(erro.getMessage());
		}
	}
}
