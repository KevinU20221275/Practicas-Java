package agendaTelefonica;

import agendaTelefonica.contactos.Contacto;

import java.util.Date;

// clase Cita
public class Cita {
    // propiedades
    private String id;
    private Contacto contacto;
    private String motivo;
    private Date fechaHora;
    private String lugar;

    // constructor
    public Cita(String id, Contacto contacto, String motivo, Date fechaHora, String lugar) {
        this.id = id;
        this.contacto = contacto;
        this.motivo = motivo;
        this.fechaHora = fechaHora;
        this.lugar = lugar;
    }

    // getter
    public Contacto getContacto() {
        return contacto;
    }

    // sobreescribe el método toString para mostrar la informacion de la cita
    @Override
    public String toString() {
        return "Cita con: " + contacto.getNombre() +
                ", Motivo: " + motivo +
                ", Fecha y Hora: " + fechaHora +
                ", Lugar: " + lugar;
    }
}

