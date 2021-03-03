import java.util.Vector;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

class ListaNativa {
   public static void main (String [] args) {
      Vector ve = new Vector();
      ArrayList al = new ArrayList();
      LinkedList ll = new LinkedList();

      ve.add("Atlético-MG");
      al.add("Atlético-MG");
      ll.add("Atlético-MG");
      ve.add("Cruzeiro");
      al.add("Cruzeiro");
      ll.add("Cruzeiro");
      ve.add("América");
      al.add("América");
      ll.add("América");

      System.out.println("Tamanhos:" + ve.size() + " -- " + al.size() + " --" + ll.size());
      System.out.println("get(index): " + (String)ve.get(0) + " -- " + (String)al.get(1) + " -- " + (String)ll.get(2));

      for (Iterator i = ve.iterator(); i.hasNext();){
         System.out.println((String)i.next());
      }
      for (Iterator i = al.iterator(); i.hasNext();){
         System.out.println((String)i.next());
      }
      for (Iterator i = ll.iterator(); i.hasNext();){
         System.out.println((String)i.next());
      }
   }
}
