package Ordenamiento;

public class BubbleSort {
    // Bubble sort para arreglos de enteros
    public static void bubbleSort(int[] arr){
        // Recorre el arreglo varias veces
        for (int i = 0; i < arr.length - 1; i++ ){
            // En cada iteracion, desplazando el mayor valor hacia el final
            for (int j = 0; j < arr.length - 1 - i; j++){
                if (arr[j] > arr[j+1]){
                    // Intercambia si el actual es mayor que el siguiente
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Bubble sort para arreglos de Strings (orden alfabético)
    public static void bubbleSort(String[] arr){
        for (int i = 0; i < arr.length - 1; i++ ){
            for (int j = 0; j < arr.length - 1 - i; j++){
                // Compara usando orden alfabético
                if (arr[j].compareTo(arr[j+1]) > 0){
                    // Intercambia si está fuera de orden
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Bubble Sort para ordenar Strings por su longitud
    public static void bubbleSortStringPorLongitud(String[] arr){
        for (int i = 0; i < arr.length - 1; i++ ){
            // Compara la longitud de las palabras
            for (int j = 0; j < arr.length - 1 - i; j++){
                if (arr[j].length() > arr[j+1].length()){
                    // Intercambia si la palabra actual es más larga que la siguiente
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}