class Estatico {
   public static int numeroEstatico;
   public int numeroNaoEstatico;

   public Estatico(){
       numeroEstatico = 0;
   }

   public static void metodoEstatico(){
       System.out.println("Metodo Estatico: " + numeroEstatico);
   }

   public void metodoNaoEstatico(){
       System.out.println("Metodo Nao Estatico: " + numeroEstatico + " / " + numeroNaoEstatico);
   }
   public void setEstatico(int valor){
       numeroEstatico = valor;
   }
}
