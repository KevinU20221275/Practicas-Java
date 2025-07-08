package figurasGeometricas;

// clase abstracta figura
public abstract class Figura {
    private final String nombre;
    private final TipoFigura tipoFigura;

    // constructor
    public Figura(String nombre, TipoFigura tipoFigura){
        this.nombre = nombre;
        this.tipoFigura = tipoFigura;
    }

    // getters
    public TipoFigura getTipoFigura(){
        return tipoFigura;
    }

    public String getNombre() {return nombre;}

    // metodos
    public abstract double calcularArea();

    public abstract double calcularPerimetro();

    @Override
    public String toString(){
        return "Figura: "  + nombre + ", Tipo: " + tipoFigura;
    }
}
