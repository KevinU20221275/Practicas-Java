package animales.especies;

import animales.Animal;
import animales.aves.interfaces.ComerDormir;

// ejemplo con interfaces
// Clase Ave que extiende de Animal e implementa la interfaz ComerDormir
public class Ave extends Animal implements ComerDormir {
    public Ave(String nombre, Integer edad) {
        super(nombre, edad, Especies.Aves); // asigna la especie ave en el mismo constructor
    }

    // sobreescribe el método comer de la interfaz
    @Override
    public String comer() {
        return getNombre() + " esta comiendo";
    }

    // sobreescribe el método dormir de la interfaz
    @Override
    public void dormir() {
        System.out.println(getNombre() + " esta durmiendo... zzzz");
    }
}
