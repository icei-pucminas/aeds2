class TP1Q15 {

    static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'); // verifica se o
                                                                                                    // pub.in chegou ao
                                                                                                    // FIM
    }

    static boolean isConsoante(String s, int p) {   //verifica se a string só possui consoantes
        boolean resp = true;

        s = s.toLowerCase();            //padroniza as letras

        if (p < s.length()) {           //verifica se existe alguma vogal em qualquer local
            if ((s.charAt(p) == 'a' || s.charAt(p) == 'e' || s.charAt(p) == 'i' || s.charAt(p) == 'o'
                    || s.charAt(p) == 'u')) {

                resp = false;       //se o char analisado é uma vogal, a resposta é false

            }

            else
                return isConsoante(s, p + 1);           //se nao foi encontrada uma vogal, o metodo é chamado denovo com na proxima posição da string

        }

        return resp;
    }

    static boolean isVogal(String s, int p) {               //verifica se a string só possui vogais

        boolean resp = true;

        s = s.toLowerCase();                    //padroniza as letras

        if (p < s.length() - 1) {               //verifica se existe alguma consoante em qualquer local
            if ((s.charAt(p) != 'a' || s.charAt(p) != 'e' || s.charAt(p) != 'i' || s.charAt(p) != 'o'
                    || s.charAt(p) != 'u')) {

                resp = false;

            }

            else
                return isVogal(s, p + 1);           //se nao foi encontrada uma consoante, o metodo é chamado denovo com a proxima posição da string

        }

        return resp;
    }

    static boolean isInt(String s, int p) {                         //metodo que verifica se a entrada é um numero inteiro
        boolean resp = true;

        if (p < s.length()) { // verifica se a variavel p(para posição) é menor que o tamanho da string

            int textASCII = (int) s.charAt(p); // converte a entrada de char para int

            if (textASCII < 48 || textASCII > 57) {
                resp = false; // verifica se a entrada convertida está dentro dos numeros inteiros na tabela
                              // ASCII

            }

            else
                return isInt(s, p + 1);         //se o char foi identificado como numero, a metodo se chama novamente, passando a posição atual + 1 como parametro

        }

        return resp;
    }

    static boolean isDouble(String s, int p, int contV, int contP) {    //metodo que verifica se a entrada é um numero real
        boolean resp = false;

        if (isInt(s, 0) == true) {                   //como qualquer numero inteiro é real, se o metodo numInt retorna true, o numero é automaticamente real
            resp = true;
        }

        else {
            if (p < s.length()) {                               //o metodo se chama, contando a quantidade de '.' e ',' na string de entrada

                if (s.charAt(p) == ',')
                    return isDouble(s, p + 1, contV + 1, contP);

                else if (s.charAt(p) == '.')
                    return isDouble(s, p + 1, contV, contP + 1);

                else
                    return isDouble(s, p + 1, contV, contP);
            }

            if (contV > 1 || contP > 1)             //caso existam mais de um '.' ou ',' a resposta é false
                resp = false;

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

        for (int i = 0; i < numEntrada; i++) { // loop que printa os valores de cada metodo de acordo com a entrada

            if (isConsoante(entrada[i], 0) == true)
                MyIO.print("SIM ");
            else
                MyIO.print("NAO ");

            if (isVogal(entrada[i], 0) == true)
                MyIO.print("SIM ");
            else
                MyIO.print("NAO ");

            if (isInt(entrada[i], 0) == true)
                MyIO.print("SIM ");
            else
                MyIO.print("NAO ");

            if (isDouble(entrada[i], 0, 0, 0) == true)
                MyIO.print("SIM \n");
            else
                MyIO.print("NAO \n");

        }

    }
}