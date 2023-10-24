import java.io.*;  

public class ExemploRAF03Cabecote {  
   public static void main(String args[]) throws Exception {

      RandomAccessFile raf = new RandomAccessFile("exemplo.txt","rw");  

      raf.writeInt(1);  
      raf.writeDouble(5.3);  
      raf.writeChar('X');  
      raf.writeBoolean(true);  
      raf.writeBytes("Algoritmos");

      raf.seek(0); //Retornando o cabecote para a posicao 0
      System.out.println(raf.readInt()); //imprimindo o inteiro

      raf.seek(12); //Setando o cabecote na posicao 12 (do caractere,
                    //12 = 4 do int + 8 do double)
      System.out.println(raf.readChar());

      raf.seek(12); //Setando o cabecote novamente na posicao 12
      raf.writeChar('@'); //Substituindo o caractere

      raf.seek(12);
      System.out.println(raf.readChar());

      raf.close();
   }  
}  
