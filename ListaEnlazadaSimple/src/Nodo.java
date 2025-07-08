public class Nodo {
    private int dato;
    private Nodo siguiente;

    // constructor
    public Nodo(int dato) {
        this.dato = dato; // asigna el dato a la propiedad
        this.siguiente = null; // inicia siguiente como null
    }

    // retorna el nodo siguiente
    public Nodo getSiguiente() {
        return siguiente;
    }

    // método para asignar el nodo siguiente
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    // retorna el dato del nodo
    public int getDato() {
        return dato;
    }

    // inserta el dato
    public void setDato(int dato) {
        this.dato = dato;
    }
}
