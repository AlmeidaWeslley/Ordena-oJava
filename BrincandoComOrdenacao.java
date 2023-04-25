import java.util.Random;

public class BrincandoComOrdenacao {
    
    public static void main(String[] args) {
        Ordenacao Ordenar = new Ordenacao();
        Random gerador = new Random();

        int numerosAleatorios_5[] = new int[5000];
        int numerosAleatorios_10[] = new int[10000];
        int numerosAleatorios_15[] = new int[15000];

        int numerosCrescentes_5[] = new int[5000];
        int numerosCrescentes_10[] = new int[10000];
        int numerosCrescentes_15[] = new int[15000];
        
        int numerosDecrescentes_5[] = new int[5000];
        int numerosDecrescentes_10[] = new int[10000];
        int numerosDecrescentes_15[] = new int[15000];

        for (int i = 0; i < 5000; i++){
            numerosCrescentes_5[i] = i;
        }
        for (int i = 0; i < 10000; i++){
            numerosCrescentes_10[i] = i;
        }
        for (int i = 0; i < 15000; i++){
            numerosCrescentes_15[i] = i;
        }
        for (int i = 0; i < 5000; i++){
            numerosDecrescentes_5[i] = (5000 - i);
        }
        for (int i = 0; i < 10000; i++){
            numerosDecrescentes_10[i] = (10000 - i);
        }
        for (int i = 0; i < 15000; i++){
            numerosDecrescentes_15[i] = (15000 - i);
        }
        for (int i=0; i < 5000; i++) {
            int j = gerador.nextInt(numerosAleatorios_5.length);
            numerosAleatorios_5[i] = j;
        }
        for (int i=0; i < 10000; i++) {
            int j = gerador.nextInt(numerosAleatorios_10.length);
            numerosAleatorios_10[i] = j;
        }
        for (int i=0; i < 15000; i++) {
            int j = gerador.nextInt(numerosAleatorios_15.length);
            numerosAleatorios_15[i] = j;
        }
        
        //Insertionsort
        System.out.println("---------InsertionSort---------");
        System.out.println("\nValores aleatorios:");
        Insertion(numerosAleatorios_5, numerosAleatorios_10, numerosAleatorios_15, Ordenar);
        System.out.println("\nValores crescente:");
        Insertion(numerosCrescentes_5, numerosCrescentes_10, numerosCrescentes_15, Ordenar);
        System.out.println("\nValores decrescente:");
        Insertion(numerosDecrescentes_5, numerosDecrescentes_10, numerosDecrescentes_15, Ordenar);
        System.out.println("\n\n");

        //Mergesort
        System.out.println("---------MergeSort---------");
        System.out.println("\nValores aleatorios:");
        Merge(numerosAleatorios_5, numerosAleatorios_10, numerosAleatorios_15, Ordenar);
        System.out.println("\nValores crescente:");
        Merge(numerosCrescentes_5, numerosCrescentes_10, numerosCrescentes_15, Ordenar);
        System.out.println("\nValores decrescente:");
        Merge(numerosDecrescentes_5, numerosDecrescentes_10, numerosDecrescentes_15, Ordenar);
        System.out.println("\n\n");

        //Quicksort normal
        System.out.println("---------QuickSort---------");
        System.out.println("\nValores aleatorios:");
        Quick(numerosAleatorios_5, numerosAleatorios_10, numerosAleatorios_15, Ordenar);
        System.out.println("\nValores crescente:");
        Quick(numerosCrescentes_5, numerosCrescentes_10, numerosCrescentes_15, Ordenar);
        System.out.println("\nValores decrescente:");
        Quick(numerosDecrescentes_5, numerosDecrescentes_10, numerosDecrescentes_15, Ordenar);
        System.out.println("\n\n");

        //Quicksort Randomizado
        System.out.println("---------QuickSort Random---------");
        System.out.println("\nValores aleatorios:");
        QuickRandom(numerosAleatorios_5, numerosAleatorios_10, numerosAleatorios_15, Ordenar);
        System.out.println("\nValores crescente:");
        QuickRandom(numerosCrescentes_5, numerosCrescentes_10, numerosCrescentes_15, Ordenar);
        System.out.println("\nValores decrescente:");
        QuickRandom(numerosDecrescentes_5, numerosDecrescentes_10, numerosDecrescentes_15, Ordenar);
        System.out.println("\n\n");

        //Quicksort do Java
        System.out.println("---------QuickSort Java---------");
        System.out.println("\nValores aleatorios:");
        QuickJava(numerosAleatorios_5, numerosAleatorios_10, numerosAleatorios_15, Ordenar);
        System.out.println("\nValores crescente:");
        QuickJava(numerosCrescentes_5, numerosCrescentes_10, numerosCrescentes_15, Ordenar);
        System.out.println("\nValores decrescente:");
        QuickJava(numerosDecrescentes_5, numerosDecrescentes_10, numerosDecrescentes_15, Ordenar);
        System.out.println("\n\n");

        //Heapsort
        System.out.println("---------HeapSort---------");
        System.out.println("\nValores aleatorios:");
        Heap(numerosAleatorios_5, numerosAleatorios_10, numerosAleatorios_15, Ordenar);
        System.out.println("\nValores crescente:");
        Heap(numerosCrescentes_5, numerosCrescentes_10, numerosCrescentes_15, Ordenar);
        System.out.println("\nValores decrescente:");
        Heap(numerosDecrescentes_5, numerosDecrescentes_10, numerosDecrescentes_15, Ordenar);
        System.out.println("\n\n");

        //Countingsort
        System.out.println("---------CountingSort---------");
        System.out.println("\nValores aleatorios:");
        Counting(numerosAleatorios_5, numerosAleatorios_10, numerosAleatorios_15, Ordenar);
        System.out.println("\nValores crescente:");
        Counting(numerosCrescentes_5, numerosCrescentes_10, numerosCrescentes_15, Ordenar);
        System.out.println("\nValores decrescente:");
        Counting(numerosDecrescentes_5, numerosDecrescentes_10, numerosDecrescentes_15, Ordenar);
        System.out.println("\n\n");
    }

