class TP1Q01 {

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'); // verifica se o pub.in chegou ao FIM
    }

    public static boolean isPalindromo(String s) {          //recebe uma string como parametro
        boolean resposta = true;
        int metade = s.length() / 2, n;                     //divide a string ao meio

        for (n = 0; n < metade; n++) {
            if (s.charAt(n) != s.charAt(s.length() - 1 - n))        //o FOR realiza a comparação entre os caracteres opostos na string, e se houver diferença, o metodo retorna false
                resposta = false;

       }

        return resposta;
    }

    public static void main(String[] args) {
        String[] entrada = new String[1000];
        int numEntrada = 0;

        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsidera a ultima linha contendo a palavra FIM

        for (int i = 0; i < numEntrada; i++) {
            if (isPalindromo(entrada[i]) == true)
                MyIO.println("SIM");
            else
                MyIO.println("NAO");
        }

    }
}
