class Log {
   public static void main (String[] args) {
      int[] n = {4,5,6,7,8,9,10,11,12,13,14,15,16,17,31,32,33,63,64,65};
      int cont;

      for(int k = 0; k < n.length; k++){
         System.out.print("\n[n = " + n[k] + "] => ");
         cont = 0;
         for(int i = n[k]; i > 0; i /= 2){
            System.out.print(" " + i);
            cont++;
         }
         System.out.print(" (" + cont + " vezes)");
      }
      System.out.print("\n");
   }
}
