package figurasGeometricas.triangulares;

import figurasGeometricas.Figura;
import figurasGeometricas.TipoFigura;

// clase TrianguloEquilatero hereda de figura
public class TrianguloEquilatero extends Figura {
    // propiedad
    private double lado;

    // constructor
    public TrianguloEquilatero(double lado) {
        super("Triangulo Equilatero", TipoFigura.Triangular);
        this.lado = lado;
    }

    // sobreescribe el método calcularArea
    @Override
    public double calcularArea() {
        return (Math.sqrt(3) / 4) * lado * lado;
    }

    // sobreescribe el método calcularPerimetro
    @Override
    public double calcularPerimetro() {
        return 3 * lado;
    }

    // sobreescribe el método toString
    @Override
    public String toString() {
        return super.toString() + " , Tamaño de los Lados: " + lado;
    }
}
