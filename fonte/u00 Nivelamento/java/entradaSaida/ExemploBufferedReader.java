import java.io.*;
import java.nio.charset.*;

class ExemploBufferedReader {

   //Declaracao da classe BufferedReader
   private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));

   public static String readString(){
      String s = "";
      char tmp;
      try{
         do{
            tmp = (char)in.read();
            if(tmp != '\n' && tmp != ' ' && tmp != 13){
               s += tmp;
            }
         }while(tmp != '\n' && tmp != ' ');
      }catch(IOException ioe){}
      return s;
   }

   public static void main(String [] args) throws Exception {

      System.out.printf("Entre com uma palavra: ");
      String str = readString();

      System.out.printf("Entre com um numero inteiro: ");
      int inteiro = Integer.parseInt(readString().trim());

      System.out.printf("Entre com um numero real: ");
      double real = Double.parseDouble(readString().trim().replace(",","."));

      System.out.printf("Entre com um caractere: ");
      char caractere = (char)in.read();

      System.out.println("Sua str: " + str);
      System.out.println("Seu inteiro: " + inteiro);
      System.out.println("Seu real: " + real);
      System.out.println("Seu caractere: " + caractere);
    } // fim main ()
} // fim class 

