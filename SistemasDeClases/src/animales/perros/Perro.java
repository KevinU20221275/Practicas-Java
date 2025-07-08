package animales.perros;

import animales.especies.Mamifero;

// clase Perro que extiende de Mamifero
public class Perro extends Mamifero {
    private String raza; // propiedad para guardar la raza del perro
    private boolean necesitaCortePelo; // propiedad para saber si el perro necesita corte de pelo
    private boolean puedeNadar; // propiedad para saber si el perro puede nadar

    // constructor
    public Perro(String nombre, Integer edad, String raza, boolean necesitaCortePelo, boolean puedeNadar){
        super(nombre, edad);
        this.raza = raza;
        this.necesitaCortePelo = necesitaCortePelo;
        this.puedeNadar = puedeNadar;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public boolean isNadar() {
        return puedeNadar;
    }

    public void setNadar(boolean puedeNadar) {
        this.puedeNadar = puedeNadar;
    }

    public boolean isNecesitaCortePelo() {
        return necesitaCortePelo;
    }

    public void setNecesitaCortePelo(boolean necesitaCortePelo) {
        this.necesitaCortePelo = necesitaCortePelo;
    }

    // método para que se comportara diferente dependiendo si el perro necesita corte de pelo (polimorfismo)
    public void cortarPelo(){
        if (necesitaCortePelo){
            System.out.println(getNombre() + " de raza " + raza + " necesita corte de pelo.");
        } else  {
            System.out.println(getNombre() + " de raza " + raza + " no necesita corte de pelo.");
        }
    }

    // método para que se comportara diferente dependiendo si el perro puede nadar (polimorfismo)
    public void nadar(){
        if (puedeNadar){
            System.out.println(getNombre() + " de raza " + raza + " está nadando.");
        } else {
            System.out.println(getNombre() + " de raza " + raza + " no puede nadar.");
        }
    }

    // métodos basicos de la clase Perro
    public void ladrar(){
        System.out.println("Gua Gua");
    }

    public void correr(){
        System.out.println(getNombre() + " esta corriendo...");
    }

    public void comer() {
        System.out.println(getNombre() + " esta comiendo...");
    }

    public void dormir() {
        System.out.println(getNombre() + " esta durmiendo... zzzzz");
    }

    // sobreescribe el método to String de clase Animal para agregar la información restante del perro
    @Override
    public String toString() {
        return super.toString() +
                ", Raza='" + raza + '\'' +
                ", Necesita corte de pelo: " + (necesitaCortePelo ? "Sí" : "No") +
                ", Puede nadar: " + (puedeNadar ? "Sí" : "No");
    }
}
