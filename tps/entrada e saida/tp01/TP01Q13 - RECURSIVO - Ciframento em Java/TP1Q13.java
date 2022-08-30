class TP1Q13 {
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'); // Verifica se a
                                                                                                    // palavra é o FIM
                                                                                                    // do arquivo

    }

    public static String converteString(String s, int pos) {

        StringBuilder textoConv = new StringBuilder(); // String que irá receber os caracteres convertidos

        if (pos < s.length()) {
            int textInt = ((int) s.charAt(pos) + 3); // recebe o caracter na posição i, converte em int e adiciona a chave
                                                   // 3

            while (textInt > 126) // while que realiza a checkagem do char
                textInt -= 94;

            textoConv.append((char) textInt); // adiciona o char à string final

            return converteString(s, pos + 1);
        }

        return textoConv.toString(); // retorna a string convertida

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

            MyIO.println(converteString(entrada[i], 0));

        }
    }
}
