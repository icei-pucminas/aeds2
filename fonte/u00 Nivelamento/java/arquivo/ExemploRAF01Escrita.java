import java.io.*;  

public class ExemploRAF01Escrita {  
   public static void main(String args[]) throws Exception {

      RandomAccessFile raf = new RandomAccessFile("exemplo.txt","rw");  

      raf.writeInt(1);  
      raf.writeDouble(5.3);  
      raf.writeChar('X');  
      raf.writeBoolean(true);  
      raf.writeBytes("Algoritmos");          

      raf.close();
   }  
}  
