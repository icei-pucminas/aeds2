class Lixao{
    public static void main(String[] args){
        Visibilidade v = new Visibilidade();

        System.out.println("(1) ==================================");

        v.numeroPublico = 1;
        System.out.println(v.numeroPublico);

        //Error	numeroPrivado has private access in Visibilidade
        //v.numeroPrivado = 2;

        //Error	numeroPrivado has private access in Visibilidade
        //System.out.println(v.numeroPrivado);

        v.setNumeroPrivado(3);
        System.out.println(v.getNumeroPrivado());

        System.out.println("(2) ==================================");

        v.metodoPublico();

        //Error	metodoPrivado() has private access in Visibilidade
        //v.metodoPrivado();

        v.chamaPrivado();        
}    }
