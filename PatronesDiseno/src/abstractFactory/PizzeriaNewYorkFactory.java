package abstractFactory;

import abstractFactory.abstractClasses.PizzaProductoAbstract;

public class PizzeriaNewYorkFactory extends EjemploAbstractFactory.PizzeriaZonaAbstracta {
    @Override
    PizzaProductoAbstract crearPizza(String tipo) {
        PizzaProductoAbstract producto = null;

        switch (tipo){
            case "Vegetariana" -> producto = new PizzaNewYorkVegetariana();
            case "Pepperoni" -> producto = new PizzaNewYorkPepperoni();
            default -> System.out.println("Tipo no soportado");
        }
        return producto;
    }
}