    public static void Insertion(int[] vet_5, int[] vet_10, int[] vet_15, Ordenacao Ordenar){
        int[] vet_5_copy = vet_5;
        int[] vet_10_copy = vet_10;
        int[] vet_15_copy = vet_15;
        
        int media = 0;
        int quantSucesso = 0;
        int quantFracasso = 0;
        long startTime, endTime;
        for(int i=0;i<50;i++){
            startTime = System.nanoTime();
            Ordenar.insertionSort(vet_5);
            endTime = System.nanoTime();
            media += endTime - startTime;
            if(Ordenar.checaVetorOrdenado(vet_5)){
                quantSucesso += 1;
            }
            else{
                quantFracasso += 1;
            }
            vet_5 = vet_5_copy;
        }
        media = media/50;
       if(quantSucesso==50){
            System.out.println("\nMedia aray[5000]: " + 
            media + "\nTamanho: " + vet_5.length +
            "\nQuantidade de ordenações bem sucedidas: " + quantSucesso + 
            "\nFracassos: " + quantFracasso);
       }
       else{
            System.out.println("O array não foi ordenado todas as vezes!");
       }


        media = 0;
        quantSucesso = 0;
        quantFracasso = 0;
        for(int i=0;i<50;i++){
            startTime = System.nanoTime();
            Ordenar.insertionSort(vet_10);
            endTime = System.nanoTime();
            media += endTime - startTime;
            if(Ordenar.checaVetorOrdenado(vet_10)){
                quantSucesso += 1;
            }
            else{
                quantFracasso += 1;
            }
            vet_10 = vet_10_copy;
        }
        media = media/50;
        if(quantSucesso==50){
            System.out.println("\nMedia aray[10000]: " + 
            media + "\nTamanho: " + vet_10.length +
            "\nQuantidade de ordenações bem sucedidas: " + quantSucesso + 
            "\nFracassos: " + quantFracasso);
       }
       else{
            System.out.println("O array não foi ordenado todas as vezes!");
       }


        media = 0;
        quantSucesso = 0;
        quantFracasso = 0;
        for(int i=0;i<50;i++){
            startTime = System.nanoTime();
            Ordenar.insertionSort(vet_15);
            endTime = System.nanoTime();
            media += endTime - startTime;
            if(Ordenar.checaVetorOrdenado(vet_15)){
                quantSucesso += 1;
            }
            else{
                quantFracasso += 1;
            }
            vet_15 = vet_15_copy;
        }
        media = media/50;
        if(quantSucesso==50){
            System.out.println("\nMedia aray[15000]: " + 
            media + "\nTamanho: " + vet_15.length +
            "\nQuantidade de ordenações bem sucedidas: " + quantSucesso + 
            "\nFracassos: " + quantFracasso);
       }
       else{
            System.out.println("O array não foi ordenado todas as vezes!");
       }
    }

