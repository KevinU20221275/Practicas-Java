package abstractFactory.abstractClasses;

import java.util.ArrayList;
import java.util.List;

abstract public class PizzaProductoAbstract {
    protected String nombre;
    protected String masa;
    protected String salsa;
    protected List<String> ingredientes;

    public PizzaProductoAbstract(){
        this.ingredientes = new ArrayList<>();
    }

    public void preparar(){
        System.out.println("Preparando " + nombre);
        System.out.println("Seleccionando la masa " + masa);
        System.out.println("Agregando la salsa " + salsa);
        System.out.println("Agregando los ingredientes: ");
        this.ingredientes.forEach(System.out::println);
    }

    abstract public void cocinar();

    public abstract void cortar();

    public void empaquetar(){
        System.out.println("Poniendo la pizza en una caja de empaque...");
    }

    public String getMasa() {
        return masa;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSalsa() {
        return salsa;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    @Override
    public String toString() {
        return "PizaProductoAbstract{" +
                "nombre='" + nombre + '\'' +
                ", masa='" + masa + '\'' +
                ", salsa='" + salsa + '\'' +
                ", ingredientes=" + ingredientes +
                '}';
    }
}
