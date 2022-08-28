import java.io.RandomAccessFile;

public class q9 {

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'); // verifica se o
                                                                                                    // pub.in chegou ao
                                                                                                    // FIM
    }

    public static boolean isDouble(String s) {
        boolean resp = true;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.')
                resp = true;

            else
                resp = false;

        }

        return resp;
    }

    public static void main(String[] args) throws Exception {

        RandomAccessFile raf = new RandomAccessFile("pub.in", "rw");
        RandomAccessFile rfa = new RandomAccessFile("pub.out", "rw");

        raf.seek(0);
        
        int total = raf.readInt();

        for (int i = total + 1; i >= 1; i--) {
            raf.seek(i);
            String valor = raf.readLine();

            if (isDouble(valor) == true)
                rfa.writeDouble(raf.readDouble());

            else
                rfa.writeInt(raf.readInt());

        }

        raf.close();
        rfa.close();

    }
}
