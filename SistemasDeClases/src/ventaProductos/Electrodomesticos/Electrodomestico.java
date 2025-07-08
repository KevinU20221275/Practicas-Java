package ventaProductos.Electrodomesticos;

import ventaProductos.Producto;

// clase electrodomestico hereda de producto
public class Electrodomestico extends Producto {
    // propiedades
    private String marca;
    private Double voltaje;
    private Double consumoEnergetico;

    // constructor
    public Electrodomestico(String nombre, Double precio, Integer stock, String marca, Double voltaje, Double consumoEnergetico) {
        super(nombre, precio, stock);
        this.marca = marca;
        this.voltaje = voltaje;
        this.consumoEnergetico = consumoEnergetico;
    }

    // getters y setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(Double voltaje) {
        this.voltaje = voltaje;
    }

    public Double getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void setConsumoEnergetico(Double consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }

    // sobreescribe el metodo toString para imprimir las nuevas propiedades
    @Override
    public String toString() {
        return super.toString() + ", Tipo: Electrodoméstico, Marca: " + marca
                + ", Voltaje: " + voltaje + " voltios, " + "Consumo Energetico: "
                + consumoEnergetico + " voltios";
    }
}
