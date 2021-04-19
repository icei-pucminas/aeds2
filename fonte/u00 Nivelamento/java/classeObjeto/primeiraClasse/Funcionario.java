class Funcionario{
   public int codigo;
   public String nome;

   public Funcionario(){
      codigo = 0;
      nome = "";
   }

   public Funcionario(int cod){
      codigo = cod;
      nome = "";
   }

   public Funcionario(int cod, String nom){
      codigo = cod;
      nome = nom;
   }

   public void imprimir(){
      System.out.println("Codigo: " + codigo);
      System.out.println("Nome: " + nome);
   }
}

