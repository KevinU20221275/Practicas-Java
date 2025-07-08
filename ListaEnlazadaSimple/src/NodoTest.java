import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// clase Nodo para test
public class NodoTest {
    // test crear nodo y devolver el dato asignado
    @Test
    void crearNodoYDevolverDato() {
        Nodo nuevoNodo = new Nodo(10);

        assertEquals(10, nuevoNodo.getDato());
    }

    @Test
    void devolverDatoDelSiguienteNodo(){
        Nodo nodo1 = new Nodo(10);
        Nodo nodo2 = new Nodo(40);

        nodo1.setSiguiente(nodo2);

        assertEquals(40, nodo1.getSiguiente().getDato());
    }
}
