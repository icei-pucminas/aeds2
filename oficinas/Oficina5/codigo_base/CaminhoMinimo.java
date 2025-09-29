import java.util.Scanner;

// Classe para representar uma cidade
// Possui um nome, um array e vizinhos e um array de distância para os respectivos vizinhos do outro array
class Cidade {
    public String nome;
    public String[] vizinhos;
    public int[] distancias;
    public int qtdVizinhos;

    Cidade(String nome, int maxVizinhos) {
        this.nome = nome;
        this.vizinhos = new String[maxVizinhos];
        this.distancias = new int[maxVizinhos];
        this.qtdVizinhos = 0;
    }

    public void addVizinho(String nomeVizinho, int distancia) {
        vizinhos[qtdVizinhos] = nomeVizinho;
        distancias[qtdVizinhos] = distancia;
        qtdVizinhos++;
    }
}

// Classe para os elementos da heap
class HeapElemento {
    public String nome;
    public int distancia;

    HeapElemento(String nome, int distancia) {
        this.nome = nome;
        this.distancia = distancia;
    }
}

public class CaminhoMinimo {

    // Vetor da Heap
    public static HeapElemento[] heap;
    public static int heapTamanho;


    public static void swap(int i, int j) {
        HeapElemento tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    public static void printHeap(){
       for(int i=0; i<heapTamanho; i++){
            System.out.print("(" + heap[i].nome + ", " + heap[i].distancia + ") ");
        }
        System.out.println();
    }

    public static void heapifyUp(int i) {
        // TO DO: implementar correção para cima
        // usada quando se altera o valor de um elemento para um valor menor
    }

    public static void heapifyDown(int i) {
        // TO DO: implementar correção para baixo
        // usado quando o último elemento é jogado para o topo quando um pop é realizado
    }

    public static void push(String cidade, int dist) {
        // TO DO: inserir cidade e chamar heapifyUp
    }

    public static HeapElemento pop() {
        // TO DO: remover e retornar o elemento com menor distância e chamar heapifyDown
        return null; //trocar de null para o elemento retirado da heap
    }

    // ==============================
    // Função esqueleto do algoritmo de Caminho Mínimo
    // ==============================
    public static void calculaCaminhoMinimo(Cidade[] cidades, int N) {
        // Enquanto a heap não estiver vazia:
        //   1. Retirar (pop) a cidade com menor distância
        //   2. Para cada vizinho da cidade retirada:
        //        - calcular nova distância = distância até a cidade atual + distância para o vizinho
        //        - se nova distância < distância registrada no vizinho:
        //              atualizar a distância do vizinho
        //              corrigir a heap (heapifyUp / heapifyDown)

        printHeap();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // número de cidades
        int M = sc.nextInt(); // número de estradas

        Cidade[] cidades = new Cidade[N];
        String nome;

        // Leitura e criação das cidades
        for (int i = 0; i < N; i++) {
            nome = sc.next();
            cidades[i] = new Cidade(nome, N); // cada cidade pode ter até N vizinhos
        }

        // Leitura e criação dos vizinhos (a partir das estradas)
        for (int i = 0; i < M; i++) {
            String A = sc.next();
            String B = sc.next();
            int d = sc.nextInt();

            for (int j = 0; j < N; j++) {
                if (cidades[j].nome.equals(A))
                    cidades[j].addVizinho(B, d);
                if (cidades[j].nome.equals(B))
                    cidades[j].addVizinho(A, d);
            }
        }

        // Inicialização da heap
        heap = new HeapElemento[N];
        heapTamanho = N;

        final int INF = Integer.MAX_VALUE; // a constante INF recebe o maior valor possível para um inteiro

        // Inicializa cidades com distância infinita
        for (int i = 0; i < N; i++) {
            heap[i] = new HeapElemento(cidades[i].nome, INF);
        }

        // Considere que Belo Horizonte sempre começa na posição 0
        heap[0].distancia = 0;
        

        // Chamada do algoritmo
        calculaCaminhoMinimo(cidades, N);

        sc.close();
    }
}
