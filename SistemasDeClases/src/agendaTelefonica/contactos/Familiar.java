package agendaTelefonica.contactos;

// clase Familiar hereda de Contacto
public class Familiar extends Contacto {
    // propiedad
    private String parentesco;

    // constructor
    public Familiar(String nombre, String telefono, String parentesco) {
        super(nombre, telefono, TipoContacto.Familia); // asigna el tipo de contacto directamente
        this.parentesco = parentesco;
    }

    // sobreescribe el método toString para mostrar las nuevas propiedades
    @Override
    public String toString() {
        return super.toString() + ", Parentesco: " + parentesco;
    }
}