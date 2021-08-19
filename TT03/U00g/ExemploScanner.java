package TT03.U00g;

class ExemploScanner{
    public static void main(String[] args) {
        String str = MyIO.readString();
        char c = MyIO.readChar();
        char enter = MyIO.readChar();
        int i = MyIO.readInt();
        float f = MyIO.readFloat();

        MyIO.println(str);
        MyIO.println(c);
        MyIO.println(i);
        MyIO.println(f);
    }
}