class ExercicioDuvidaAND {
   public static boolean m1(){
      System.out.println("m1");
      return false;
   }
   public static boolean m2(){
      System.out.println("m2");
      return true;
   }
   public static void main (String[] args) {
      System.out.println("inicio");
      boolean and = m1() && m2();
      System.out.println("============");
      boolean or = m2() || m1();
      System.out.println("fim: and(" + and + ") or (" + or + ")");
   }
}
