class TP01Q01 {

  public static boolean isFim(String s) {
    return (
      s.length() == 3 &&
      s.charAt(0) == 'F' &&
      s.charAt(1) == 'I' &&
      s.charAt(2) == 'M'
    );
  }

  public static void palindromo(String str, int n) {
    int x = 0, cont = 0;

    while (x < str.length()) {
      if (str.charAt(n) == str.charAt(x)) {
        n--;
        x++;
      }else{
        x = str.length() + 1;
      }
    }

    if (x == str.length()) {
      MyIO.println("SIM");
    } else {
      MyIO.println("NAO");
    }
  }

  public static void main(String[] args) {
    
    String[] entrada = new String[1000];

    int numEntrada = 0;
    //Leitura da entrada padrao
    do {
      entrada[numEntrada] = MyIO.readLine();
    } while (isFim(entrada[numEntrada++]) == false);
    numEntrada--; //Desconsiderar ultima linha contendo a palavra FIM

    for (int i = 0; i < numEntrada; i++) {
      palindromo(entrada[i], entrada[i].length() - 1);
    }
  }
}
