class Visibilidade {
   public int numeroPublico;
   private int numeroPrivado;

   public Visibilidade(){
      numeroPublico = numeroPrivado = 0;
   }

   public void setNumeroPrivado(int valor){
      numeroPrivado = valor;
   }

   public int getNumeroPrivado(){
      return numeroPrivado;
   }

   public void metodoPublico(){
      System.out.println("Metodo Publico: " + numeroPublico + " / " + numeroPrivado);
   }

   private void metodoPrivado(){
      System.out.println("Metodo Privado: " + numeroPublico + " / " + numeroPrivado);
   }

   public void chamaPrivado(){
      metodoPrivado();
   }
}
