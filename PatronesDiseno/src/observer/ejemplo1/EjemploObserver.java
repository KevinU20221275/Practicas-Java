package observer.ejemplo1;

public class EjemploObserver {
    public static void main(String[] args) {
        Corporacion google = new Corporacion("Google", 1000);
        google.addObserver((observable,obj) -> {
            System.out.println("Jhon: " + observable);
        });

        google.addObserver((observable, obj) -> {
            System.out.println("Pedro: " + observable);
        });

        google.addObserver((observable, obj) -> {
            System.out.println("Maria: " + observable);
        });

        google.modificarPrecio(2000);
    }
}
