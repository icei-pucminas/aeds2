class Lixao{
   public static void main(String[] args){
      Estatico e1 = new Estatico();
      Estatico e2 = new Estatico();

      System.out.println("(1) ==================================");
      Estatico.numeroEstatico = 1;
      System.out.println(Estatico.numeroEstatico);
      System.out.println(e1.numeroEstatico);
      e1.numeroEstatico = 3;
      System.out.println(e2.numeroEstatico);

      e1.numeroNaoEstatico = 2;
      e2.numeroNaoEstatico = 4;
      System.out.println(e1.numeroNaoEstatico);

      //Error non-static variable numeroNaoEstatico cannot be referenced from a static context
      //Estatico.numeroNaoEstatico = 10;

      System.out.println("(2) ==================================");
      Estatico.metodoEstatico();
      e1.metodoNaoEstatico();
      //Estatico.metodoNaoEstatico();
   }
}

