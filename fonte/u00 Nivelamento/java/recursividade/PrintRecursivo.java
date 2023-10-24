/**
 * Recursividade
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class PrintRecursivo{ 
   public static void printRecursivo(int i){
      System.out.println("valor de i: " + i);
      if(i > 0){
         printRecursivo(i-1);
      }
      System.out.println("valor de i: " + i);
   }
   public static void main(String[] args){
      int n = Integer.parseInt(args[0]);
      printRecursivo(n);
   }
}
