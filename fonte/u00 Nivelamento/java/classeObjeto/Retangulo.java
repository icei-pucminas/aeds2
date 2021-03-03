/**
 * Introducao a programacao orientada por objetos
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Retangulo{
   //Declaracao de variaveis
   private double b, h;
   private String nome;

   //Construtor vazio
   public Retangulo(){
      this.b = this.h = 0;
      this.nome = "";
   }

   //Construtor que recebe parametros
   public Retangulo(double b, double h, String nome){
      this.b = b;
      this.h = h;
      this.nome = nome;
   }

   public double getB(){
      return this.b;
   }

   public void setB(double b){
      this.b = b;
   }

   public double getH(){
      return this.h;
   }

   public void setH(double h){
      this.h = h;
   }

   public String getNome(){
      return this.nome;
   }

   public void setNome(String nome){
      this.nome = nome;
   }

   public void lerTudo(){
      b = MyIO.readDouble("Entre com a base: ");
      h = MyIO.readDouble("Entre com a altura: ");
      nome = MyIO.readString("Entre com o nome: ");
   }

   public void escreverTudo(){
      System.out.println("NOME: " + nome);
      System.out.println("Base: " + b);
      System.out.println("Altura: " + h);
      System.out.println("Area: " + getArea());
      System.out.println("Diagonal: " + getDiagonal());
      System.out.println("Perimetro: " + getPerimetro());
   }


   //Retornar a area
   public double getArea(){
      return (b * h);
   }

   //Retornar o perimetro
   public double getPerimetro(){
      return ((b + h) * 2);
   }

   //Retornar a diagonal
   public double getDiagonal(){
      return Math.sqrt(b * b + h * h);
   }


   //Comparar
   public boolean comparar(double outraB, double outraH){
      boolean resp;

      if (this.b == outraB && this.h == outraH){
         resp = true;
      }else{
         resp = false;
      }

      return resp;
   }

   //Comparar
   //public boolean comparar(double outraB, double outraH){
   //    return (this.b == outraB && this.h == outraH);
   //}

   //Comparar
   public boolean comparar(Retangulo x){
      return (this.b == x.b && this.h == x.h);
   }
}
