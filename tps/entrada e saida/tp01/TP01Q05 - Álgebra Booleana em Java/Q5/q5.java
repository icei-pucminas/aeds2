class q5 {

    public static boolean isFim(String s) {
        return (s.length() == 1 && s.charAt(0) == '0'); // verifica se o pub.in chegou ao FIM

    }

    public static char isOr(String s) {
        char resp = 0;

        s.replaceAll(",", "");

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '1') {
                resp = 1;
                break;
            }

            else
                resp = 0;

        }

        return resp;
    }

    public static char isNot(String s) {
        char resp = 0;

        s.replaceAll(",", "");

        if (s.charAt(0) == '1')
            resp = 0;

        else if (s.charAt(0) == '0')
            resp = 1;

        return resp;
    }

    public static char isAnd(String s) {
        char resp = 0;

        s.replaceAll(",", "");

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                resp = 0;
                break;
            }

            else
                resp = 1;

        }

        return resp;
    }

    public static char[] converteString(String s) {

        s.replaceAll(" ", "");

        char sConv[] = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'A')
                sConv[i] = sConv[1];

            else if (s.charAt(i) == 'B')
                sConv[i] = sConv[2];

            else if (s.charAt(i) == 'C')
                sConv[i] = sConv[3];

        }

        return sConv;

    }

    public static String analiseExpressao(String s) {

        char sConv[] = converteString(s);
        int pos1 = 0;
        int pos2 = 0;

        StringBuilder sb = new StringBuilder();

        
        int subs;
        String subStr = null;

        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == ')') {
                pos1 = i;
                break;
            }

        for (int i = pos1; i > pos1 - 1; i--)
            if (s.charAt(i) == '(') {

                pos2 = i;
                break;

            }

        if (s.charAt(pos2 - 1) == 't') {
            subs = isNot(s.substring(pos1 + 1, pos2 - 1));
            subStr = s.substring(pos1 + 1, pos2 - 1);
            /*for (int i = pos1 - 3; i <= pos2; i++) {

            }*/

            s.replace(subStr, subs);

        }

        else if (s.charAt(pos2 - 1) == 'd') {
            subs = isAnd(s.substring(pos1 + 1, pos2 - 1));
        }

        else if (s.charAt(pos2 - 1) == 'r') {
            subs = isOr(s.substring(pos1 + 1, pos2 - 1));
        }

        String resp = sConv.toString();

        /*
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         */

        if (resp.length() > 1)
            return analiseExpressao(resp);

        else
            return resp;

    }

    public static void main(String[] args) {
        String[] entrada = new String[1000];
        int numEntrada = 0;

        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsidera a ultima linha contendo a palavra FIM
    }

}
