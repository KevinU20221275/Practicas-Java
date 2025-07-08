package figurasGeometricas.circulares;

import figurasGeometricas.Figura;
import figurasGeometricas.TipoFigura;

// clase Óvalo hereda de Figura
public class Ovalo extends Figura {
    // propiedades
    private double radioMayor;
    private double radioMenor;

    // constructor
    public Ovalo(double radioMayor, double radioMenor){
        super("Óvalo", TipoFigura.Circular);

        // valida qque los radios sean positivos
        if (radioMayor <= 0 || radioMenor <= 0) {
            throw new IllegalArgumentException("Los radios deben ser mayores a cero.");
        }

        this.radioMayor = radioMayor;
        this.radioMenor = radioMenor;
    }

    // sobreescribe el método calcularArea
    @Override
    public double calcularArea() {
        return Math.PI * radioMayor * radioMenor;
    }

    // sobreescribe el método calcularPerimetro
    @Override
    public double calcularPerimetro() {
        double a = radioMayor;
        double b = radioMenor;

        return Math.PI * (3*(a + b) - Math.sqrt((3 * a + b)*(a + 3*b)));
    }

    // sobreescribe el método toString
    @Override
    public String toString() {
        return super.toString() + " , Radio Mayor: " + radioMayor + ", Radio Menor: " + radioMenor;
    }
}
