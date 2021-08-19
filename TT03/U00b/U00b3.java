public class U00b3 {
    public static void main(String[] args) {
        int[] v = { 28, 2, 19, 402, 90, 15, 37, 928, 10, 3 };
    
        maiorMenor(v);
      }
    
      public static void maiorMenor(int[] v) {
        int i = 0, maior = 0, menor = v[0];
    
        for (i = 0; i < v.length; i++) {
          if(maior < v[i]){
            maior = v[i];
          }
          if(menor > v[i]){
            menor = v[i];
          }

        }

        MyIO.println("Maior = " + maior);
        MyIO.println("Menor = " + menor);
      }
}
