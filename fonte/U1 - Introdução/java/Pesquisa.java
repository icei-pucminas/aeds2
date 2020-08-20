class Pesquisa {
   public static boolean pesqSeq(int[] vet, int x){
      boolean resp = false;
      int n = vet.length;

      for(int i = 0; i < n; i++){
         if(vet[i] == x){
            resp = true;
            i = n;
         }
      }
      return resp;
   }

   public static boolean pesqBin(int[] vet, int x){
      boolean resp = false;
      int dir = (vet.length - 1), esq = 0, meio;

      while (esq <= dir){
         meio = (esq + dir) / 2;
         if(x == vet[meio]){
            resp = true;
            esq = dir + 1;
         } else if (x > vet[meio]) {
            esq = meio + 1;
         } else {
            dir = meio - 1;
         }
      }
      return resp;
   }

   public static boolean pesqBinRec(int[] vet, int x){
      return pesqBinRec(vet, x, 0, (vet.length - 1));
   }

   public static boolean pesqBinRec(int[] vet, int x, int esq, int dir){
      boolean resp;
      int meio = (esq + dir) / 2;

      if(esq > dir) {
         resp = false;
      } else if(x == vet[meio]){
         resp = true;
      } else if (x > vet[meio]) {
         resp = pesqBinRec(vet, x, meio + 1, dir);
      } else {
         resp = pesqBinRec(vet, x, esq, meio - 1);
      }
      return resp;
   }

   public static void main (String[] args){
      int[] vet = {2, 3, 5, 7, 9, 11, 15, 17, 20, 21, 30, 43, 49, 70, 71, 82};
      int x = 35;

      System.out.println("Pesquisa Sequencial: " + pesqSeq(vet, x));
      System.out.println("Pesquisa Binária: " + pesqBin(vet, x));
      System.out.println("Pesquisa Binária Recursiva: " + pesqBinRec(vet, x));
   }
}
