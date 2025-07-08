package ventaProductos;

import java.util.Date;
import java.util.HashMap;

// clase Venta
public class Venta {
    // propiedades
    private Integer id;
    private HashMap<Producto, Integer> listaProductosVendidos;
    private Date fecha;
    private Double totalVenta;

    // constructor
    public Venta(Integer idVenta){
        this.id = idVenta;
        this.listaProductosVendidos = new HashMap<>();
        this.fecha = new Date();
        this.totalVenta = 0.0;
    }

    // método getter
    public HashMap<Producto, Integer> getListaProductosVendidos() {
        return listaProductosVendidos;
    }

    // método para agregar productos a la lista de Productos Vendidos
    public void agregarProducto(Producto producto, Integer cantidad){
        if (producto.reducirStock(cantidad)){
            // actualiza la lista de productos
            listaProductosVendidos.put(producto, listaProductosVendidos.getOrDefault(producto, 0) + cantidad);

            // actualiza el total de la venta
            totalVenta += producto.getPrecio() * cantidad;

            System.out.println("Se agrego " + cantidad + " unidades de " + producto.getNombre() + " exitosamente a la venta");
        } else {
            System.out.println("No hay suficiente stock de " + producto.getNombre());
        }
    }

    // método para imprimir los datos de la venta
    public void mostrarVenta(){
        System.out.println("Venta Id: "+ id + " | Fecha: " + fecha);
        listaProductosVendidos.forEach((producto, cantidad) -> {
            System.out.println(producto.getNombre() + " " + producto.getPrecio() + " X " + cantidad + " = " + (producto.getPrecio() * cantidad));
        });
        System.out.println("TOTAL VENTA: " + totalVenta);
    }

    // actualiza la venta tras una Devolucion
    public boolean actualizarPorDevolucion(Producto producto, int cantidad){
        int vendidos = listaProductosVendidos.getOrDefault(producto, 0);

        if (cantidad > vendidos){
            return false; // No se puede devolver mas de los vendidos
        }

        // cantidad a restar de la venta por la devolucion
        double restaPorDevolucion = producto.getPrecio() * cantidad;

        // actualiza la venta
        listaProductosVendidos.put(producto, listaProductosVendidos.getOrDefault(producto, 0) - cantidad);

        // actualiza el total de la venta
        totalVenta = totalVenta - restaPorDevolucion;

        return true;
    }
}
