import java.util.*;

class Lixao{
	public static Scanner sc = new Scanner(System.in);
   public static void main(String[] args){
      Retangulo r1 = new Retangulo();
      Retangulo r2 = new Retangulo();

		System.out.println("Entre com a base: ");
      r1.b = sc.nextInt();
      System.out.println("Entre com a altura: ");
      r1.h = sc.nextInt();
      System.out.println("Entre com o nome: ");
      r1.nome = sc.nextLine();

      System.out.println("Area: " + r1.getArea());
      System.out.println("Diagonal: " + r1.getDiagonal());
      System.out.println("Perimetro: " + r1.getPerimetro());


		System.out.println("Entre com a base: ");
      r2.b = sc.nextInt();
      System.out.println("Entre com a altura: ");
      r2.h = sc.nextInt();
      System.out.println("Entre com o nome: ");
      r2.nome = sc.nextLine();

      System.out.println("Area: " + r2.getArea());
      System.out.println("Diagonal: " + r2.getDiagonal());
      System.out.println("Perimetro: " + r2.getPerimetro());
   }
}
