class AND_OR {
   public static boolean m1(){
      System.out.println("m1");
      return true;
   }
   public static boolean m2(){
      System.out.println("m2");
      return false;
   }
   public static void main (String[] args) {
      System.out.println("=====================");
      boolean or = m1() || m2();
      System.out.println("OR: " + or);
      System.out.println("=====================");
      boolean and = m2() && m1();
      System.out.println("AND: " + and);
      System.out.println("=====================");
   }
}
