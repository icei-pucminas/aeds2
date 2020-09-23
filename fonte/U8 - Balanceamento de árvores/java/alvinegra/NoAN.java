/**
 * NoAN da arvore binaria
 * @author Max do Val Machado
 */
class NoAN{
  public boolean cor;
  public int elemento;
  public NoAN esq, dir;
  public NoAN (){
      this(-1);
  }
  public NoAN (int elemento){
      this(elemento, false, null, null);
  }
  public NoAN (int elemento, boolean cor){
      this(elemento, cor, null, null);
  }
  public NoAN (int elemento, boolean cor, NoAN esq, NoAN dir){
    this.cor = cor;
    this.elemento = elemento;
    this.esq = esq;
    this.dir = dir;
  }
}
