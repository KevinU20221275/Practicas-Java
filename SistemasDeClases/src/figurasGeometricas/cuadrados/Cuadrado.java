package figurasGeometricas.cuadrados;

import figurasGeometricas.Figura;
import figurasGeometricas.TipoFigura;

// clase Cuadrado hereda de Figura
public class Cuadrado extends Figura {
    // propiedad
    private double lado;

    // constructor
    public Cuadrado(double lado){
        super("Cuadrado", TipoFigura.Cuadrangular);
        this.lado = lado;
    }

    // sobreescribe el método calcularArea
    @Override
    public double calcularArea() {
        return lado * lado;
    }

    // sobreescribe el método calcularPerimetro
    @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }

    // sobreescribe el método toString
    @Override
    public String toString() {
        return super.toString() + " , Tamaño de los Lados: " + lado;
    }
}
