package animales.especies;

import animales.Animal;

// clase Mamifero que extiende de Animal
public class Mamifero extends Animal {
    public Mamifero(String nombre, Integer edad){
        super(nombre, edad, Especies.Mamiferos); // asigna la especie directamente como Mamifero
    }
}
