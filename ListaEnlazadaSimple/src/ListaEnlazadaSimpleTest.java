import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// clase de tests
public class ListaEnlazadaSimpleTest {
    // test para verificar la insercion de datos y su listado
    @Test
    void insertarAlInicioYListar(){
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        lista.insertarAllInicio(5);
        lista.insertarAllInicio(20);
        assertEquals("[20,5]", lista.listar());
    }

    // test para verificar la insercion al final de la lista
    @Test
    void insertarAlFinal(){
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(40);
        lista.insertarAlFinal(100);

        assertEquals("[10,40,100]", lista.listar());
    }

    // test para verificar la insercion por indice
    @Test
    void insertarPorIndice(){
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        lista.insertarPorIndice(0, 20);
        lista.insertarPorIndice(1, 25);
        lista.insertarPorIndice(0, 19);
        lista.insertarPorIndice(2, 23);

        assertEquals("[19,20,23,25]", lista.listar());
    }

    // test para verificar la eliminacion por índice
    @Test
    void eliminarPorIndice(){
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        lista.insertarAllInicio(10);
        lista.insertarAllInicio(20);
        lista.insertarAllInicio(40);

        lista.eliminarPorIndice(2);

        assertEquals("[40,20]", lista.listar());
    }

    // test para verificar la búsqueda por indice
    @Test
    void buscarPorIndice(){
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        lista.insertarAlFinal(100);
        lista.insertarAlFinal(240);
        lista.insertarAllInicio(1);

        assertEquals(1, lista.buscarPorIndice(0).getDato());
    }

    // test para verificar la modificacion/actualizacion de datos
    @Test
    void modificarDatosPorIndice(){
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        lista.insertarAllInicio(20);
        lista.insertarAllInicio(100);

        lista.modificarPorIndice(0, 1);
        lista.modificarPorIndice(1,2);

        assertEquals("[1,2]", lista.listar());
    }

    // test para verificar si un indice buscado esta fuera de rango
    @Test
    void buscarPorIndiceFueraDeRango(){
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        lista.insertarAlFinal(100);
        lista.insertarAlFinal(240);
        lista.insertarAllInicio(1);

        assertNull(lista.buscarPorIndice(100));
    }

    // test cuando se quiere insertar un nodo con un índice fuera de rango
    @Test
    void insertarPorIndiceFueraDeRango(){
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();

        assertEquals("Indice fuera de rango", lista.insertarPorIndice(12, 23));
    }

    // test cuando se quiere eliminar un índice que no existe (fuera de rango)
    @Test
    void eliminarPorIndiceFueraDeRango(){
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();

        assertEquals("Indice invalido o lista vaciá", lista.eliminarPorIndice(10));
    }

    // test cuando se quiere modificar un dato con un indice no existente
    @Test
    void modificarPorIndiceFueraDeRango(){
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        lista.insertarAllInicio(50);
        lista.insertarAllInicio(70);

        assertEquals("No se encontró el dato con indice 20", lista.modificarPorIndice(20, 100));
    }
}
