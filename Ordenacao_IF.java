public interface Ordenacao_IF {
    boolean checaVetorOrdenado(int[] numeros);
	
    int[] insertionSort(int[] numeros);

    void mergeSort( int inicio, int fim, int[] numeros);

    void quickSort(int[] numeros, int esq, int dir);

    void randomQuickSort(int[] numeros, int esq, int dir);

    int[] quickSortJava(int[] numeros);

    void heapSort(int[] numeros);

    int[] countingSort(int[] numeros);
    
}
