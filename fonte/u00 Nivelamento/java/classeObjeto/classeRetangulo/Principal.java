/**
 * Introducao a programacao orientada por objetos
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Principal
{
   public static void main(String[] args)
   {
      Retangulo r1 = new Retangulo();
      Retangulo r2 = new Retangulo();

      r1.lerTudo();
      r1.escreverTudo();

      r2.lerTudo();
      r2.escreverTudo();

      if (r1.comparar(r2.getB(), r2.getH()) == true){
         System.out.println("Os retangulos " + r1.getNome() + " e " + r2.getNome() + "sao iguais!");
      }else{
         System.out.println("Os retangulos " + r1.getNome() + " e " + r2.getNome() + "sao diferentes!");
      }

      if (r1.comparar(r2) == true){
         System.out.println("Os retangulos " + r1.getNome() + " e " + r2.getNome() + "sao iguais!");
      }else{
         System.out.println("Os retangulos " + r1.getNome() + " e " + r2.getNome() + "sao diferentes!");
      }

      if (r1.comparar(r1) == true){
         System.out.println("Os retangulos " + r1.getNome() + " e " + r1.getNome() + "sao iguais!");
      }else{
         System.out.println("Os retangulos " + r1.getNome() + " e " + r1.getNome() + "sao diferentes!");
      }

      if (r2.comparar(r1) == true){
         System.out.println("Os retangulos " + r2.getNome() + " e " + r1.getNome() + "sao iguais!");
      }else{
         System.out.println("Os retangulos " + r2.getNome() + " e " + r1.getNome() + "sao diferentes!");
      }
   }
}

