package animales.aves;

import animales.aves.interfaces.Correr;
import animales.especies.Ave;

// Clase Avestruz hereda de Ave e implementa la interfaz Correr
public class Avestruz extends Ave implements Correr {

    // constructor
    public Avestruz(String nombre, Integer edad) {
        super(nombre, edad);
    }

    // sobreescribe el método correr de la interfaz
    @Override
    public void correr() {
        System.out.println(getNombre() + " la avestruz esta corriendo...");
    }

    @Override
    public String comer() {
        return super.comer() + " plantas y raises ...";
    }
}
