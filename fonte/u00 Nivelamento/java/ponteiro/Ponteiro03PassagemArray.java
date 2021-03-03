/**
 * Ponteiro
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Ponteiro03PassagemArray { 
   public static void passangemDeArray(int[] b){
      for(int i = 0; i < 5; i++){
         b[i] *= 5;
         System.out.println("b[" + i + "]: " + b[i]);
      }
      b = new int[5];
      for(int i = 0; i < 5; i++){
         b[i] = i;
         System.out.println("b[" + i + "]: " + b[i]);
      }
   }
   public static void main(String[] args) {
      int[] y = new int [5];

      for(int i = 0; i < 5; i++){
         y[i] = i;
         System.out.println("y[" + i + "]: " + y[i]);
      }
      passangemDeArray(y);
      for(int i = 0; i < 5; i++){
         System.out.println("y[" + i + "]: " + y[i]);
      }
   }
}

