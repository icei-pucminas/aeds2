package TT03.U00f;

class ExemploArq01Escrita {
    public static void main(String[] args) {
        Arq.openWrite("exemplo.txt");
        Arq.println(1);
        Arq.println(5.3);
        Arq.println('X');
        Arq.println(true);
        Arq.println("Algoritmos");
        Arq.close();
    }
}
