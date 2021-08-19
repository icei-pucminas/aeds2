public class U00b4 {
    public static void main(String[] args) {
        int[] v = { 2, 3, 10, 15, 19, 28, 37, 90, 402, 928, };
    
        maiorMenor(v);
      }
    
      public static void maiorMenor(int[] v) {
        int menor = v[0], maior = 0;

        MyIO.println("Maior = " + maior);
        MyIO.println("Menor = " + menor);
      }
}
