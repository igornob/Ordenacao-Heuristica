import java.util.ArrayList;

public class QuickSort {
    /*********************************************************************************
    * Método sort
    *********************************************************************************/
    public static void sort(ArrayList<Integer> vetor) {
		//vetor.remove(0);        
		int inicio = 0;
        int fim = vetor.size() - 1;
        quickSort(vetor, inicio, fim);
    }

    /*********************************************************************************
     * Nome: quickSort(ArrayList<Integer> vetor, int esquerda, int direita)
     * Descrição geral do algoritmo: 1 - Escolha um elemento pivô
     * 2 - Separe elementos menores que o pivô para a esquerda e elementos maiores
     * do que o pivô para a direita
     * 3 - Recursivamente, execute o mesmo procedimento para elementos a esquerda
     * do pivô
     * 4 - Recursivamente, execute o mesmo procedimento para elementos a direita
     * do pivô
    *********************************************************************************/
    private static void quickSort(ArrayList<Integer> vetor, int esquerda, int direita) {
    	if (esquerda < direita) {
        	int pivo = separar(vetor, esquerda, direita);//separa o vetor e o j guarda o valor do pivô
          	quickSort(vetor, esquerda, pivo-1);
            quickSort(vetor, pivo+1, direita);
        }
    }

    /*********************************************************************************
     * Método separar(int[] vetor, int[] auxiliar, int inicio, int meio, int fim)
     * Descrição: É um método auxiliar ao método quickSort, ajudando a dividir o vetor
    *********************************************************************************/
    private static int separar(ArrayList<Integer> vetor, int esquerda, int direita) {
    	int pivo = vetor.get(direita), i = esquerda;

    	for(int j = esquerda; j <= direita - 1; j++){
        	if(vetor.get(j).compareTo(pivo) < 1) {
            	int aux = vetor.get(i);
               	vetor.set(i, vetor.get(j));
               	vetor.set(j, aux);
               	i += 1;
           	}
       	}

       	int aux = vetor.get(i);
       	vetor.set(i, vetor.get(direita));
       	vetor.set(direita, aux);

       	return i;
	}
}
