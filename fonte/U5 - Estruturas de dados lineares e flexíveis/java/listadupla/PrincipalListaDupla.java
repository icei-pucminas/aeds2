/**
 * Lista dupla dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class PrincipalListaDupla {
	public static void main(String[] args) {
		try {
			System.out.println("=== LISTA DINAMICA DUPLAMENTE ENCADEADA ===");
			ListaDupla lista = new ListaDupla();

			lista.inserirInicio(1);
			lista.inserirInicio(0);
			lista.inserirFim(4);
			lista.inserirFim(5);
			lista.inserir(2, 2);
			lista.inserir(3, 3);
			lista.inserir(6, 6);
			lista.inserir(-1, 0);
			lista.inserirFim(7);
			lista.inserirFim(8);

			System.out.print("Apos insercoes: ");
			lista.mostrar();

			int x1 = lista.remover(3);
			int x2 = lista.remover(2);
			int x3 = lista.removerFim();
			int x4 = lista.removerInicio();
			int x5 = lista.remover(0);
			int x6 = lista.remover(4);

			System.out.print("Apos remocoes (" +x1+ ", " +x2+ ", " +x3+ ", " +x4+ ", " +x5+ ", " +x6+ "): ");
			lista.mostrar();
		}
		catch(Exception erro) {
			System.out.println(erro.getMessage());
		}
	}
}
