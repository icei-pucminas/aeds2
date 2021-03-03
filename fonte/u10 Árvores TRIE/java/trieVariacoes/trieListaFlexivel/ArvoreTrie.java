class ArvoreTrie {
    private No raiz;

    public ArvoreTrie(){
        raiz = new No();
    }

    public void inserir(String s) throws Exception {
        inserir(s, raiz, 0);
    }

    private void inserir(String s, No no, int i) throws Exception {
        System.out.print("\nEM NO(" + no.elemento + ") (" + i + ")");
        No filho = no.pesquisar(s.charAt(i));
        if(filho == null){
            System.out.print("--> criando filho(" + s.charAt(i) + ")");
            filho = no.inserir(s.charAt(i));

            if(i == s.length() - 1){
                System.out.print("(folha)");
                no.setFilhoFolha(s.charAt(i));
            }else{
                inserir(s, filho, i + 1);
            }

        } else if (filho.folha == false && i < s.length() - 1){
            inserir(s, filho, i + 1);

        } else {
            throw new Exception("Erro ao inserir!");
        } 
    }


    public boolean pesquisar(String s) throws Exception {
        return pesquisar(s, raiz, 0);
    }

    public boolean pesquisar(String s, No no, int i) throws Exception {
        boolean resp;
        No filho = no.pesquisar(s.charAt(i));
        if(filho == null){
            resp = false;
        } else if(i == s.length() - 1){
            resp = (filho.folha == true);
        } else if(i < s.length() - 1 ){
            resp = pesquisar(s, filho, i + 1);
        } else {
            throw new Exception("Erro ao pesquisar!");
        }
        return resp;
    }


    public void mostrar(){
        mostrar("", raiz);
    }

    public void mostrar(String s, No no) {
        if(no.folha == true){
            System.out.println("Palavra: " + (s + no.elemento));
        } else {
            No[] filho = no.getFilho();
            for(int i = 0; i < filho.length; i++){
                 System.out.println("ESTOU EM (" + no.elemento + ") E VOU PARA (" + filho[i].elemento + ")");
                 mostrar(s + no.elemento, filho[i]);
            }
        }
    }
}

