class Ponteiro08Objeto {
   public static void main(String args[]){
      Cliente c1 = new Cliente(1, "aa");
      Cliente vet[] = new Cliente [5];

      System.out.println("c1 -->> [" + c1 + "] -- [" + c1.getCodigo() + "/" + c1.getNome() + "]");

      for(int i = 0; i < vet.length; i++){
         vet[i] = c1.clone();
         System.out.println("vet["+ i +"] -->> [" + vet[i] + "] -- [" + vet[i].getCodigo() + "/" + vet[i].getNome() + "]");
      }
   }
}

