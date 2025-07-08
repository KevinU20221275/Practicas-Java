package Busqueda;

public class BusquedaBinaria {

    // Búsqueda binaria en un arreglo de Strings ordenado alfabéticamente
    public static int busquedaBinaria(String[] arr, String busqueda){
        int inicio = 0; // Limite inferior del arreglo
        int fin = arr.length - 1; // Limite superior

        while (inicio <= fin){
            int mitad = (inicio + fin) / 2; // Indice central

            // compara el valor de la mitad con el valor buscado
            int comparacion = arr[mitad].compareTo(busqueda);

            if (comparacion == 0){
                return mitad; // si encontro el elemento
            } else if (comparacion < 0){
                // la palabra está después en orden alfabético (Buscar en la mitad derecha)
                inicio = mitad + 1;
            } else {
                // la palabra está antes en orden alfabético (Buscar en la mitad izquierda)
                fin = mitad - 1;
            }
        }

        return -1; // Si no se encontro
    }

    // Búsqueda binaria en un arreglo de enteros (debe estar ordenado de menor a mayor)
    public static int busquedaBinaria(int[] arr, int busqueda){
        int inicio = 0; // Limite inferiro del arreglo
        int fin = arr.length - 1; // Limite superior

        while(inicio <= fin){
            int mitad = (inicio + fin) / 2; // indice central

            if (arr[mitad] == busqueda){
                return mitad; // Elemento encontrado
            } else if (arr[mitad] < busqueda){
                inicio = mitad + 1; // Buscar en la mitad derecha
            } else {
                fin = mitad - 1; // Buscar en la mitad izquierda
            }
        }

        return -1; // Elemento no encontrado
    }
}