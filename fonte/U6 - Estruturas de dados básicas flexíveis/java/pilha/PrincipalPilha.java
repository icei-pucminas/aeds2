/**
 * Pilha dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
public class PrincipalPilha {
	public static void main(String[] args) {
		try {
			System.out.println(" ==== PILHA FLEXIVEL ====");
			Pilha pilha = new Pilha();
         int x1, x2, x3;

			pilha.inserir(0);
			pilha.inserir(1);
			pilha.inserir(2);
			pilha.inserir(3);
			pilha.inserir(4);
			pilha.inserir(5);

			System.out.print("Apos insercoes: ");
			pilha.mostrar();

			x1 = pilha.remover();
			x2 = pilha.remover();
			x3 = pilha.remover();

			System.out.print("Apos as remocoes (" + x1 + "," + x2 + "," + x3 + "): ");
			pilha.mostrar();

		}
		catch(Exception erro) {
			System.out.println(erro.getMessage());
		}
	}
}
