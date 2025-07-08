package agendaTelefonica.contactos;

// clase Companero hereda de Contacto
public class Companero extends Contacto {
    // propiedades
    private String empresa;
    private String correo;

    // constructor
    public Companero(String nombre, String telefono, String correo, String empresa) {
        super(nombre, telefono, TipoContacto.Companero); // asigna el tipo de contacto directamente
        this.empresa = empresa;
        this.correo = correo;
    }

    // getters y setters
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // sobreescribe el método toString para mostrar las nuevas propiedades
    @Override
    public String toString() {
        return super.toString() + ", Empresa: " + empresa + ", Correo: " + correo;
    }
}