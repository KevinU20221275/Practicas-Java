package singleton;

public class ConexionDBSingleton {
    public static ConexionDBSingleton instancia;

    private ConexionDBSingleton(){
        System.out.println("Conectandose a la db...");
    }

    public static ConexionDBSingleton getInstance(){
        if (instancia == null){
            instancia = new ConexionDBSingleton();
        }

        return instancia;
    }
}
