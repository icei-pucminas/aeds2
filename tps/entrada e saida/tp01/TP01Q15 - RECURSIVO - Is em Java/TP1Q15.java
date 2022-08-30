class TP1Q15 {

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'); // verifica se o
                                                                                                    // pub.in chegou ao
                                                                                                    // FIM
    }

    boolean isConsoante(String s, int p) {
        boolean resp = true;

        s = s.toLowerCase();

        if (p < s.length()) {
            if ((s.charAt(p) == 'a' || s.charAt(p) == 'e' || s.charAt(p) == 'i' || s.charAt(p) == 'o'
                    || s.charAt(p) == 'u')) {

                resp = false;
                
            }

            else
                return isConsoante(s, p + 1);

        }

        return resp;
    }

    boolean isVogal(String s, int p) {
        boolean resp = true;

        s = s.toLowerCase();

        if (p < s.length()) {
            if ((s.charAt(p) != 'a' || s.charAt(p) != 'e' || s.charAt(p) != 'i' || s.charAt(p) != 'o'
                    || s.charAt(p) != 'u')) {

                resp = false;

            }

            else
                return isVogal(s, p + 1);

        }

        return resp;
    }

    public static void main(String[] args) {
        String[] entrada = new String[1000];
        int numEntrada = 0;

        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM
    }

}