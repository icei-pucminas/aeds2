/**
 * Recursividade
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class FatorialRecursivo{
   public static int fatorial(int n){
      int resp;
      System.out.println("fat (" + n + ")");
      resp = (n == 1) ? 1 : n * fatorial(n-1);
      System.out.println("fat n(" + n + "): " + resp);
      return resp;
   }

   public static void main(String[] args){
      int n = Integer.parseInt(args[0]);
      System.out.println("FATORIAL RECURSIVO(" + n + "): " + fatorial(n));
   }
}

