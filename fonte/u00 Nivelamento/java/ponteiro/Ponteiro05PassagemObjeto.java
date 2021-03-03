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

class Ponteiro05PassagemObjeto { 

   /**
    * Metodo que recebe um ponteiro contendo o endereco de um objeto. Em seguida, o metodo altera o 
    * conteudo do objeto apontado pelo ponteiro (o mesmo objeto apontado por c1 no metodo principal). 
    * Depois, o metodo retorna o conteudo do nosso ponteiro (endereco recebido como parametro).
    */
   public static Cliente setar2(Cliente y){
      y.setCodigo(6);
      y.setNome("ff");
      System.out.println("ADDRs: y(" + y + ")");
      System.out.println("ATRIBUTOs: y(" + y.getCodigo() + " / " + y.getNome()+")");

      return y;
   }

   /**
    * Metodo que recebe um ponteiro contendo o endereco de um objeto. Em seguida, o metodo altera o 
    * conteudo do objeto apontado pelo ponteiro (o mesmo objeto apontado por c1 no metodo principal). 
    * Depois, o metodo faz com que o ponteiro corrente aponte para outro objeto (veja que c1 do metodo 
    * princial continua apontando para o primeiro objeto). No final, a coleta de lixo do java libera a 
    * area de memoria que continha o ponteiro e o objeto criados neste metodo.
    */
   public static void setar1(Cliente x){
      x.setCodigo(4);
      x.setNome("dd");
      System.out.println("ADDRs: x(" + x + ")");
      System.out.println("ATRIBUTOs: x(" + x.getCodigo() + " / " + x.getNome()+")");

      x = new Cliente (5, "ee");
      System.out.println("ADDRs: x(" + x + ")");
      System.out.println("ATRIBUTOs: x(" + x.getCodigo() + " / " + x.getNome()+")");
   }


   public static void main (String[] args){

      //Declarando tres ponteiros 
      Cliente c1 = new Cliente(1, "aa");
      Cliente c2 = c1;
      Cliente c3 = new Cliente(2, "bb");
      System.out.println("ADDRs: c1(" + c1 + ")\tc2(" + c2 + ")\tc3(" + c3 + ")");
      System.out.println("ATRIBUTOs:");
      System.out.println("c1(" + c1.getCodigo() + " / " + c1.getNome()+")");
      System.out.println("c2(" + c2.getCodigo() + " / " + c2.getNome()+")");
      System.out.println("c3(" + c3.getCodigo() + " / " + c3.getNome()+")");

      //Chamando o metodo setar1 e passando POR VALOR O ADDR de c1
      setar1(c1);
      System.out.println("ADDRs: c1(" + c1 + ")\tc2(" + c2 + ")\tc3(" + c3 + ")");
      System.out.println("ATRIBUTOs:");
      System.out.println("c1(" + c1.getCodigo() + " / " + c1.getNome()+")");
      System.out.println("c2(" + c2.getCodigo() + " / " + c2.getNome()+")");
      System.out.println("c3(" + c3.getCodigo() + " / " + c3.getNome()+")");

      //Chamando o metodo setar2, passando POR VALOR O ADDR DE c2 e retornando um novo endereco para C3
      c3 = setar2(c2);
      System.out.println("ADDRs: c1(" + c1 + ")\tc2(" + c2 + ")\tc3(" + c3 + ")");
      System.out.println("ATRIBUTOs:");
      System.out.println("c1(" + c1.getCodigo() + " / " + c1.getNome()+")");
      System.out.println("c2(" + c2.getCodigo() + " / " + c2.getNome()+")");
      System.out.println("c3(" + c3.getCodigo() + " / " + c3.getNome()+")");
   }
}
