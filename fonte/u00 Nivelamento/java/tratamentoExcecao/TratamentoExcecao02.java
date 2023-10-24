/**
 * Tratamento de excecao
 * @author Max do Val Machado
 * @version 2 01/2015
 */
public class TratamentoExcecao02 {
   public static void main(String[] args) {
      try {
         Integer i = new Integer(args[0]);
         MyIO.println("A variavel i vale " + i);

      } catch (ArrayIndexOutOfBoundsException e){
         MyIO.println("Erro na passagem de parametros!!!");

      } finally {
         MyIO.println("FIM DE PROGRAMA!!!");
      }
   }
}
