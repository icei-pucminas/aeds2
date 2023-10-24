class Contato {
   public String nome;
   public String telefone;
   public String email;
   public int cpf;

   public Contato(){
      this("","","",-1);
   }
   public Contato(String nome, String telefone, String email, int cpf){
      this.nome = nome;
      this.telefone = telefone;
      this.email = email;
      this.cpf = cpf;
   }
}
