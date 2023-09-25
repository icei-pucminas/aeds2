



class Lixao{
   public static void main(String[] args){
      Funcionario f1 = new Funcionario();
      Funcionario f2 = new Funcionario(5);
      Funcionario f3 = new Funcionario(10, "Ze");

      System.out.println("(1) ==================================");
      f1.imprimir();     f2.imprimir();    f3.imprimir();

      int i = 0;
      f1.codigo = i; i++;
      f2.codigo = i; i++;
      f3.codigo = i; i++;
    
      f1.nome = "Zaza";  f2.nome = "Zizi";

      System.out.println("(2) ==================================");
      f1.imprimir();     f2.imprimir();    f3.imprimir();
   }    
}





















