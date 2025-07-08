package agendaTelefonica;
import agendaTelefonica.contactos.Contacto;

import java.util.*;

// clase Agenda
public class Agenda {
    // propiedades
    private List<Contacto> contactos; // lista de contactos
    private List<Cita> citas; // lista de Citas

    // constructor
    public Agenda() {
        contactos = new ArrayList<>();
        citas = new ArrayList<>();
    }

    // método para agregar un contacto
    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    // método para agendar una cita
    public void agregarCita(Cita cita) {
        citas.add(cita);
    }

    // método para mostrar los contacors
    public void mostrarContactos() {
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }

    // método para mostrar las citas
    public void mostrarCitas() {
        for (Cita c : citas) {
            System.out.println(c);
        }
    }
}
