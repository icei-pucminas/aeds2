import java.util.*;

public class FilaNativa {
   public static void main(String[] args) throws Exception {
      Queue<String> fila = new LinkedList<String>();

      fila.add("Atlético-MG");
      fila.add("Cruzeiro");
      fila.add("América");

      while (!fila.isEmpty()){
         System.out.println("Retirando da fila: " + fila.remove());
      }
   }
}

