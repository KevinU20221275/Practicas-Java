package ventaProductos;

// clase abstracta Producto
public abstract class Producto {
    // propiedades
    private static Integer contadorId = 1; // contador para que los ids se aumenten automaticamente
    private Integer id;
    private String nombre;
    private Double precio;
    private Integer stock;

    // constructor
    public Producto(String nombre, Double precio, Integer stock) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // getters y setters
    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    // método para agregar/actualizar el stock
    public void agregarStock(Integer sumarStock){
        if (sumarStock <= 0){
            System.out.println("El stock a agregar debe ser mayor a 0");
        } else {
            this.stock = this.stock + sumarStock;
            System.out.println("Se actualizo el stock correctamente \nNuevo Stock de " + nombre + ": " + stock);
        }
    }

    // método para reducir el stock
    public Boolean reducirStock(Integer stockAReducir){
        if (stockAReducir > stock){
            return false;
        } else {
            this.stock = this.stock - stockAReducir;
            return true;
        }
    }

    // método para mostrar la información del producto
    @Override
    public String toString() {
        return "Nombre:'" + nombre + '\'' +
                ", Precio: $" + precio +
                ", Stock: " + stock;
    }
}
