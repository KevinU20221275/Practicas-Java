// clase ListaEnlazadaSimple
public class ListaEnlazadaSimple {
    // Referencia el primer nodo de la lista
   private Nodo cabeza;

   // constructor
    public ListaEnlazadaSimple() {
        this.cabeza = null; // inicializa la cabeza como null
    }

    // método para insertar un nodo al inicio de la lista
    public void insertarAllInicio(int dato){
        Nodo nuevoNodo = new Nodo(dato); // crea un nuevo nodo con el dato dado
        nuevoNodo.setSiguiente(cabeza); // enlaza el nuevo nodo al nodo actual que era la cabeza
        cabeza = nuevoNodo; // ahora la cabeza apunta al nuevo nodo
    }

    // método para insertar un nodo al final de la lista
    public void insertarAlFinal(int dato){
        Nodo nuevoNodo = new Nodo(dato); // crea un nuevo nodo con el dato dado

        if(cabeza== null){ // si la lista está vacía, simplemente cabeza será el nuevo nodo
            cabeza = nuevoNodo;
            return;
        }

        // comienza desde la cabeza
        Nodo nodoActual = cabeza;

        // Recorremos hasta llegar al ultimo nodo (donde siguiente es null)
        while (nodoActual.getSiguiente() != null){
            nodoActual = nodoActual.getSiguiente();
        }

        // enlaza el ultimo nodo al nuevo nodo
        nodoActual.setSiguiente(nuevoNodo);
    }

    // método para eliminar un nodo al inicio de la lista
    public void eliminarAlInicio(){
        if (cabeza != null){
            cabeza = cabeza.getSiguiente(); // mueve la cabeza al siguiente nodo
        } else {
            System.out.println("La lista esta vaciá.");
        }
    }

    // método para mostrar la lista, Devuelve un String representando la lista, por ejemplo [1,2,3]
    public String listar(){
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        Nodo nodoActual = cabeza;

        while (nodoActual != null){
            sb.append(nodoActual.getDato()); // concatena el nodo actual
            sb.append(",");
            nodoActual = nodoActual.getSiguiente(); // pasa al siguiente nodo
        }

        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1); // Elimina la última coma
        }

        sb.append("]");

        return sb.toString();
    }

    // método para insertar un nodo en una posicion especifica de la lista por indice
    public String insertarPorIndice(int indice, int dato){
        // si el indice es negativo imprime un mensaje y sale del método
        if (indice < 0){
            return "Error: Por favor ingrese un indice valido";
        }

        // si el indice es 0 lo inserta al inicio
        if (indice == 0){
            insertarAllInicio(dato);
            return "Dato Insertado exitosamente en el indice " + indice;
        }

        // crea un nuevo nodo
        Nodo nuevoNodo = new Nodo(dato);
        Nodo nodoActual = cabeza; //
        int i = 0;

        // avanza hasta el nodo anterior al indice dado
        while (nodoActual != null && i < indice - 1){
            nodoActual = nodoActual.getSiguiente();
            i++;
        }

        // si nodo actual es null el índice está fuera de rango
        if (nodoActual == null){
            return "Indice fuera de rango";
        } else {
            // encadena el nuevo nod al nodo actual para inserta el nuevo nodo entre el nodo actual y su siguiente
            nuevoNodo.setSiguiente(nodoActual.getSiguiente());
            // encadena el nodo actual al nuevo nodo
            nodoActual.setSiguiente(nuevoNodo);
            return  "Dato insertado exitosamente en el indice " + indice;
        }
    }

    // elimina el nodo en el índice específico
    public String eliminarPorIndice(int indice){
        // si la lista esta vaciá o el indice dado es negativo imprime un mensaje de error y sale del método
        if (indice < 0 || cabeza == null){
            return "Indice invalido o lista vaciá";
        }

        // si el indice es 0 elimina al inicio
        if (indice == 0){
            eliminarAlInicio();
            return "Dato en el indice 0 eliminado";
        }

        Nodo nodoActual = cabeza;
        int i = 0;

        // avanza hasta el nodo anterior al que se quiere eliminar
        while(nodoActual.getSiguiente() != null && i < indice - 1){
            nodoActual = nodoActual.getSiguiente();
            i++;
        }

        // si el nodo siguiente del nodoActual es nulo el índice está fuera de rango
        if (nodoActual.getSiguiente() == null){
            return "El indice no existe en la lista";
        }

        // salta el nodo que se quiere eliminar
        nodoActual.setSiguiente(nodoActual.getSiguiente().getSiguiente());

        return "Dato en el indice " + indice + " eliminado";
    }

    public String modificarPorIndice(int indice, int nuevoDato){
        if (indice < 0){
            return "Indice no valido";
        }

        Nodo nodoEncontrado = buscarPorIndice(indice);

        if (nodoEncontrado != null){
            int datoAnterior = nodoEncontrado.getDato();
            nodoEncontrado.setDato(nuevoDato);
            return "Dato modificado: indice -> " + indice + ", Dato Antiguo -> " + datoAnterior + ", Nuevo Dato -> " + nuevoDato;
        }

        return "No se encontró el dato con indice " + indice;
    }

    // busca un nodo por índice y devuelve un nodo o null como valor
    public Nodo buscarPorIndice(int indice){
        // si el indice es negativo retorna null y sale del método
        if (indice < 0){
            return null;
        }

        Nodo nodoActual = cabeza;
        int i = 0;

        // Recorre la lista buscando el indice
        while(nodoActual != null){
            // si lo encuentra retorna el nodo encontrado
            if (i == indice){
                return nodoActual;
            }
            // si no lo encuentra pasa al siguiente nodo
            nodoActual = nodoActual.getSiguiente();
            i++;
        }

        // si pasa todo el bucle significa que no encontró el indice dado (esta fuera de rango)
        return null;
    }

}
