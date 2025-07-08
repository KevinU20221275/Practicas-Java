package figurasGeometricas.cuadrados;

import figurasGeometricas.Figura;
import figurasGeometricas.TipoFigura;

// clsae Rectangulo hereda de Figura
public class Rectangulo extends Figura {
    // propiedades
    private double base;
    private double altura;

    // constructor
    public Rectangulo(double base, double altura){
        super("Rectángulo", TipoFigura.Cuadrangular);
        this.base = base;
        this.altura = altura;
    }

    // sobreescribe el método calcularArea
    @Override
    public double calcularArea() {
        return base * altura;
    }

    // sobreescribe el método calcularPerimetro
    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    // sobreescribe el método toString
    @Override
    public String toString() {
        return super.toString() + ", Base: " + base + ", Altura: " + altura;
    }
}
