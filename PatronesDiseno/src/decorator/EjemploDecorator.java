package decorator;

import decorator.decorators.MayusculasDecorador;
import decorator.decorators.RemplazarEspaciosDecorador;
import decorator.decorators.ReversaDecorador;

public class EjemploDecorator {
    public static void main(String[] args) {
        Formateable texto = new Texto("Hola que tal");

        MayusculasDecorador mayusculas = new MayusculasDecorador(texto);

        ReversaDecorador reversa = new ReversaDecorador(mayusculas);

        RemplazarEspaciosDecorador remplazarEspacios = new RemplazarEspaciosDecorador(reversa);

        System.out.println(remplazarEspacios.darFormato());
    }
}
