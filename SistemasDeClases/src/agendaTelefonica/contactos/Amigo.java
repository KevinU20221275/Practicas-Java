package agendaTelefonica.contactos;

// clase Amigo hereda de Contacto
public class Amigo extends Contacto {
    // propiedad
    private String apodo;

    // constructor
    public Amigo(String nombre, String telefono, String apodo) {
        super(nombre, telefono, TipoContacto.Amigo); // asigna el tipo de contacto directamente
        this.apodo = apodo;
    }

    // getters y setters
    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    // sobreescribe el método toString para mostrar las nuevas propiedades
    @Override
    public String toString() {
        return super.toString() + ", Apodo: " + apodo;
    }
}
