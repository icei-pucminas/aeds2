class Principal {
   public static void main (String[] args) throws Exception {
      Patricia arv = new Patricia();

      String array[] = new String[18];

      array[0] = "bear";
      array[1] = "bell";
      array[2] = "bid";
      array[3] = "bull";
      array[4] = "buy";
      array[5] = "sell";
      array[6] = "stock";
      array[7] = "stop";
      array[8] = "sapo";
      array[9] = "sapato";
      array[10] = "ABACAXI";
      array[11] = "BALA";
      array[12] = "BOLO";
      array[13] = "ABACATE";
      array[14] = "galo";
      array[15] = "pata";
      array[16] = "pato";
      array[17] = "gato";
      //array[17] = "ABAC";
      //array[17] = "ABACAXIS";
      arv.setArray(array);

      arv.mostrar();
      for(int i = 0; i < array.length; i++){
         System.out.println("Pesquisar(" + array[i] + "):" + arv.pesquisar(array[i]));
      }

      String s = "ABACA";
      System.out.println("Pesquisar(" + s + "):" + arv.pesquisar(s));

      s = "ABACAXIS";
      System.out.println("Pesquisar(" + s + "):" + arv.pesquisar(s));

      s = "gaga";
      System.out.println("Pesquisar(" + s + "):" + arv.pesquisar(s));

      s = "ABAC";
      System.out.println("Pesquisar(" + s + "):" + arv.pesquisar(s));
      
   }
}
