package agendaTelefonica.contactos;

// clase abstracta Contacto
public abstract class Contacto {
    //  propiedades
    private String nombre;
    private String telefono;
    private TipoContacto tipoContacto;

    // constructor
    public Contacto(String nombre, String telefono, TipoContacto tipoContacto) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipoContacto = tipoContacto;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    // sobreescribe el método toString para mostrar la informacion del contacto
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Teléfono: " + telefono + ", Tipo Contacto: " + tipoContacto;
    }
}
