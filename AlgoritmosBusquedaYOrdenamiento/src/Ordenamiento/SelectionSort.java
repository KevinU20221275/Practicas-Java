package Ordenamiento;

public class SelectionSort {
    // Algoritmo de selección para ordenar un arreglo de enteros
    public static void selectionSort(int[] arr){
        // Recorre todo el arreglo
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i; // Supone que el elemento actual es el menor

            // Busca el índice del valor mínimo en el resto del arreglo
            for(int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            // Intercambia el valor mínimo con el de la posición actual
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
