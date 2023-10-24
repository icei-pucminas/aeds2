/**
 * Recursividade
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class ContarMaiuscula {
   public static boolean isUpper(char x){
      return (x >= 'A' && x <= 'Z');
   }

   public static int contMaiusculo(String s){
      int cont = 0;

      for(int i = 0; i < s.length(); i++){
         if(isUpper(s.charAt(i)) == true){
            cont++;
         }
      }
      return cont;
   }
   public static int contMaiusculo2(String s){
      return contMaiusculo2(s, 0);
   }
   public static int contMaiusculo2(String s, int i){
      int cont = 0;

      if(i < s.length()){
         if(isUpper(s.charAt(i)) == true){
            cont++;
         }
         cont += contMaiusculo2(s, i + 1);
      }
      return cont;
   }

   public static void main (String[] args){
      System.out.println("AlGoritmos e Estruturas de Dados: " + contMaiusculo("AlGoritmos e Estruturas de Dados"));
      System.out.println("AlGoritmos e Estruturas de Dados: " + contMaiusculo2("AlGoritmos e Estruturas de Dados"));
   }
}
