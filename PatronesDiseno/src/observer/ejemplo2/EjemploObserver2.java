package observer.ejemplo2;

public class EjemploObserver2 {
    public static void main(String[] args) {
        UsuarioRepositorio repo = new UsuarioRepositorio();

        repo.addObserver((o, u) -> System.out.println("Enviando email al usuario " + u));
        repo.addObserver((o, u) -> System.out.println("Enviando email al adminitrador"));
        repo.addObserver((o, u) -> System.out.println("Guardando la info del usuario " + u + " en logs"));

        repo.crearUsuario("Pepe");


    }
}
