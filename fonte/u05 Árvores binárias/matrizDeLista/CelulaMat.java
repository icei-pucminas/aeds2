class CelulaMat {
   public int elemento;
   public CelulaMat inf, sup, esq, dir;
   public Celula primeiro, ultimo;

   public CelulaMat(){
      this(0);
   }

   public CelulaMat(int elemento){
      this(elemento, null, null, null, null);
   }

   public CelulaMat(int elemento, CelulaMat inf, CelulaMat sup, CelulaMat esq, CelulaMat dir){
      this.elemento = elemento;
      this.inf = inf;
      this.sup = sup;
      this.esq = esq;
      this.dir = dir;
      this.primeiro = this.ultimo = new Celula();
   }
}
