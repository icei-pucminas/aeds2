class U00b1 {
  public static void main(String[] args) {
    int[] v = { 28, 2, 19, 402, 90, 15, 37, 928, 10, 3 };
    int x = 15;

    System.out.println(isContido(v, x));
  }

  public static boolean isContido(int[] v, int x) {
    int i = 0;

    for (i = 0; i < v.length; i++) {
      if (v[i] == x) {
        return true;
      }
    }
    return false;
  }
}
