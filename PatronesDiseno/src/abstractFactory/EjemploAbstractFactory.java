package abstractFactory;

import abstractFactory.abstractClasses.PizzaProductoAbstract;

public class EjemploAbstractFactory {
    public static void main(String[] args) {
        PizzeriaZonaAbstracta ny = new PizzeriaNewYorkFactory();

        PizzaProductoAbstract pizza = ny.ordenarPizza("Vegetariana");
        System.out.println("Bruce ordena la pizza " + pizza.getNombre());

        pizza = ny.ordenarPizza("Pepperoni");
        System.out.println("John ordena la pizza " + pizza.getNombre());
    }

    public static class PizzeriaZonaAbstracta {
        public PizzaProductoAbstract ordenarPizza(String tipo){
            PizzaProductoAbstract pizza = crearPizza(tipo);
            System.out.println("----- Fabricando la pizza " + pizza.getNombre() + "----");
            pizza.preparar();
            pizza.cocinar();
            pizza.cortar();
            pizza.empaquetar();

            return pizza;
        }

        PizzaProductoAbstract crearPizza(String tipo) {
            return null;
        }
    }
}
