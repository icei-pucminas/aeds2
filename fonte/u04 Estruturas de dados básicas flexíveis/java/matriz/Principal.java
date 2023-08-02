class Principal {

   public static void main(String[] args){
      Matriz m1, m2, soma, m3, m4, multiplicao;

      m1 = new Matriz(MyIO.readInt("Digite o numero de linhas (M1): "), MyIO.readInt("Digite o numero de colunas (M1): "));
      m2 = new Matriz(MyIO.readInt("Digite o numero de linhas (M2): "), MyIO.readInt("Digite o numero de colunas (M2): "));
      m3 = new Matriz(MyIO.readInt("Digite o numero de linhas (M3): "), MyIO.readInt("Digite o numero de colunas (M3): "));
      m4 = new Matriz(MyIO.readInt("Digite o numero de linhas (M4): "), MyIO.readInt("Digite o numero de colunas (M4): "));


      m1.ler();
      m2.ler();
      m3.ler();
      m4.ler();

      //Somar as duas matrizes e salvar o resultado na matriz soma
      soma = m1.soma(m2); //verifique se eh possivel somar

      //Imprimir a matriz 1
      soma.print();

      //Multiplicar duas matrizes e salvar o resultado na matriz multiplicacao
      multiplicacao = m3.multiplicacao(m4); //verifique se eh possivel multiplicar

      //Imprimir a matriz 1
      multiplicacao.print();

   }
}
