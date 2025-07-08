//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // crea una instancia de la clase ListaEnlazadaSimple
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();

        // imprime la lista sin datos (vacía)
        System.out.println(lista.listar());

        // agrega nodos al inicio de la lista
        lista.insertarAllInicio(10);
        lista.insertarAllInicio(20);
        lista.insertarAllInicio(30);

        // imprime la lista
        System.out.print("Listando datos: ");
        System.out.println(lista.listar()); // [30,20,10]

        // elimina el primer nodo de la lista
        lista.eliminarAlInicio();
        // lista los nodos después de eliminar el primer nodo
        System.out.print("Listando después de eliminar al inicio: ");
        System.out.println(lista.listar()); // [20,10]

        // agregar al final de la lista
        lista.insertarAlFinal(100);
        lista.insertarAlFinal(450);
        // imprime la lista después de agregar 2 nodos al final
        System.out.print("Listando después de agregar 2 datos al final: ");
        System.out.println(lista.listar()); // [20,10,100,450]

        // inserta 2 nuevos nodos por índice en la lista
        System.out.println(lista.insertarPorIndice(2, 50));
        System.out.println(lista.insertarPorIndice(2, 40));
        // imprime la lista después de agregar los nuevos datos
        System.out.print("Listando después de agregar 2 datos por indice: ");
        System.out.println(lista.listar()); // [20,10,40,50,100,450]

        // modificar un dato de la lista por indice
        System.out.println(lista.modificarPorIndice(0, 5)); // cambiará el valor 20 en el índice 0 por el valor 5 en la lista
        System.out.println(lista.modificarPorIndice(3, 75)); // cambiará el valor 50 en el índice 3 por el valor de 75 en la lista
        System.out.print("Listando después de modificar los datos en los indices 0 y 3: ");
        // imprime la lista después de modificar los 2 datos
        System.out.println(lista.listar()); // [5,10,40,75,100,450]

        // elimina un nodo por índice de la lista
        System.out.println(lista.eliminarPorIndice(0));
        // imprime la lista después de la eliminacion por índice
        System.out.print("Listando después de eliminacion por indice: ");
        System.out.println(lista.listar()); // [10,40,75,100,450]

        // elimar un nodo de la lista por índice (el indice sobrepasa el numero de nodo de la lista)
        System.out.println(lista.eliminarPorIndice(10)); // El índice no existe en la lista

        // busca nodo por su indice
        System.out.println(lista.buscarPorIndice(1).getDato()); // 40

        // busca nodo por índice (el índice no existe en la lista)
        System.out.println(lista.buscarPorIndice(100)); // null

        // modificar un dato con un indice no existente
        System.out.println(lista.modificarPorIndice(100, 20));
    }
}