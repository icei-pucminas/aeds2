class ExemploMyIO {
   public static void main (String[] args){
      String str = MyIO.readString("Entre com uma palavra: ");
      int inteiro = MyIO.readInt("Entre com um inteiro: ");
      double real = MyIO.readDouble("Entre com um real: ");
      char caractere = MyIO.readChar("Entre com um caractere: ");

      MyIO.println("Sua string: " + str);
      MyIO.println("Seu inteiro: " + inteiro);
      MyIO.println("Seu real: " + real);
      MyIO.println("Seu caractere: " + caractere);
   }
}
