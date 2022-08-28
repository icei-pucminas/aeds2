class TP1Q11 {

    static boolean isFim(String s) {
        return ((s.charAt(0) == 'F') && s.charAt(1) == 'I' && (s.charAt(2) == 'M') && (s.length() == 3));

    }

    static boolean isPalindromo(String s, int i, int j) {
        boolean resp = true;

        if (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                resp = false;

            else
                resp = isPalindromo(s, i + 1, j - 1);
        }

        return resp;
    }

    public static void main(String[] args) {
        String[] entrada = new String[1000];

        int numEntrada = 0;

        do {
            entrada[numEntrada] = MyIO.readLine();

        } while (isFim(entrada[numEntrada++]) == false);

        for (int i = 0; i < numEntrada; i++) {

            isPalindromo(entrada[i], 0, entrada.length - 1);

        }

    }

}