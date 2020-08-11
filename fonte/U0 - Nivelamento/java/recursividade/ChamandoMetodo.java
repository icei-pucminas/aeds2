class ChamandoMetodo {
   public static void primeiro(){
      System.out.println("1o - inicio");
      segundo();
      System.out.println("1o - fim");
   }
   public static void segundo(){
      System.out.println("2o - inicio");
      terceiro();
      System.out.println("2o - fim");
   }
   public static void terceiro(){
      System.out.println("3o - inicio e fim");
   }
   public static void main (String[] args){
      System.out.println("main - inicio");
      primeiro();
      System.out.println("main - fim");
   }
}
