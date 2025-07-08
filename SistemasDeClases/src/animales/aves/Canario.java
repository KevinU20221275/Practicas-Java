package animales.aves;

import animales.aves.interfaces.Volar;
import animales.especies.Ave;

// ejemplo con interfaces
// clase canario hereda de Ave e implementa la interfaz Volar
public class Canario extends Ave implements Volar {

    // constructor
    public Canario(String nombre, Integer edad) {
        super(nombre, edad);
    }

    // sobreescribe el método Volar de la interfaz
    @Override
    public void volar() {
        System.out.println(getNombre() + " el canario esta volando..");
    }

    @Override
    public String comer() {
        return super.comer() + " semillas....";
    }

}
