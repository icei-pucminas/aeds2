/**
 * Principal para Arvore Binaria de Pesquisa
 * @author Max do Val Machado
 */
public class Principal {
   public static void main(String[] args) throws Exception {
      ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

      arvoreBinaria.inserir(3);
      arvoreBinaria.inserir(5);
      arvoreBinaria.inserir(1);
      arvoreBinaria.inserir(8);
      arvoreBinaria.inserir(2);
      arvoreBinaria.inserir(4);
      arvoreBinaria.inserir(7);
      arvoreBinaria.inserir(6);

      arvoreBinaria.caminharCentral();
      arvoreBinaria.caminharPre();
      arvoreBinaria.caminharPos();

      arvoreBinaria.remover(6);
      arvoreBinaria.remover(2);
      arvoreBinaria.remover(4);

      arvoreBinaria.caminharCentral();
      arvoreBinaria.caminharPre();
      arvoreBinaria.caminharPos();
   }
}
