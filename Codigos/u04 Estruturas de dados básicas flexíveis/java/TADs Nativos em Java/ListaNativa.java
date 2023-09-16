import java.util.Vector;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

class ListaNativa {
   public static void main (String [] args) {
      Vector<String> vector = new Vector<String>();
      ArrayList<String> arrayList = new ArrayList<String>();
      LinkedList<String> linkedList = new LinkedList<String>();

      vector.add("Atlético-MG");
      arrayList.add("Atlético-MG");
      linkedList.add("Atlético-MG");
      vector.add("Cruzeiro");
      arrayList.add("Cruzeiro");
      linkedList.add("Cruzeiro");
      vector.add("América");
      arrayList.add("América");
      linkedList.add("América");

      System.out.println("Tamanhos:" + vector.size() + " -- " + arrayList.size() + " -- " + linkedList.size());
      System.out.println("get(index): " + (String)vector.get(0) + " -- " + (String)arrayList.get(1) + " -- " + (String)linkedList.get(2));

      for (Iterator i = vector.iterator(); i.hasNext();){
         System.out.println("Vector: " + (String)i.next());
      }
      for (Iterator i = arrayList.iterator(); i.hasNext();){
         System.out.println("ArrayList: " + (String)i.next());
      }
      for (Iterator i = linkedList.iterator(); i.hasNext();){
         System.out.println("LinkedList: " + (String)i.next());
      }
   }
}

