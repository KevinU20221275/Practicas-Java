package EjemploExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploExecutor {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService excutor = Executors.newSingleThreadExecutor();

        Runnable tarea = () -> {
            System.out.println("Inicio de la tarea...");
            try {
                System.out.println("Nombre del thread " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            System.out.println("Finaliza la tarea...");
        };

        excutor.submit(tarea);
        excutor.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main 1");
        excutor.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("Continuando con la ejecucion del metodo main 2");

    }
}
