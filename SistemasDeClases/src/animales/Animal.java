package animales;

import animales.especies.Especies;

// clase abstracta Animal
public abstract class Animal {
    private String nombre; // propiedad para guardar el nombre del animal
    private Integer edad; // propiedad para guardar la edad del animal
    private Especies especie; // propiedad para guardar la especie de animal

    // constructor
    public Animal(String nombre, Integer edad, Especies especie) {
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
    }

    // getter y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Especies getEspecie(){
        return especie;
    }

    public void setEspecie(Especies especie){
        this.especie = especie;
    }

    // sobrescritura del método to string para mostrar la información del animal
    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", edad=" + edad + " años" +
                ", especie=" + especie;
    }
}
