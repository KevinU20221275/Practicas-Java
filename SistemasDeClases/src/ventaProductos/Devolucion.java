package ventaProductos;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// clase Devlucion
public class Devolucion {
    // propiedades
    private String id;
    private Venta ventaOriginal;
    private Map<Producto, Integer> productosDevueltos;
    private Date fecha;

    // constructor
    public Devolucion(String idDevolucion, Venta ventaOriginal){
        this.id = idDevolucion;
        this.productosDevueltos = new HashMap<>();
        this.ventaOriginal = ventaOriginal;
        this.fecha = new Date();
    }

    // agrega productos a su lista de devoluciones
    public void agregarProductoDevuelto(Producto producto, int cantidad, TipoDevoluciones tipoDevolucion){
        // verifica si el producto fue parte de la venta original
        if (!ventaOriginal.getListaProductosVendidos().containsKey(producto)){
            System.out.println("Este Producto no fue parte de la venta original");
            return;
        }

        // cantidad vendida originalmente
        int cantidadVendida = ventaOriginal.getListaProductosVendidos().get(producto);

        // cantidad de producto devuelta previamente sí la hay
        int cantidadDevueltaPreviamente = productosDevueltos.getOrDefault(producto, 0);

        if (cantidadVendida == 0){
            System.out.println("Ya se recibieron todas las devoluciones del producto previamente vendido");
            return;
        }

        // verifica que la cantidad devuelta mas cantidad devuelta previamente si la hay no sean mayor a la cantidad de producto que se vendio originalmente
        if (cantidad + cantidadDevueltaPreviamente > cantidadVendida){
            System.out.println("No se puede aceptar la devolucion de mas unidades de las que fueron vendidas del producto " + producto.getNombre());
            return;
        }

        // agrega el producto devuelto a devoluciones
        productosDevueltos.put(producto, productosDevueltos.getOrDefault(producto, 0) + cantidad);

        /* el producto devuelto se suma al stock solo si el tipo de devolucion es por cambio de opinion
        * si es por avería no se suma al stock */
        System.out.println("Se acepto la devolucion de " + cantidad + " " + producto.getNombre());

        // actualiza la venta original
        ventaOriginal.actualizarPorDevolucion(producto, cantidad);

        if (tipoDevolucion.equals(TipoDevoluciones.CambioOpinion)){
            producto.agregarStock(cantidad); // actualiza el stock
        }
    }

    // muestra las devoluciones
    public void mostrarDevolucion() {
        System.out.println("Devolucion ID: " + id + " | Fecha: " + fecha);
        productosDevueltos.forEach((producto, cantidad) -> {
            System.out.println(producto.getNombre() + " X " + cantidad);
        });
    }
}
