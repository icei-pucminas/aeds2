import java.util.*;

class ExemploScanner {
   public static void main(String [] args){

      //Declaracao da classe scanner
      Scanner scanner = new Scanner (System.in);

      System.out.printf("Entre com uma palavra: ");
      String str = scanner.nextLine();

      System.out.printf("Entre com um caractere: ");
      char caractere = scanner.nextLine().charAt(0);

      System.out.printf("Entre com um numero inteiro: ");
      int inteiro = scanner.nextInt();

      System.out.printf("Entre com um numero real: ");
      double real = scanner.nextDouble();

      System.out.println("Sua str: " + str);
      System.out.println("Seu inteiro: " + inteiro);
      System.out.println("Seu real: " + real);
      System.out.println("Seu caractere: " + caractere);

   } // fim main ()
} // fim class 

