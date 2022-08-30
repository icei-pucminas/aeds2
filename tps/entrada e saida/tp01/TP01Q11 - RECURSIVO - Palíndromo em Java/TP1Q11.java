class TP1Q11 {

    static boolean isFim(String s) {
        return ((s.charAt(0) == 'F') && s.charAt(1) == 'I' && (s.charAt(2) == 'M') && (s.length() == 3)); //metodo que verifica se o arquivo chegou ao FIM

    }

    static boolean isPalindromo(String s, int i, int j) { //metodo que recebe string de cada linha do arquivo
        boolean resp = true;

        if (i <= j) {           //verifica se a ambas as metades da palavra foram analisadas
            if (s.charAt(i) != s.charAt(j))        //se algum char for diferente, a resposta é false 
                resp = false;

            else
                resp = isPalindromo(s, i + 1, j - 1);       //continua o loop por toda a palavra
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

            if(isPalindromo(entrada[i], 0, entrada[i].length() - 1) == true)
                MyIO.println("SIM");
            else
                MyIO.println("NAO");    


            

        }

    }

}