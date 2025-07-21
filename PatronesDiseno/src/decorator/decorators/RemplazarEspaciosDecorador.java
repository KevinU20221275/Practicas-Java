package decorator.decorators;

import decorator.Formateable;
import decorator.TextoDecorador;

public class RemplazarEspaciosDecorador extends TextoDecorador {
    public RemplazarEspaciosDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        return texto.darFormato().replace(" ", "_");
    }
}
