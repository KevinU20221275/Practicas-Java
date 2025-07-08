package figurasGeometricas;

import figurasGeometricas.circulares.*;
import figurasGeometricas.cuadrados.*;
import figurasGeometricas.triangulares.TrianguloEquilatero;

public class Main {
    public static void main(String[] args) {
        // instancias de la correspondiente figura
        Figura circulo = new Circulo(5);
        Figura cuadrado = new Cuadrado(4);
        Figura trianguloEquilatero = new TrianguloEquilatero(5);
        Figura ovalo = new Ovalo(8.2, 4.5);
        Figura rectangulo = new Rectangulo(10, 4);

        // imprime la información de círculo y el resultado sus métodos
        System.out.println(circulo);
        System.out.println("Área: " + circulo.calcularArea());
        System.out.println("Perímetro: " + circulo.calcularPerimetro());

        System.out.println();

        // imprime la información de cuadrado y el resultado sus métodos
        System.out.println(cuadrado);
        System.out.println("Área: " + cuadrado.calcularArea());
        System.out.println("Perímetro: " + cuadrado.calcularPerimetro());

        System.out.println();

        // imprime la información de trianguloEquilatero y el resultado sus métodos
        System.out.println(trianguloEquilatero);
        System.out.println("Área: " + trianguloEquilatero.calcularArea());
        System.out.println("Perímetro: " + trianguloEquilatero.calcularPerimetro());

        System.out.println();

        // imprime la información de óvalo y el resultado sus métodos
        System.out.println(ovalo);
        System.out.println("Área: " + ovalo.calcularArea());
        System.out.println("Perímetro: " + ovalo.calcularPerimetro());

        System.out.println();

        // imprime la información de rectangulo y el resultado sus métodos
        System.out.println(rectangulo);
        System.out.println("Área: " + rectangulo.calcularArea());
        System.out.println("Perímetro: " + rectangulo.calcularPerimetro());
    }
}
