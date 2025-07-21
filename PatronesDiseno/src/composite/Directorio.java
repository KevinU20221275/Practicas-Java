package composite;

import java.util.ArrayList;
import java.util.List;

public class Directorio extends Componente {
    private List<Componente> hijos;

    public Directorio(String nombre) {
        super(nombre);
        this.hijos = new ArrayList<>();
    }

    public Directorio addComponent(Componente componente){
        this.hijos.add(componente);
        return this;
    }

    public void removeComponente(Componente componente){
        hijos.remove(componente);
    }

    @Override
    public String mostrar(int nivel) {
        StringBuilder sb = new StringBuilder("\t".repeat(nivel));
        sb.append(nombre)
                .append("/").append("\n");
        for (Componente hijo: this.hijos){
            sb.append(hijo.mostrar(nivel + 1));
            if (hijo instanceof Archivo){
                sb.append("\n");
            }
        }

        return sb.toString();
    }


}
