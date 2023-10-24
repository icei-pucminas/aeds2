/**
 * Ponteiro
 * @author Max do Val Machado
 * @version 3 01/2016
 */
class Cliente{
   private int codigo;
   private String nome;
   public Cliente(){
      this(0, "");
   }
   public Cliente(int codigo){
      this(codigo, "");
   }
   public Cliente(int codigo, String nome){
      this.codigo = codigo;
      this.nome = nome;
   }
   public int getCodigo(){
      return codigo;
   }
   public void setCodigo(int codigo){
      this.codigo = codigo;
   }
   public String getNome(){
      return nome;
   }
   public void setNome(String nome){
      this.nome = nome;
   }
}

class Ponteiro04Objeto {

   public static void main (String[] args){

      //Declarando tres ponteiros 
      Cliente c1 = null, c2 = null, c3 = null;
      System.out.println("ADDRs: c1(" + c1 + ")\tc2(" + c2 + ")\tc3(" + c3 + ")");

      //Alocando areas de memoria (ou inicializando objetos) e apontando os ponteiros para tais areas
      c1 = new Cliente(1, "aa");
      c2 = c1;
      c3 = new Cliente(2, "bb");
      System.out.println("ADDRs: c1(" + c1 + ")\tc2(" + c2 + ")\tc3(" + c3 + ")");

      //Setando o codigo apontado por c1 e c2
      c2.setCodigo(3);
      System.out.println("ATRIBUTOs:");
      System.out.println("c1(" + c1.getCodigo() + " / " + c1.getNome()+")");
      System.out.println("c2(" + c2.getCodigo() + " / " + c2.getNome()+")");
      System.out.println("c3(" + c3.getCodigo() + " / " + c3.getNome()+")");

   }
}
