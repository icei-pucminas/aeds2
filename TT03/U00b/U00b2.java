class U00b2 {
    public static void main(String[] args) {
        int[] v = { 1, 3, 8, 17, 32, 245, 1010, 2021 };
        int x = 1204;

        System.out.println(isContido(v, x));
    }

    public static boolean isContido(int[] v, int x) {
        int d = v.length - 1, e = 0, meio = 0;

        while(d >= e){
            meio = (e + d) / 2;

            if(v[meio] == x){
                e = v.length;
                return true;
            }else if(x > v[meio]){
                e = meio + 1;
            }else{
                d = meio - 1;
            }
        }
        
        return false;
    }
}
