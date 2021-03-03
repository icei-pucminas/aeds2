import java.util.Stack;

class PilhaNativa {
   public static void main (String [] args) {
      Stack pilha = new Stack();

      pilha.push("Atlético-MG");
      pilha.push("Cruzeiro");
      pilha.push("América");

      while(pilha.empty() == false){
        System.out.println("Retirando da pilha: " + pilha.pop());
      }
   }
}