    public static void Merge(int[] vet_5, int[] vet_10, int[] vet_15, Ordenacao Ordenar){
        int[] vet_5_copy = vet_5;
        int[] vet_10_copy = vet_10;
        int[] vet_15_copy = vet_15;
        
        int media = 0;
        int quantSucesso = 0;
        int quantFracasso = 0;
        long startTime, endTime;
        for(int i=0;i<50;i++){
            startTime = System.nanoTime();
            Ordenar.insertionSort(vet_5);
            endTime = System.nanoTime();
            media += endTime - startTime;
            if(Ordenar.checaVetorOrdenado(vet_5)){
                quantSucesso += 1;
            }
            else{
                quantFracasso += 1;
            }
            vet_5 = vet_5_copy;
        }
        media = media/50;
       if(quantSucesso==50){
            System.out.println("\nMedia aray[5000]: " + 
            media + "\nTamanho: " + vet_5.length +
            "\nQuantidade de ordenações bem sucedidas: " + quantSucesso + 
            "\nFracassos: " + quantFracasso);
       }
       else{
            System.out.println("O array não foi ordenado todas as vezes!");
       }


        media = 0;
        quantSucesso = 0;
        quantFracasso = 0;
        for(int i=0;i<50;i++){
            startTime = System.nanoTime();
            Ordenar.insertionSort(vet_10);
            endTime = System.nanoTime();
            media += endTime - startTime;
            if(Ordenar.checaVetorOrdenado(vet_10)){
                quantSucesso += 1;
            }
            else{
                quantFracasso += 1;
            }
            vet_10 = vet_10_copy;
        }
        media = media/50;
        if(quantSucesso==50){
            System.out.println("\nMedia aray[10000]: " + 
            media + "\nTamanho: " + vet_10.length +
            "\nQuantidade de ordenações bem sucedidas: " + quantSucesso + 
            "\nFracassos: " + quantFracasso);
       }
       else{
            System.out.println("O array não foi ordenado todas as vezes!");
       }


        media = 0;
        quantSucesso = 0;
        quantFracasso = 0;
        for(int i=0;i<50;i++){
            startTime = System.nanoTime();
            Ordenar.insertionSort(vet_15);
            endTime = System.nanoTime();
            media += endTime - startTime;
            if(Ordenar.checaVetorOrdenado(vet_15)){
                quantSucesso += 1;
            }
            else{
                quantFracasso += 1;
            }
            vet_15 = vet_15_copy;
        }
        media = media/50;
        if(quantSucesso==50){
            System.out.println("\nMedia aray[15000]: " + 
            media + "\nTamanho: " + vet_15.length +
            "\nQuantidade de ordenações bem sucedidas: " + quantSucesso + 
            "\nFracassos: " + quantFracasso);
       }
       else{
            System.out.println("O array não foi ordenado todas as vezes!");
       }
    }

