/**
 * Recursividade
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class FibonacciRecursivo {
   public static int fibRec (int n){
      int resp;
      System.out.println("fib (" + n + ")");
      resp = (n == 0 || n == 1) ? 1 : fibRec(n-1) + fibRec(n-2);
      System.out.println("fib (" + n + "): " + resp);
      return resp;
   }
   public static void main (String[] args){
      int n = Integer.parseInt(args[0]);
      System.out.println("FIBONACCI RECURSIVO(" + n + "): " + fibRec(n));
   }
}
