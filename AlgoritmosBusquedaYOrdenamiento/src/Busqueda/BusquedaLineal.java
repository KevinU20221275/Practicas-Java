package Busqueda;

public class BusquedaLineal {

    // Búsqueda lineal en el arreglo de Strings
    public static void busquedaLineal(String[] arr, String busqueda){
        for (String s : arr) {
            // Compara ignorando mayúsculas/minúsculas
            if (s.equalsIgnoreCase(busqueda)) {
                System.out.println("Palabra encontrada: " + s);
                return; // sale del método si lo encuentra
            }
        }

        // imprime un mensaje si no se encontró
        System.out.println("No se encontró la palabra");
    }

    // Búsqueda lineal en un arreglo de enteros
    public static void busquedaLineal(int[] arr, int busqueda){
        for (int item: arr){
            if (item == busqueda){
                System.out.println("Elemento encontrado: " + item);
                return; // Sale si encuentra el numero
            }
        }

        // imprime un mensaje si no se encontró
        System.out.println("No se encontró el elemento");
    }
}