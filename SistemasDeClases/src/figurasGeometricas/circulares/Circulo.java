package figurasGeometricas.circulares;

import figurasGeometricas.Figura;
import figurasGeometricas.TipoFigura;

// clase Circulo extiende de Figura
public class Circulo extends Figura {
    // propiedad
    private double radio;

    // constructor
    public Circulo(double radio){
        super("Circulo", TipoFigura.Circular);
        this.radio = radio;
    };

    // sobreescribe el método calcularArea
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    // sobreescribe el método calcularPerimetro
    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    // sobreescribe el método toString
    @Override
    public String toString() {
        return super.toString() + " , Radio: " + radio;
    }
}
