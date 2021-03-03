class Principal {
   public static void main (String[] args) throws Exception {
      ArvoreTrie arv = new ArvoreTrie();

      String array[] = new String[8];
      array[0] = "ABACAXI";
      array[1] = "BALA";
      array[2] = "BOLO";
      array[3] = "ABACATE";
      array[4] = "galo";
      array[5] = "pata";
      array[6] = "pato";
      array[7] = "gato";

      for(int i = 0; i < array.length; i++){
         arv.inserir(array[i]);
      }
      arv.mostrar();
      for(int i = 0; i < array.length; i++){
         System.out.println("Pesquisar(" + array[i] + "):" + arv.pesquisar(array[i]));
         System.out.println("PesquisarI(" + array[i] + "):" + arv.pesquisarI(array[i]));
      }

      String s = "ABACA";
      System.out.println("Pesquisar(" + s + "):" + arv.pesquisar(s));
      System.out.println("PesquisarI(" + s + "):" + arv.pesquisarI(s));

      s = "ABACAXIS";
      System.out.println("Pesquisar(" + s + "):" + arv.pesquisar(s));
      System.out.println("PesquisarI(" + s + "):" + arv.pesquisarI(s));

      s = "gaga";
      System.out.println("Pesquisar(" + s + "):" + arv.pesquisar(s));
      System.out.println("PesquisarI(" + s + "):" + arv.pesquisarI(s));
      
   }
}
