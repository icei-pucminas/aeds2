class Patricia {
   No raiz;
   String[] array; //ignorar questão de tamanho do array

   public Patricia(){
      raiz = new No();
      array = null;
   }

   public void setArray(String[] array) throws Exception {
      this.array = array;
      for(int i = 0; i < array.length; i++){
         inserir(i);
      }
   }

   private String string(No no){
      return (no == raiz) ? " " : string(no.i, no.j, no.k);
   }
   private String string(int i, int j, int k){
      //System.out.println("i("+i+") j("+j+") k("+k+") array(i)("+array[i]+") ijk(" + array[i].substring(j,k+1) + ")");
      return array[i].substring(j,k+1);
   }

   public void inserir(int i) throws Exception {
      System.out.print("\n==================================================== INSERINDO : " + array[i]);
      inserir(raiz, i, 0);
      mostrar();
   }
   private void inserir(No no, int i, int j) throws Exception {

      System.out.println("\nEM NO(" + string(no) + ") i("+ i +") j(" + j + ")");

      if(no.prox[array[i].charAt(j)] == null){
         no.prox[array[i].charAt(j)] = new No(i, j, array[i].length()-1, true);
         System.out.print("--> criando folha(" + array[i].charAt(j) + "/" + string(no.prox[array[i].charAt(j)]) + ")");

      } else {
         String prox = string(no.prox[array[i].charAt(j)]);
         String inserindo = array[i].substring(j);
         System.out.println("prox(" + prox + ") e inserindo(" + inserindo + ")");

         int k;
         for(k = 1; k < prox.length() && k < inserindo.length() && prox.charAt(k) == inserindo.charAt(k); k++);
         System.out.println("k (" + k + ")");

         if(k == prox.length()){
            if(no.prox[array[i].charAt(j)].folha == true){
               throw new Exception("Erro: exite um prefixo de [" + array[i] + "] na arvore");
            } else {
               inserir(no.prox[array[i].charAt(j)], i, j + k);
            }
         } else if (k == inserindo.length()){
            throw new Exception("Erro: [" + array[i] + "] é prefixo de outra palavra da árvore");
         } else {
            No novo = new No(i, j, j + k - 1, false);
            novo.prox[prox.charAt(k)] = no.prox[array[i].charAt(j)];
            novo.prox[prox.charAt(k)].j = j + k;
            novo.prox[inserindo.charAt(k)] = new No(i, j + k, array[i].length()-1, true);
            no.prox[array[i].charAt(j)] = novo;
            System.out.println("no(" + string(no) + ") e filhoNOVO(" + string(novo) + ") neto1(" + string(novo.prox[inserindo.charAt(k)]) + ") neto2(" + string(novo.prox[prox.charAt(k)]) + ")");
         }
      }
   }


   public boolean pesquisar(String s){
      System.out.println("\n==================================================== PESQUISAR: " + s);
      return pesquisar (raiz, s, 0);
   }
   public boolean pesquisar (No no, String s, int cont){
      boolean resp;

      System.out.println("EM NO(" + string(no) + ") s("+ s +") cont(" + cont + ") prox(" + no.prox[s.charAt(cont)] + ")");

      if(no.prox[s.charAt(cont)] == null){
         System.out.println("não existe filho para [" + s.charAt(cont) + "]");
         resp = false;
      } else {
         String prox = string(no.prox[s.charAt(cont)]);
         System.out.println("prox: " + prox);

         int i1, i2;
         for(i1 = 0, i2 = cont; i1 < prox.length() && i2 < s.length() && prox.charAt(i1) == s.charAt(i2); i1++, i2++);

         if(i2 == s.length()){
            System.out.println("resp = consumiuTodosOsCaracteresDeProx(" + (i1 == prox.length()) + ") and proxFolha(" + (no.prox[s.charAt(cont)].folha) + ")");
            resp = i1 == prox.length() && no.prox[s.charAt(cont)].folha;
         } else {
            resp = pesquisar(no.prox[s.charAt(cont)], s, i2);
         }
      }

      return resp;
   }

   public void mostrar(){
      System.out.println("\n==================================================== MOSTRAR: ");
      mostrar("", raiz);
   }

   public void mostrar(String s, No no) {
      if(no.folha == true){
         System.out.println("Palavra: " + (s + string(no)));
      } else {
         for(int i = 0; i < no.prox.length; i++){
            if(no.prox[i] != null){
               System.out.println("ESTOU EM (" + string(no) + ") E VOU PARA (" + string(no.prox[i]) + ")");
               mostrar(s + string(no), no.prox[i]);
            }
         }
      }
   }
   public int contarAs(){
      int resp = 0;
      if(raiz != null){
         resp = contarAs(raiz);
      }
      return resp;
   }

   public int contarAs(No no) {
      int resp = 0;
      String palavra = string(no);

      for(int i = 0; i < palavra.length(); i++){
         if(palavra.charat(i) == 'A'){
            resp++;
         }
      }

      if(no.folha == false){
         for(int i = 0; i < no.prox.length; i++){
            if(no.prox[i] != null){
               resp += contarAs(no.prox[i]);
            }
         }
      }
      return resp;
   }
}
