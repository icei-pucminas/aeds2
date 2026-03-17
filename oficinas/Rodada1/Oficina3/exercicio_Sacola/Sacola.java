import java.util.Scanner;

class Sacola{
	public static int[] pilha;
	public static int[] fila;
	public static int[] prioridade;
	public static int n;

	public static void inserir(int x){
		pilha[n] = x;
		fila[n] = x;
		prioridade[n] = x;
		n++;
	}

	public static int pop(){
		int aux = pilha[n-1];
		return aux;
	}

	public static int dequeue(){
		int aux = fila[0];
		for(int i=0; i<n-1; i++){
			fila[i] = fila[i+1];
		}
		return aux;
	}

	public static int dequeuePriority(){
		int maior = 0;
		for(int i=1; i<n; i++){
			if(prioridade[maior] < prioridade[i]){
				maior = i;
			}
		}
		
		int aux = prioridade[maior];
		for(int i=maior; i<n-1; i++){
			prioridade[i] = prioridade[i+1];
		}
		return aux;
	}
	
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()){
			int num = sc.nextInt();
			pilha = new int[num];
			fila = new int[num];
			prioridade = new int[num];
			n = 0;
			int ehPilha = 1;
			int ehFila = 1;
			int ehPrioridade = 1;
			for(int i=0; i<num; i++){
				int opcao = sc.nextInt();
				if(opcao == 1){
					int x = sc.nextInt();
					inserir(x);
				}else{
					int esperado = sc.nextInt();
					int removidoPilha = pop();
					int removidoFila = dequeue();
					int removidoPrioridade = dequeuePriority();
					n--;

					if(esperado != removidoPilha) ehPilha = 0;
					if(esperado != removidoFila) ehFila = 0;
					if(esperado != removidoPrioridade) ehPrioridade = 0;
				}
			}
			int soma = ehPilha + ehFila + ehPrioridade;
			if(soma == 0) System.out.println("impossible");
			else if(soma > 1) System.out.println("not sure");
			else if(ehPilha == 1) System.out.println("stack");
			else if(ehFila == 1) System.out.println("queue");
			else if(ehPrioridade == 1) System.out.println("priority queue");
		}
		sc.close();
	}
}
