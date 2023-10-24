/**
 * Lista estatica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class PrincipalLista {
   public static void main(String[] args) throws Exception {
      System.out.println("==== LISTA ESTATICA ====");
      Lista lista = new Lista();
      int x1, x2, x3;

      lista.inserirInicio(1);
      lista.inserirInicio(0);
      lista.inserirFim(2);
      lista.inserirFim(3);
      lista.inserir(4, 3);
      lista.inserir(5, 2);

      System.out.print("Apos insercoes: ");
      lista.mostrar();

      x1 = lista.removerInicio();
      x2 = lista.removerFim();
      x3 = lista.remover(2);

      System.out.print("Apos remocoes (" + x1 + ", " + x2 + ", " + x3 + "):");
      lista.mostrar();
   }
}
