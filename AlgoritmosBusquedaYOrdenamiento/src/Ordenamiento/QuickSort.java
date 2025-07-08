package Ordenamiento;

public class QuickSort {
    public static void quickSort(String[] peleadores, int[] puntuaciones, int inicio, int fin){
        if (fin < inicio) return;

        int particion = particionar(peleadores, puntuaciones, inicio, fin);
        quickSort(peleadores, puntuaciones, inicio, particion - 1);
        quickSort(peleadores, puntuaciones, particion+1, fin);
    }
    public static int particionar(String[] peleadores, int[] puntuaciones, int inicio, int fin){
        int pivote = puntuaciones[fin];
        int index = inicio;

        for (int i = inicio; i < fin; i++){
            if (puntuaciones[i] <= pivote){
                int temp = puntuaciones[index];
                puntuaciones[index] = puntuaciones[i];
                puntuaciones[i] = temp;

                String tempPeleador = peleadores[index];
                peleadores[index] = peleadores[i];
                peleadores[i] = tempPeleador;

                index++;
            }
        }

        int temPuntos = puntuaciones[index];
        puntuaciones[index] = puntuaciones[fin];
        puntuaciones[fin] = temPuntos;

        String temPeleador = peleadores[index];
        peleadores[index] = peleadores[fin];
        peleadores[fin] = temPeleador;

        return index;
    }
}
