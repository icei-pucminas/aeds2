public class exercicio1 {
    public static void main(String[] args) {
        int men = 0;
        int mai = 0;

        int[] array = { 1, 9, 17, 86, 17, 80, 0 };
        for (int i = 0; i < array.length; i++) {        //FUNÇÃO DE COMPLEXIDADE = N
            if (array[i] < men)
                men = array[i];
            else if (array[i] > mai)
                mai = array[i];
        }

        MyIO.print(men);
        MyIO.print(mai);
    }

}
