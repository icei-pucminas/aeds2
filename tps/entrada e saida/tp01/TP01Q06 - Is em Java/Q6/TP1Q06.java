public class TP1Q06 {

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'); // verifica se o
                                                                                                    // pub.in chegou ao
                                                                                                    // FIM
    }

    public static boolean soConsoante(String s) {       //verifica se a string só possui consoantes
        boolean resp = true;

        String sMod = s.toLowerCase();              //padroniza as letras

        for (int i = 0; i < s.length(); i++) {      //verifica se existe alguma vogal em qualquer local
            if (sMod.charAt(i) == 'a' || sMod.charAt(i) == 'e' || sMod.charAt(i) == 'i' || sMod.charAt(i) == 'o'
                    || sMod.charAt(i) == 'u') {
                resp = false;           //retorna false para somente consoantes caso exista uma vogal
                break;
            }
        }

        return resp;
    }

    public static boolean soVogal(String s) {           //verifica se a string só possui vogais
        boolean resp = true;

        String sMod = s.toLowerCase();                  //padroniza as letras

        for (int i = 0; i < s.length(); i++) {          //verifica se existe alguma consoante em qualquer local
            if (sMod.charAt(i) != 'a' || sMod.charAt(i) != 'e' || sMod.charAt(i) != 'i' || sMod.charAt(i) != 'o'
                    || sMod.charAt(i) != 'u') {
                resp = false;                              //retorna false para somente consoantes caso exista uma consoante
                break;
            }
        }

        return resp;
    }

    public static boolean numInt(String s) {            //metodo que verifica se a entra é um numero inteiro
        boolean resp = true;

        for (int i = 0; i < s.length(); i++) {          //o loop percorre a entrada verificando cada dígito separadamente
            int textASCII = (int) s.charAt(i);          //converte a entra de char para int

            if (textASCII < 48 || s.charAt(i) > 57) {
                resp = false;                           //verifica se a entra convertida está dentro dos numeros inteiros na tabela ASCII

            }

        }

        return resp;
    }

    public static boolean numDoub(String s) {           //metodo que verifica se a entra é um numero real
        boolean resp = true;

        int contV = 0;                                  //variaveis que realiza a contagem de pontos e virgulas
        int contPon = 0;

        if (numInt(s) == true)                          //como qualquer numero inteiro é real, se o metodo numInt retorna true, o numero é automaticamente real
            resp = true;

        else {
            for (int i = 0; i < s.length(); i++) {      //loop que percorre a string e verifica se existe mais de um "." ou ","
                if (s.charAt(i) == '.')
                    contPon++;

                else if (s.charAt(i) == ',') {
                    contV++;

                }
            }

            if (contPon != 1)                            //se o contador for diferente de 0, é retornado false
                resp = false;
            else if (contV != 1)
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
        numEntrada--; // Desconsidera a ultima linha contendo a palavra FIM

        for (int i = 0; i < numEntrada; i++) {              //loop que printa os valores de cada metodo de acordo com a entrada

            if (soConsoante(entrada[i]) == true)
                MyIO.print("SIM ");
            else
                MyIO.print("NAO ");

            if (soVogal(entrada[i]))
                MyIO.print("SIM ");
            else
                MyIO.print("NAO ");

            if (numInt(entrada[i]))
                MyIO.print("SIM ");
            else
                MyIO.print("NAO ");

            if (numDoub(entrada[i]))
                MyIO.print("SIM \n");
            else
                MyIO.print("NAO \n");

        }

    }
}
