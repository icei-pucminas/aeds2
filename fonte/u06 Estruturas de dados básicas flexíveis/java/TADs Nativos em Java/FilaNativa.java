import java.util.Queue;

class PilhaNativa {
   public static void main (String [] args) {
      Queue fila = new Queue();

      fila.push("Atlético-MG");
      fila.push("Cruzeiro");
      fila.push("América");

      while(fila.empty() == false){
        System.out.println("Retirando da fila: " + fila.pop());
      }
   }
}
