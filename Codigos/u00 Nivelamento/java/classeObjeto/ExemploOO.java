import java.util.*;

class Aluno {
   private String nome;
   private double nota;
   private Scanner sc = new Scanner (System.in);

   public Aluno (){
      nome = "";
      nota = 0.0;
   }

   public Aluno(String nome, double nota){
      this.nome = nome;
      this.nota = nota;
   }

   public String getNome(){
      return nome;
   }

   public void setNome(String nome){
      this.nome = nome;
   }

   public double getNota(){
      return nota;
   }

   public void setNota(double nota){
      this.nota = nota;
   }

   public void ler(){
      System.out.println("Entre com o nome do aluno: ");
      nome = sc.nextLine();

      System.out.println("Entre com a nota do aluno: ");
      nota = sc.nextDouble();
   }

   public void imprimir(){
      System.out.println("Aluno: " + nome + " (nota " + nota + ")");
   }

}

class ExemploOO {
   static Scanner sc = new Scanner (System.in);

   public static void main(String [] args){
      double media = 0;
      int numeroAluno = 5;
      Aluno[] aluno = new Aluno[numeroAluno];

      for(int i = 0; i < aluno.length; i++){
         aluno[i] = new Aluno();
      }

      for(int i = 0; i < aluno.length; i++){
         aluno[i].ler();
         media += aluno[i].getNota();
      }

      media /= numeroAluno;
      System.out.println("Média: " + media);
      System.out.println("\n\n=======================");
      System.out.println("\n\n");

      for(int i = 0; i < aluno.length; i++){
         if(aluno[i].getNota() >= media){
            aluno[i].imprimir();
         }
      }
   } // fim main ()
} // fim class 