    public static void Quick(int[] vet_5, int[] vet_10, int[] vet_15, Ordenacao Ordenar){
        int[] vet_5_copy = vet_5;
        int[] vet_10_copy = vet_10;
        int[] vet_15_copy = vet_15;
        
        int media = 0;
        int quantSucesso = 0;
        int quantFracasso = 0;
        long startTime, endTime;
        for(int i=0;i<50;i++){
            startTime = System.nanoTime();
            Ordenar.insertionSort(vet_5);
            endTime = System.nanoTime();
            media += endTime - startTime;
            if(Ordenar.checaVetorOrdenado(vet_5)){
                quantSucesso += 1;
            }
            else{
                quantFracasso += 1;
            }
            vet_5 = vet_5_copy;
        }
        media = media/50;
       if(quantSucesso==50){
            System.out.println("\nMedia aray[5000]: " + 
            media + "\nTamanho: " + vet_5.length +
            "\nQuantidade de ordenações bem sucedidas: " + quantSucesso + 
            "\nFracassos: " + quantFracasso);
       }
       else{
            System.out.println("O array não foi ordenado todas as vezes!");
       }


        media = 0;
        quantSucesso = 0;
        quantFracasso = 0;
        for(int i=0;i<50;i++){
            startTime = System.nanoTime();
            Ordenar.insertionSort(vet_10);
            endTime = System.nanoTime();
            media += endTime - startTime;
            if(Ordenar.checaVetorOrdenado(vet_10)){
                quantSucesso += 1;
            }
            else{
                quantFracasso += 1;
            }
            vet_10 = vet_10_copy;
        }
        media = media/50;
        if(quantSucesso==50){
            System.out.println("\nMedia aray[10000]: " + 
            media + "\nTamanho: " + vet_10.length +
            "\nQuantidade de ordenações bem sucedidas: " + quantSucesso + 
            "\nFracassos: " + quantFracasso);
       }
       else{
            System.out.println("O array não foi ordenado todas as vezes!");
       }


        media = 0;
        quantSucesso = 0;
        quantFracasso = 0;
        for(int i=0;i<50;i++){
            startTime = System.nanoTime();
            Ordenar.insertionSort(vet_15);
            endTime = System.nanoTime();
            media += endTime - startTime;
            if(Ordenar.checaVetorOrdenado(vet_15)){
                quantSucesso += 1;
            }
            else{
                quantFracasso += 1;
            }
            vet_15 = vet_15_copy;
        }
        media = media/50;
        if(quantSucesso==50){
            System.out.println("\nMedia aray[15000]: " + 
            media + "\nTamanho: " + vet_15.length +
            "\nQuantidade de ordenações bem sucedidas: " + quantSucesso + 
            "\nFracassos: " + quantFracasso);
       }
       else{
            System.out.println("O array não foi ordenado todas as vezes!");
       }
    }

    public static void QuickRandom(int[] vet_5, int[] vet_10, int[] vet_15, Ordenacao Ordenar){
        int[] vet_5_copy = vet_5;
        int[] vet_10_copy = vet_10;
        int[] vet_15_copy = vet_15;
        
        int media = 0;
        int quantSucesso = 0;
        int quantFracasso = 0;
        long startTime, endTime;
        for(int i=0;i<50;i++){
            startTime = System.nanoTime();
            Ordenar.insertionSort(vet_5);
            endTime = System.nanoTime();
            media += endTime - startTime;
            if(Ordenar.checaVetorOrdenado(vet_5)){
                quantSucesso += 1;
            }
            else{
                quantFracasso += 1;
            }
            vet_5 = vet_5_copy;
        }
        media = media/50;
       if(quantSucesso==50){
            System.out.println("\nMedia aray[5000]: " + 
            media + "\nTamanho: " + vet_5.length +
            "\nQuantidade de ordenações bem sucedidas: " + quantSucesso + 
            "\nFracassos: " + quantFracasso);
       }
       else{
            System.out.println("O array não foi ordenado todas as vezes!");
       }


        media = 0;
        quantSucesso = 0;
        quantFracasso = 0;
        for(int i=0;i<50;i++){
            startTime = System.nanoTime();
            Ordenar.insertionSort(vet_10);
            endTime = System.nanoTime();
            media += endTime - startTime;
            if(Ordenar.checaVetorOrdenado(vet_10)){
                quantSucesso += 1;
            }
            else{
                quantFracasso += 1;
            }
            vet_10 = vet_10_copy;
        }
        media = media/50;
        if(quantSucesso==50){
            System.out.println("\nMedia aray[10000]: " + 
            media + "\nTamanho: " + vet_10.length +
            "\nQuantidade de ordenações bem sucedidas: " + quantSucesso + 
            "\nFracassos: " + quantFracasso);
       }
       else{
            System.out.println("O array não foi ordenado todas as vezes!");
       }


        media = 0;
        quantSucesso = 0;
        quantFracasso = 0;
        for(int i=0;i<50;i++){
            startTime = System.nanoTime();
            Ordenar.insertionSort(vet_15);
            endTime = System.nanoTime();
            media += endTime - startTime;
            if(Ordenar.checaVetorOrdenado(vet_15)){
                quantSucesso += 1;
            }
            else{
                quantFracasso += 1;
            }
            vet_15 = vet_15_copy;
        }
        media = media/50;
        if(quantSucesso==50){
            System.out.println("\nMedia aray[15000]: " + 
            media + "\nTamanho: " + vet_15.length +
            "\nQuantidade de ordenações bem sucedidas: " + quantSucesso + 
            "\nFracassos: " + quantFracasso);
       }
       else{
            System.out.println("O array não foi ordenado todas as vezes!");
       }
    }

