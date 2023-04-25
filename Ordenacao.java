import java.util.Arrays;
import java.util.Random;

public class Ordenacao implements Ordenacao_IF{
    Random valor = new Random();
    @Override
    public boolean checaVetorOrdenado(int[] numeros){
        boolean check = false;
        for(int i = 0; i < numeros.length-1; i++){
            if (numeros[i] < numeros[i+1]){
                check = true;
            } 
        }
        return check;
    }
	
    @Override
    public int[] insertionSort(int[] numeros){
        int tamanho = numeros.length;
        for (int i = 0; i < tamanho; i++){
            int j = i;
            while((j > 0) && (numeros[j]<numeros[j-1])){
                int aux = numeros[j];
                numeros[j] = numeros[j-1];
                numeros[j-1] = aux;
                j--;
            }
        }
        return numeros;
    }
    

    public void intercala(int[] vetor, int inicio, int meio, int fim) {
        int novoVetor[] = new int[fim - inicio];
        int i = inicio;
        int m = meio;
        int pos = 0;

        while(i < meio && m < fim) {
            if(vetor[i] <= vetor[m]) {
                novoVetor[pos] = vetor[i];
                pos = pos + 1;
                i = i + 1;
            } else {
                novoVetor[pos] = vetor[m];
                pos = pos + 1;
                m = m + 1;
            }
        }

        while(i < meio) {
            novoVetor[pos] = vetor[i];
            pos = pos + 1;
            i = i + 1;
        }

        while(m < fim) {
            novoVetor[pos] = vetor[m];
            pos = pos + 1;
            m = m + 1;
        }

        for(pos = 0, i = inicio; i < fim; i++, pos++) {
            vetor[i] = novoVetor[pos];
        }
    }

    @Override
    public void mergeSort(int inicio, int fim, int[] vetor) {
        if(inicio < fim - 1) {
            int meio = (inicio + fim) / 2;

            mergeSort(inicio, meio, vetor);
            mergeSort(meio, fim, vetor);
            intercala(vetor, inicio, meio, fim);
        }
    }

    @Override
    public void quickSort(int[] vet, int left, int right){
        if(left<right){
            int pivo = partition(vet, left, right);
            quickSort(vet, left, pivo-1);
            quickSort(vet, pivo+1, right);
        }
    }

    public int partition(int[] vet, int left, int rigth){
        int p = vet[left];
        int i = left+1;
        int j = rigth;

        while(i<=j){
            if(vet[i] <= p){
                i++;
            }
            else if(vet[j] > p){
                j--;
            }
            else{
                swap(vet,i,j);
            }
        }
        swap(vet,left,j);
        return j;
    }

    public void swap(int[] vet, int i, int j){
        int temp = vet[i];
        vet[i] = vet[j];
        vet[j] = temp;
    }

    
	
   
    @Override
    public void randomQuickSort(int[] vet, int left, int right){
        if(left<right){
            int pivo = partition(vet, left, right);
            quickSort(vet, left, pivo-1);
            quickSort(vet, pivo+1, right);
        }
    }
    
    public int RandomPartition(int[] vet, int left, int rigth){
        int p = valor.nextInt(rigth);
        int i = left+1;
        int j = rigth;

        while(i<=j){
            if(vet[i] <= p){
                i++;
            }
            else if(vet[j] > p){
                j--;
            }
            else{
                swap(vet,i,j);
            }
        }
        swap(vet,left,j);
        return j;
    }
	
    @Override
    public int[] quickSortJava(int[] numeros){
        Arrays.sort(numeros, 0, numeros.length);
        return numeros;
    }
	
    @Override
    public void heapSort(int array[]){
        int N = array.length;
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(array, N, i);
 
        for (int i = N - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    public int[] heapify(int array[], int N, int i)
    {
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 

        if (l < N && array[l] > array[largest])
            largest = l;
 
        if (r < N && array[r] > array[largest])
            largest = r;

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, N, largest);
        }
        return array;
    }
	
    public int findLargest(int array[]){
        int largest = array[0];
        for(int i = 0; i < array.length; i++){
            if(array[i] > largest){
                largest = array[i];
            }
        }
        return largest;
    }
    
    @Override
    public int[] countingSort(int array[]){
        int size = array.length;
        int arraySaida[]= new int[size];  
        int max = findLargest(array);  
        int count[] = new int[max+1]; 

        for (int i = 0; i <= max; ++i){  
            count[i] = 0;
        }  

        for (int i = 0; i < size; i++){  
          count[array[i]]++;  
        }

        for(int i = 1; i<=max; i++){  
            count[i] += count[i-1]; 
        }
        
        for (int i = size - 1; i >= 0; i--) {  
          arraySaida[count[array[i]] - 1] = array[i];  
          count[array[i]]--; 
        }

        for(int i = 0; i<size; i++) {  
            array[i] = arraySaida[i];
        }
        return arraySaida;
      }  
    
}
