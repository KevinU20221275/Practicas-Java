package animales.aves;

import animales.aves.interfaces.Nadar;
import animales.aves.interfaces.Volar;
import animales.especies.Ave;

// ejemplo con interfaces
// clase Pato hereda de Ave e implementa las interfaces Volar y Nadar
public class Pato extends Ave implements Volar, Nadar {

    // constructor
    public Pato(String nombre, Integer edad) {
        super(nombre, edad);
    }

    // sobreescribe el método volar de la interfaz
    @Override
    public void volar() {
        System.out.println(getNombre() + " el pato esta volando...");
    }

    // sobreescribe el método nadar de la interfaz
    @Override
    public void nadar() {
        System.out.println(getNombre() + " el pato esta nadando...");
    }

    @Override
    public String comer() {
        return super.comer() + " peces...";
    }
}