    public static void QuickJava(int[] vet_5, int[] vet_10, int[] vet_15, Ordenacao Ordenar){
        int[] vet_5_copy = vet_5;
        int[] vet_10_copy = vet_10;
        int[] vet_15_copy = vet_15;
        
        int media = 0;
        int quantSucesso = 0;
        int quantFracasso = 0;
        long startTime, endTime;
        for(int i=0;i<50;i++){
            startTime = System.nanoTime();
            Ordenar.insertionSort(vet_5);
            endTime = System.nanoTime();
            media += endTime - startTime;
            if(Ordenar.checaVetorOrdenado(vet_5)){
                quantSucesso += 1;
            }
            else{
                quantFracasso += 1;
            }
            vet_5 = vet_5_copy;
        }
        media = media/50;
       if(quantSucesso==50){
            System.out.println("\nMedia aray[5000]: " + 
            media + "\nTamanho: " + vet_5.length +
            "\nQuantidade de ordenações bem sucedidas: " + quantSucesso + 
            "\nFracassos: " + quantFracasso);
       }
       else{
            System.out.println("O array não foi ordenado todas as vezes!");
       }


        media = 0;
        quantSucesso = 0;
        quantFracasso = 0;
        for(int i=0;i<50;i++){
            startTime = System.nanoTime();
            Ordenar.insertionSort(vet_10);
            endTime = System.nanoTime();
            media += endTime - startTime;
            if(Ordenar.checaVetorOrdenado(vet_10)){
                quantSucesso += 1;
            }
            else{
                quantFracasso += 1;
            }
            vet_10 = vet_10_copy;
        }
        media = media/50;
        if(quantSucesso==50){
            System.out.println("\nMedia aray[10000]: " + 
            media + "\nTamanho: " + vet_10.length +
            "\nQuantidade de ordenações bem sucedidas: " + quantSucesso + 
            "\nFracassos: " + quantFracasso);
       }
       else{
            System.out.println("O array não foi ordenado todas as vezes!");
       }


        media = 0;
        quantSucesso = 0;
        quantFracasso = 0;
        for(int i=0;i<50;i++){
            startTime = System.nanoTime();
            Ordenar.insertionSort(vet_15);
            endTime = System.nanoTime();
            media += endTime - startTime;
            if(Ordenar.checaVetorOrdenado(vet_15)){
                quantSucesso += 1;
            }
            else{
                quantFracasso += 1;
            }
            vet_15 = vet_15_copy;
        }
        media = media/50;
        if(quantSucesso==50){
            System.out.println("\nMedia aray[15000]: " + 
            media + "\nTamanho: " + vet_15.length +
            "\nQuantidade de ordenações bem sucedidas: " + quantSucesso + 
            "\nFracassos: " + quantFracasso);
       }
       else{
            System.out.println("O array não foi ordenado todas as vezes!");
       }
    }

