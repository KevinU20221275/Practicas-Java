package animales;

import animales.aves.Avestruz;
import animales.aves.Canario;
import animales.aves.Pato;
import animales.perros.Perro;

public class Main {
    public static void main(String[] args) {

        System.out.println("======== 🐶 MAMÍFEROS CON POLIMORFISMO ==============");

        // crea instancias de la clase Perro
        Perro perro1 = new Perro("pepe", 2, "Pastor Aleman", false, true);
        Perro perro2 = new Perro("Luci", 1, "Maltes", true, true);
        Perro perro3 = new Perro("Max", 3, "Yorkshire Terrier", true, false);

        // todos los perros pueden comer
        System.out.println("*********** Los perros están comiendo ************");
        perro1.comer();
        perro2.comer();
        perro3.comer();

        System.out.println();

        // todos los perros pueden ladrar
        System.out.println("*********** Los perros están ladrando ************");
        perro1.ladrar();
        perro2.ladrar();
        perro3.ladrar();

        System.out.println();

        // todos los perros pueden correr
        System.out.println("*********** Los perros están corriendo ************");
        perro1.correr();
        perro2.correr();
        perro3.correr();

        System.out.println();

        // muestra toda la información del perro (no es necesario llamar .toString())
        System.out.println("*********** Informacion de los perros ************");
        System.out.println(perro1);
        System.out.println(perro2);
        System.out.println(perro3);

        System.out.println();

        // los perros están durmiendo
        System.out.println("*********** Los perros están durmiendo ************");
        perro1.dormir();
        perro2.dormir();
        perro3.dormir();

        System.out.println();

        System.out.println("*********** Cortes de Pelo ************");
        perro1.cortarPelo(); // perro uno de raza Pastor Aleman no necesita cortes de pelo
        perro2.cortarPelo(); // perro dos de raza Maltes necesita cortes de pelo
        perro3.cortarPelo(); // perro tres de raza Yorkshire Terrier necesita cortes de pelo

        System.out.println();

        // los perros están durmiendo
        System.out.println("*********** Perros Nadando ************");
        perro1.nadar(); // perro uno de raza Pastor Aleman puede nadar
        perro2.nadar(); // perro dos de raza Maltes puede nadar
        perro3.nadar(); // perro tres de raza Yorkshire Terrier no puede nadar

        System.out.println();
        System.out.println("======== 🐦 AVES CON INTERFACES =====================");

        // instancias de Canario, Avestruz y Pato
        Canario canario = new Canario("Piolin", 1);
        Avestruz avestruz = new Avestruz("Elena", 5);
        Pato pato = new Pato("Donald", 2);

        // todos pueden comer pero sobreescriben el método segun con lo que se alimentan
        System.out.println(canario.comer());
        System.out.println(avestruz.comer());
        System.out.println(pato.comer());

        System.out.println();

        // todos pueden dormir
        System.out.println("*********** Las aves están durmiendo ************");
        canario.dormir();
        avestruz.dormir();
        pato.dormir();

        System.out.println();

        // solo avestruz tiene la capacidad de correr
        avestruz.correr();

        // pato y canario pueden volar
        pato.volar();
        canario.volar();

        // solo pato puede nadar
        pato.nadar();

        System.out.println();

        // muestra la información de las aves
        System.out.println("*********** Informacion de las aves ************");
        System.out.println(pato);
        System.out.println(canario);
        System.out.println(avestruz);
    }
}
