package ventaProductos.Muebles;

import ventaProductos.Producto;

// clase Mueble hereda de Producto
public class Mueble extends Producto {
    // propiedades
    private String material;
    private Double alto;
    private Double ancho;
    private String color;

    // constructor
    public Mueble(String nombre, Double precio, Integer stock, String material, Double alturaMetros, Double anchoMetros, String color) {
        super(nombre, precio, stock);
        this.material = material;
        this.alto = alturaMetros;
        this.ancho = anchoMetros;
        this.color = color;
    }

    // getters y setters
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getAlto() {
        return alto;
    }

    public void setAlto(Double alto) {
        this.alto = alto;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // sobreescribe el metodo toString para mostrar las nuevas propiedades
    @Override
    public String toString() {
        return super.toString() + ", Material: " + material + ", Altura: "  +alto + " metros, "
                + " Ancho: " + ancho + " metros, " + "Color: " + color;
    }
}