    public static void Heap(int[] vet_5, int[] vet_10, int[] vet_15, Ordenacao Ordenar){
        int[] vet_5_copy = vet_5;
        int[] vet_10_copy = vet_10;
        int[] vet_15_copy = vet_15;
        
        int media = 0;
        int quantSucesso = 0;
        int quantFracasso = 0;
        long startTime, endTime;
        for(int i=0;i<50;i++){
            startTime = System.nanoTime();
            Ordenar.insertionSort(vet_5);
            endTime = System.nanoTime();
            media += endTime - startTime;
            if(Ordenar.checaVetorOrdenado(vet_5)){
                quantSucesso += 1;
            }
            else{
                quantFracasso += 1;
            }
            vet_5 = vet_5_copy;
        }
        media = media/50;
       if(quantSucesso==50){
            System.out.println("\nMedia aray[5000]: " + 
            media + "\nTamanho: " + vet_5.length +
            "\nQuantidade de ordenações bem sucedidas: " + quantSucesso + 
            "\nFracassos: " + quantFracasso);
       }
       else{
            System.out.println("O array não foi ordenado todas as vezes!");
       }


        media = 0;
        quantSucesso = 0;
        quantFracasso = 0;
        for(int i=0;i<50;i++){
            startTime = System.nanoTime();
            Ordenar.insertionSort(vet_10);
            endTime = System.nanoTime();
            media += endTime - startTime;
            if(Ordenar.checaVetorOrdenado(vet_10)){
                quantSucesso += 1;
            }
            else{
                quantFracasso += 1;
            }
            vet_10 = vet_10_copy;
        }
        media = media/50;
        if(quantSucesso==50){
            System.out.println("\nMedia aray[10000]: " + 
            media + "\nTamanho: " + vet_10.length +
            "\nQuantidade de ordenações bem sucedidas: " + quantSucesso + 
            "\nFracassos: " + quantFracasso);
       }
       else{
            System.out.println("O array não foi ordenado todas as vezes!");
       }


        media = 0;
        quantSucesso = 0;
        quantFracasso = 0;
        for(int i=0;i<50;i++){
            startTime = System.nanoTime();
            Ordenar.insertionSort(vet_15);
            endTime = System.nanoTime();
            media += endTime - startTime;
            if(Ordenar.checaVetorOrdenado(vet_15)){
                quantSucesso += 1;
            }
            else{
                quantFracasso += 1;
            }
            vet_15 = vet_15_copy;
        }
        media = media/50;
        if(quantSucesso==50){
            System.out.println("\nMedia aray[15000]: " + 
            media + "\nTamanho: " + vet_15.length +
            "\nQuantidade de ordenações bem sucedidas: " + quantSucesso + 
            "\nFracassos: " + quantFracasso);
       }
       else{
            System.out.println("O array não foi ordenado todas as vezes!");
       }
    }

    public static void Counting(int[] vet_5, int[] vet_10, int[] vet_15, Ordenacao Ordenar){
        int[] vet_5_copy = vet_5;
        int[] vet_10_copy = vet_10;
        int[] vet_15_copy = vet_15;
        
        int media = 0;
        int quantSucesso = 0;
        int quantFracasso = 0;
        long startTime, endTime;
        for(int i=0;i<50;i++){
            startTime = System.nanoTime();
            Ordenar.insertionSort(vet_5);
            endTime = System.nanoTime();
            media += endTime - startTime;
            if(Ordenar.checaVetorOrdenado(vet_5)){
                quantSucesso += 1;
            }
            else{
                quantFracasso += 1;
            }
            vet_5 = vet_5_copy;
        }
        media = media/50;
       if(quantSucesso==50){
            System.out.println("\nMedia aray[5000]: " + 
            media + "\nTamanho: " + vet_5.length +
            "\nQuantidade de ordenações bem sucedidas: " + quantSucesso + 
            "\nFracassos: " + quantFracasso);
       }
       else{
            System.out.println("O array não foi ordenado todas as vezes!");
       }


        media = 0;
        quantSucesso = 0;
        quantFracasso = 0;
        for(int i=0;i<50;i++){
            startTime = System.nanoTime();
            Ordenar.insertionSort(vet_10);
            endTime = System.nanoTime();
            media += endTime - startTime;
            if(Ordenar.checaVetorOrdenado(vet_10)){
                quantSucesso += 1;
            }
            else{
                quantFracasso += 1;
            }
            vet_10 = vet_10_copy;
        }
        media = media/50;
        if(quantSucesso==50){
            System.out.println("\nMedia aray[10000]: " + 
            media + "\nTamanho: " + vet_10.length +
            "\nQuantidade de ordenações bem sucedidas: " + quantSucesso + 
            "\nFracassos: " + quantFracasso);
       }
       else{
            System.out.println("O array não foi ordenado todas as vezes!");
       }


        media = 0;
        quantSucesso = 0;
        quantFracasso = 0;
        for(int i=0;i<50;i++){
            startTime = System.nanoTime();
            Ordenar.insertionSort(vet_15);
            endTime = System.nanoTime();
            media += endTime - startTime;
            if(Ordenar.checaVetorOrdenado(vet_15)){
                quantSucesso += 1;
            }
            else{
                quantFracasso += 1;
            }
            vet_15 = vet_15_copy;
        }
        media = media/50;
        if(quantSucesso==50){
            System.out.println("\nMedia aray[15000]: " + 
            media + "\nTamanho: " + vet_15.length +
            "\nQuantidade de ordenações bem sucedidas: " + quantSucesso + 
            "\nFracassos: " + quantFracasso);
       }
       else{
            System.out.println("O array não foi ordenado todas as vezes!");
       }
    }
}