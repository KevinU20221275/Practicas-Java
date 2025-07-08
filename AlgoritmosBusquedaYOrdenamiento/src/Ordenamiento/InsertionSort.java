package Ordenamiento;

public class InsertionSort {
    // Algoritmo de inserción para ordenar un arreglo de enteros
    public static void insertionSort(int[] arr){
        // Recorre desde el segundo elemento hasta el final
        for(int i = 1; i < arr.length; i++){
            int actual = arr[i]; // Elemento actual a insertar
            int j = i - 1;

            // Desplaza hacia la derecha los elementos mayores al actual
            while(j >= 0 && arr[j] > actual){
                arr[j + 1] = arr[j]; // Mueve el valor hacia la derecha
                j--;
            }

            // Inserta el valor actual en la posición correcta
            arr[j + 1] = actual;
        }
    }
}
