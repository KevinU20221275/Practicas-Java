package agendaTelefonica;

import agendaTelefonica.contactos.Amigo;
import agendaTelefonica.contactos.Companero;
import agendaTelefonica.contactos.Familiar;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // instancia de agenda
        Agenda agenda = new Agenda();

        // instancias de contactos
        Familiar mama = new Familiar("Gloria", "70700000", "Madre"); // Familia
        Amigo amigo = new Amigo("Pedro", "77770005", "Pepe"); // Amigo
        Companero companero = new Companero("Ana", "78787878", "ana@kodigo.com", "Kodigo"); // Companero

        // agregar Contactos a la agenda
        agenda.agregarContacto(mama);
        agenda.agregarContacto(amigo);
        agenda.agregarContacto(companero);

        // agendar Citas
        agenda.agregarCita(new Cita("cita1", mama, "Ir al médico", new Date(), "Hospital San Rafael"));
        agenda.agregarCita(new Cita("cita2", amigo, "Ir al cine", new Date(), "Cinemark"));
        agenda.agregarCita(new Cita("cita3", companero, "Planificar un proyecto de Software", new Date(), "Empresa"));

        // imprime los contactos en la agenda
        System.out.println("=========== Contactos ==========");
        agenda.mostrarContactos();

        // imprime las citas en la agenda
        System.out.println("\n============ Citas ============");
        agenda.mostrarCitas();
    }
}

