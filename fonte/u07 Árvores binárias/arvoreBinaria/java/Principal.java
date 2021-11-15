/**
 * Principal para Arvore Binaria de Pesquisa
 * @author Max do Val Machado
 */
public class Principal {
    public static void main(String[] args) throws Exception {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        for(int i=1; i<30; i++){
            arvoreBinaria.inserir(i);
            System.out.print("No. nos: " + i);
            System.out.print("\t Altura: " + arvoreBinaria.getAltura());
            System.out.println("\t log(2): " + Math.log(i)/Math.log(2));
        }
    }
}
