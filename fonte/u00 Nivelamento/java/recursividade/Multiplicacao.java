class Multiplicacao {
   public static int multiplicacao(int a, int b){
      return multiplicacao(a, b, 0);
   }

   public static int multiplicacao(int a, int b, int i){
      int resp = 0;

      if(i < b){
         resp = a + multiplicacao(a, b, i+1);
      }

      return resp;
   }

   public static int multiplicacaoInt(int a, int b){
      int resp = 0;
      for(int i = 0; i < b; i++){
         resp = a + resp;
      }
      return resp;
   }

   public static void main (String[] args){
      int mult = multiplicacaoInt(4, 3);
      System.out.println("RESPOSTA INT: " + mult);

      mult = multiplicacao(4, 3);
      System.out.println("RESPOSTA REC: " + mult);
   }
}
