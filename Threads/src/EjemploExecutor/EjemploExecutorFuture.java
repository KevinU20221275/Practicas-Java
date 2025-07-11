package EjemploExecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService excutor = Executors.newSingleThreadExecutor();

        Runnable tarea = () -> {
            System.out.println("Inicio de la tarea...");
            try {
                System.out.println("Nombre del thread " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            System.out.println("Finaliza la tarea...");
        };

        Future<?> resultado = excutor.submit(tarea);
        excutor.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main 1");
        System.out.println(resultado.isDone());
        System.out.println(resultado.get(2, TimeUnit.SECONDS));
        System.out.println(resultado.isDone());
    }
}
