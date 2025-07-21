package abstractFactory;

import abstractFactory.abstractClasses.PizzaProductoAbstract;

public class PizzaNewYorkVegetariana extends PizzaProductoAbstract {
    public PizzaNewYorkVegetariana() {
        super();
        nombre = "Pizza vegetariana New York";
        masa = "Msa integral vegana";
        salsa = "Salsa de tomate";
        ingredientes.add("Queso vegano");
        ingredientes.add("Tomate");
        ingredientes.add("Berenjenas");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 25 min a 12 grados");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando en rebanadas");
    }
}
