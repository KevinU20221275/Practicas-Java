package abstractFactory;

import abstractFactory.abstractClasses.PizzaProductoAbstract;

public class PizzaNewYorkPepperoni extends PizzaProductoAbstract {
    public PizzaNewYorkPepperoni(){
        super();
        nombre = "Pizza Pepperoni New York";
        masa = "Masa delgada a la piedra";
        salsa = "Salsa de tomate";
        ingredientes.add("Queso mozzarella");
        ingredientes.add("Extra pepperoni");
    }
    @Override
    public void cocinar() {
        System.out.println("Cocinando en 40 min a 20 grados");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en triangulos medianos");
    }
}
