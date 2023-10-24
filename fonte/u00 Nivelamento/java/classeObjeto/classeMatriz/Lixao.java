import java.util.*;

class Lixao{
	public static Scanner sc = new Scanner(System.in);
   public static void main(String[] args){
      int linha, coluna;
      Matriz m1, m2;

      //Leitura do numero de linhas das matrizes
      System.out.println("Digite o numero de linhas:");
      linha = sc.nextInt();

      //Leitura do numero de coluna das matrizes
      System.out.println("Digite o numero de colunas:");
      coluna = sc.nextInt();

      //Definicao do tamanho das matrizes
      m1 = new Matriz(linha,coluna);
      m2 = new Matriz(linha, coluna);

      //Leitura de cada elemento da matriz 1
      m1.ler();

      //Leitura de cada elemento da matriz 2
      m2.ler();

      //Somar as duas matrizes e salvar o resultado na matriz 3
      Matriz m3 = m1.soma(m2);

      //Imprimir a matriz 1
      m1.imprimir();

      //Imprimir a matriz 2
      m2.imprimir();

      //Imprimir a matriz 3
      m3.imprimir();

      //Imprimir a matriz 1 em formato de grid
      m1.imprimirEmGrid();

      //Imprimir a matriz 2 em formato de grid
      m2.imprimirEmGrid();

      //Imprimir a matriz 3 em formato de grid
      m3.imprimirEmGrid();
   }
}
