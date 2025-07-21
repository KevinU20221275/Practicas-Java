package decorator.decorators;

import decorator.Formateable;
import decorator.TextoDecorador;

public class MayusculasDecorador extends TextoDecorador {
    public MayusculasDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        return texto.darFormato().toUpperCase();
    }
}
