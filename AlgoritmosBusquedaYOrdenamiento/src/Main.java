import Busqueda.BusquedaBinaria;
import Busqueda.BusquedaLineal;
import Ordenamiento.BubbleSort;
import Ordenamiento.InsertionSort;
import Ordenamiento.SelectionSort;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arrayNumeros = {20,4,40,50,15,100,12};
        String[] arrayString = {"java", "programacion", "ordenamiento", "array", "datos"};

        // Búsqueda Lineal con datos existentes
        BusquedaLineal.busquedaLineal(arrayNumeros, 100);
        BusquedaLineal.busquedaLineal(arrayString, "datos");
        // Búsqueda lineal con datos no existentes
        BusquedaLineal.busquedaLineal(arrayNumeros, 1203);
        BusquedaLineal.busquedaLineal(arrayString, "Kevin");


        // Búsqueda Binaria
        // ordenamos los arreglos primero
        BubbleSort.bubbleSort(arrayNumeros);
        BubbleSort.bubbleSort(arrayString);

        int resultado = BusquedaBinaria.busquedaBinaria(arrayString, "datos");

        if (resultado >= 0){
            System.out.println("Dato encontrado en el indice " + resultado + " : " + arrayString[resultado]);
        } else {
            System.out.println("No se encontró el dato");
        }

        resultado = BusquedaBinaria.busquedaBinaria(arrayNumeros, 30);
        if (resultado >= 0) {
            System.out.println("Elemento encontrado " + arrayNumeros[resultado] + " en índice: " + resultado);
        } else {
            System.out.println("Elemento no encontrado");
        }

        // ========= ALGORITMOS DE ORDENAMIENTO =========
        // datasets para pruebas de rendimiento de los algoritmos
        int[] arrayCien = new int[100];
        int[] arrayDiezMil = new int[10000];
        int[] arrayCienMil = new int[100000];

        // instancia de la librería Random para obtener números al azar
        Random rand = new Random();

        // bucle para llenar el array de 100 elementos
        for (int i = 0; i < 100; i++){
            int random = rand.nextInt(10000);
            arrayCien[i] = random;
        }

        // bucle para llenar el array de 10,000 elementos
        for (int i = 0; i < 10000; i++){
            int random = rand.nextInt(12345);
            arrayDiezMil[i] = random;
        }

        // bucle para llenar el array de 100,000 elementos
        for (int i = 0; i < 100000; i++){
            int random = rand.nextInt(12345);
            arrayCienMil[i] = random;
        }

        // crea copias del array original para los diferentes algoritmos
        // copias del array de 100 datos
        int[] arrayBubbleCien = Arrays.copyOf(arrayCien, arrayCien.length);
        int[] arrayInsertionCien = Arrays.copyOf(arrayCien, arrayCien.length);
        int[] arraySelectionCien = Arrays.copyOf(arrayCien,arrayCien.length);

        // copias del array de 10,000 datos
        int[] arrayBubbleDiezMil = Arrays.copyOf(arrayDiezMil, arrayDiezMil.length);
        int[] arrayInsertionDiezMil = Arrays.copyOf(arrayDiezMil, arrayDiezMil.length);
        int[] arraySelectionDiezMil = Arrays.copyOf(arrayDiezMil, arrayDiezMil.length);

        // copias del array de 100,000 datos
        int[] arrayBubbleCienMil = Arrays.copyOf(arrayCienMil, arrayCienMil.length);
        int[] arrayInsertionCienMil = Arrays.copyOf(arrayCienMil, arrayCienMil.length);
        int[] arraySelectionCienMil = Arrays.copyOf(arrayCienMil, arrayCienMil.length);


        // PRUEBAS DE TIEMPO CON ARRAYS DE 100 DATOS
        System.out.println("===== Pruebas con array de 100 datos =====");
        // bubble Sort con un array de 100 datos
        long start = System.nanoTime();
        BubbleSort.bubbleSort(arrayBubbleCien);
        long end = System.nanoTime();
        System.out.println("Tiempo Bubble Sort: " + tiempoMilisegundos(start, end) + " ms");

        // insertion sort con un array de 100 datos
        start = System.nanoTime();
        InsertionSort.insertionSort(arrayInsertionCien);
        end = System.nanoTime();
        System.out.println("Tiempo Insertion Sort: " + tiempoMilisegundos(start, end) + " ms");

        // selection sort con un array de 100 datos
        start = System.nanoTime();
        SelectionSort.selectionSort(arraySelectionCien);
        end = System.nanoTime();
        System.out.println("Tiempo Selection Sort: " + tiempoMilisegundos(start, end) + " ms");

        System.out.println();

        // PRUEBAS DE TIEMPO CON ARRAYS DE 10000 DATOS
        System.out.println("===== Pruebas con array de 10000 datos =====");
        // bubble Sort con un array de 10000 datos
        start = System.nanoTime();
        BubbleSort.bubbleSort(arrayBubbleDiezMil);
        end = System.nanoTime();
        System.out.println("Tiempo Bubble Sort: " + tiempoMilisegundos(start, end) + " ms");

        // insertion sort con un array de 10000 datos
        start = System.nanoTime();

        InsertionSort.insertionSort(arrayInsertionDiezMil);
        end = System.nanoTime();
        System.out.println("Tiempo Insertion Sort: " + tiempoMilisegundos(start, end) + " ms");

        // selection sort con un array de 10000 datos
        start = System.nanoTime();
        SelectionSort.selectionSort(arraySelectionDiezMil);
        end = System.nanoTime();
        System.out.println("Tiempo Selection Sort: " + tiempoMilisegundos(start, end) + " ms");

        System.out.println();

        // PRUEBAS DE TIEMPO CON ARRAYS DE 100000 DATOS
        System.out.println("===== Pruebas con array de 100000 datos =====");
        // bubble Sort con un array de 100000 datos
        start = System.nanoTime();
        BubbleSort.bubbleSort(arrayBubbleCienMil);
        end = System.nanoTime();
        System.out.println("Tiempo Bubble Sort: " + tiempoMilisegundos(start, end) + " ms");

        // insertion sort con un array de 100000 datos
        start = System.nanoTime();
        InsertionSort.insertionSort(arrayInsertionCienMil);
        end = System.nanoTime();
        System.out.println("Tiempo Insertion Sort: " + tiempoMilisegundos(start, end) + " ms");

        // selection sort con un array de 10000 datos
        start = System.nanoTime();
        SelectionSort.selectionSort(arraySelectionCienMil);
        end = System.nanoTime();
        System.out.println("Tiempo Selection Sort: " + tiempoMilisegundos(start, end) + " ms");
    }

    // método para transformar de nano segundos a milisegundos
    public static double tiempoMilisegundos(long start, long end){
        long tiempo = end - start;
        return tiempo / 1_000_000.0;
    }
}