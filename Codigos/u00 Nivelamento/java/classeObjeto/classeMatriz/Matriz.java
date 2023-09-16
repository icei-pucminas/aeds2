import java.util.*;

class Matriz{
   private int linha;
   private int coluna;
   private int[][] mat;
   public static Scanner sc = new Scanner(System.in);
   public Matriz(){
      linha = coluna = 10;
      mat = new int[linha][coluna];
   }
   public Matriz(int linha_, int coluna_){
      linha = linha_;
      coluna = coluna_;
      mat = new int[linha][coluna];
   }
   public int getElemento(int i, int j){
      return mat[i][j];
   }
   public void setElemento(int i, int j, int valor){
      mat[i][j] = valor;
   }
   public void ler(){
      for (int i = 0; i < linha; i++){
         for (int j = 0; j < coluna; j++){
         	System.out.println("Digite o elemento [" + i + "," + j + "]: ");
            mat[i][j] = sc.nextInt();
         }     
      }
      System.out.println();
   }

   public Matriz soma(Matriz outra){

      Matriz resp = new Matriz(linha, coluna);

      for (int i = 0; i < linha; i++){
         for (int j = 0; j < coluna; j++){
            resp.mat[i][j] = mat[i][j] + outra.mat[i][j];
         }    
      }

      return resp;

   }

   public void imprimir(){
      for (int i = 0; i < linha; i++){
         for (int j = 0; j < coluna; j++){
            System.out.println("Mat[" + i + "," + j + "]: " + mat[i][j]);
         }     
      }
      System.out.println();
   }
   public void imprimirEmGrid(){
      for (int i = 0; i < linha; i++){
         for (int j = 0; j < coluna; j++){
            System.out.print(" " + mat[i][j]);
         }
         System.out.println();
      }
      System.out.println();
   }
}

