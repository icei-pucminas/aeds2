/**
 * Ponteiro
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Ponteiro02PassagemTipoPrimitivo {
   public static void passagemDeTipoPrimitivo(int a){
      System.out.println("a: " + a);
      a = 10;
      System.out.println("a: " + a);
   }
   public static void main(String[] args) {
      int x = 5;
      System.out.println("x: " + x);
      passagemDeTipoPrimitivo(x);
      System.out.println("x: " + x);
   }
}

