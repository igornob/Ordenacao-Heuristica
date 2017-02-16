import java.util.ArrayList;
import java.util.Scanner;

public class Principal{
    /***************************************************************************
     * Verifica se existe algum elemento negativo na entrada
    ***************************************************************************/
    public static boolean existeNegativo(int[] vetor) {
        for(int i = 0; i < vetor.length; i++) {
            System.out.println(i);
            if(vetor[i] < 0)
                return true;
        }

        return false;
    }

    /***************************************************************************
     * Verifica se existe algum elemento com mais que 8 dígitos e com menos
     * que 10
    ***************************************************************************/
    public static boolean verificaEntradaGrande(int[] vetor) {
        for(int i = 0; i < vetor.length; i++) {
            //System.out.println(i);
            if(vetor[i] > -1147483648 && vetor[i] < 1147483647)
				return true;
			//if(vetor[i] > 999999999 && vetor[i] < -999999999)
				
        }

        return false;
    }

    /***************************************************************************
     * Executa o algoritmo de ordenação mais adequado
    ***************************************************************************/
    public static void aplicaHeuristica(ArrayList<Integer> lista, int[] vetor) {
        if(existeNegativo(vetor) && verificaEntradaGrande(vetor)) {
            System.out.println("---------------------------- \n Executando CountingSort\n----------------------------");
			System.out.println("Executado por causa da existência números negativos e positivos e entrada com tamanho suportável");
            CountSort c = new CountSort();
            c.Countsort(vetor);
		} else if(!existeNegativo(vetor) && verificaEntradaGrande(vetor)) {
            System.out.println("---------------------------- \n Executando BucketSort\n----------------------------");
			System.out.println("Executado por conter apenas números positivos e entrada com tamanho suportável");
            BucketSort b = new BucketSort();
            b.Bucketsort(vetor);
        } else if(!verificaEntradaGrande(vetor)) {
            System.out.println("---------------------------- \n Executando QuickSort\n----------------------------");
			System.out.println("Executado por causa do tamanho dos elementos contidos na entrada ");
            QuickSort q = new QuickSort();
            q.sort(lista);
        } else {
			System.out.println("Não foi possível executar nenhum algoritmo para essa entrada");		
		}
    }

    /***************************************************************************
     * Main
    ***************************************************************************/
    public static void main(String[] args) {
	
    Scanner input = new Scanner(System.in);
	int n = input.nextInt();

    ArrayList<Integer> entrada_l = new ArrayList<Integer>();
    int[] entrada_a = new int[n];


    //Coloca os elementos da entrada no ArrayList
    for(int i = 0; i < n; i++){
        entrada_l.add(input.nextInt());
    }

    /*Copiando o ArrayList para um array, visto que os algoritmos lineares foram
    implementados usando arrays e os de comparação usando ArrayList, assim temos as duas opções*/
    for(int i = 0; i < n; i++) {
        entrada_a[i] = entrada_l.get(i);
    }

    aplicaHeuristica(entrada_l, entrada_a);

    }

}
