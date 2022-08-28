class TP1Q03 {
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'); // Verifica se a
                                                                                                    // palavra é o FIM
                                                                                                    // do arquivo

    } //

    public static String converteString(String s) {

        StringBuilder textoConv = new StringBuilder(); // String que irá receber os caracteres convertidos

        for (int i = 0; i < s.length(); i++) { // loop que irá percorrer cada char da palavra

            int textInt = ((int) s.charAt(i) + 3); // recebe o caracter na posição i, converte em int e adiciona a chave
                                                   // 3

            while (textInt > 126) // realizar a checkagem dos char
                textInt -= 94;

            textoConv.append((char) textInt); // adiciona o char à string final

        }

        return textoConv.toString(); //retorna a string convertida
    }

    public static void main(String[] args) {

        String[] entrada = new String[1000];
        int numEntrada = 0;

        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

        for (int i = 0; i < numEntrada; i++) {
            MyIO.println(converteString(entrada[i]));
        }

    }
}
