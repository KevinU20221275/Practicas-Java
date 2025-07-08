package ventaProductos;

import ventaProductos.Electrodomesticos.Electrodomestico;
import ventaProductos.Muebles.Mueble;

public class Main {
    public static void main(String[] args) {
        // instancias de electrodomésticos
        Electrodomestico refrigeradora = new Electrodomestico("Refrigeradora Samsung", 200.00, 4, "Samsung", 12.0, 4.0);
        Electrodomestico hornoMicroondas = new Electrodomestico("Horno Microondas", 75.0, 10, "Samsung", 8.0, 2.0);
        // instancia de mueble
        Mueble mesa = new Mueble("Mesa", 40.0, 4, "Marmol", 1.2, 1.0, "Blanco");

        // imprime los stocks antes de realiar las ventas
        System.out.println("****** Stock de Productos previo a la venta *********");
        System.out.println("Stock de Mesa: " + mesa.getStock());
        System.out.println("Stock de Refrigeradora: " + refrigeradora.getStock());
        System.out.println("Stock de Horno Microonda: " + hornoMicroondas.getStock());

        System.out.println();

        // instancia de venta
        Venta venta1 = new Venta(1);
        Venta venta2 = new Venta(2);

        // agrega Productos a la venta1
        venta1.agregarProducto(mesa, 2); // agrega 2 mesas a la venta
        venta1.agregarProducto(refrigeradora, 1); // agrega un refrigeradora a la venta

        // agrega Productos a la venta2
        venta2.agregarProducto(mesa, 1);
        venta2.agregarProducto(hornoMicroondas, 2);

        System.out.println();

        // imprime las ventas
        System.out.println("*********** VENTAS ****************");
        venta1.mostrarVenta();
        System.out.println("---------------------------");
        venta2.mostrarVenta();

        System.out.println();

        // imprime los stocks después de las ventas
        System.out.println("****** Stock de Productos después de las ventas *********");
        System.out.println("Stock de Mesa: " + mesa.getStock());
        System.out.println("Stock de Refrigeradora: " + refrigeradora.getStock());
        System.out.println("Stock de Horno Microonda: " + hornoMicroondas.getStock());

        System.out.println();

        //  instancias de devoluciones
        Devolucion devolucion1 = new Devolucion("1", venta1); // para venta1
        Devolucion devolucion2 = new Devolucion("2", venta2); // para venta2

        // registra devoluciones
        devolucion1.agregarProductoDevuelto(mesa, 1, TipoDevoluciones.CambioOpinion); //devoluciones de la primera venta
        System.out.println("-------------------------------------------");
        devolucion1.agregarProductoDevuelto(refrigeradora, 1, TipoDevoluciones.CambioOpinion);
        System.out.println("--------------------------------------------");

        devolucion2.agregarProductoDevuelto(mesa, 1, TipoDevoluciones.CambioOpinion); // devolucion en la segunda venta
        System.out.println("---------------------------------------------");
        devolucion2.agregarProductoDevuelto(hornoMicroondas, 1, TipoDevoluciones.Averia); // al ser avería no se actualizará el stock de hornoMicroonda

        System.out.println();

        // muestra la información de ambas devoluciones
        System.out.println("************* DEVOLUCIONES **************");
        devolucion1.mostrarDevolucion();
        System.out.println("--------------------------------------");
        devolucion2.mostrarDevolucion();

        System.out.println();

        // imprime los stocks después de las devoluciones
        System.out.println("****** Stock de Productos después de las devoluciones *********");
        System.out.println("Stock de Mesa: " + mesa.getStock());
        System.out.println("Stock de Refrigeradora: " + refrigeradora.getStock());
        System.out.println("Stock de Horno Microonda: " + hornoMicroondas.getStock());

        System.out.println();

        // imprime la información de las ventas después de las devoluciones
        System.out.println("*********** VENTAS ****************");
        venta1.mostrarVenta();
        System.out.println("---------------------------");
        venta2.mostrarVenta();

        System.out.println();

        // pruebas límites
        // venta que exceda el stock
        venta1.agregarProducto(mesa, 20); // solo hay 3 mesas en existencias

        // devolucion de un producto que no está en la venta
        devolucion1.agregarProductoDevuelto(hornoMicroondas, 2, TipoDevoluciones.CambioOpinion); // hornoMicroondas no es parte de la venta original

        // devolucion de una cantidad de producto mayor a la vendida
        devolucion1.agregarProductoDevuelto(mesa, 2, TipoDevoluciones.Averia); // ya se devolvio 1 mesa previamente y solo se vendieron 2 originalmente
    }
}
