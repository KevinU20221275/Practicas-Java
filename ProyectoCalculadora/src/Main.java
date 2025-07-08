import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // crea una intancia de la clase operacion
        Operacion operacion = new Operacion();
        // variable para continuar ejecutando el bucle while
        boolean continuar = true;
        // instancia de Scanner para capturar los inputs del usuario
        Scanner scanner = new Scanner(System.in);

        // bucle while
        while(continuar) {
            // variable para guardar la opcion ingresada por el usuario
            int opcion;

            // menu de opciones
            System.out.println("======== CALCULADORA ===========");
            System.out.println("------ MENU DE OPERACIONES --------");
            System.out.println("1. Sumar \n" +
                    "2. Restar \n" +
                    "3. Dividir \n" +
                    "4. Multiplicar \n" +
                    "5. Exponenciar \n" +
                    "6. Raiz \n" +
                    "7. Salir");
            System.out.println("--------------------------------------");

            System.out.print("Ingrese una opcion: ");

            // manejo de error por un valor no valido ingresado por el usuario
            try {
                // captura el valor ingresado por el usuario y lo guarda en la variable
                opcion = scanner.nextInt();
                scanner.nextLine(); // limpia el scanner

                // variables para guardar los valores a operar ingresados por el usuario
                String numero1, numero2;

                // switch para manejar los casos segun la opcion ingresada
                switch (opcion){
                    case 1,2,3,4 -> {
                        // captura los valores a operar
                        System.out.print("Ingrese el primer número: ");
                        numero1 = scanner.nextLine();
                        System.out.print("Ingrese el segundo número: ");
                        numero2 = scanner.nextLine();

                        // guarda el tipo de operacion a realizar segun la opcion ingresada por el usuario
                        TiposOperaciones tipoOperacion = switch (opcion) {
                            case 1 -> TiposOperaciones.SUMAR;
                            case 2 -> TiposOperaciones.RESTAR;
                            case 3 -> TiposOperaciones.DIVIDIR;
                            case 4 -> TiposOperaciones.MULTIPLICAR;
                            default -> null;
                        };

                        // imprime directamente el resultado de la operacion
                        System.out.println(operacion.realizarOperacion(numero1, numero2, tipoOperacion));
                    }
                    case 5 -> {
                        // captura los valores a operar
                        System.out.print("Ingrese la base: ");
                        numero1 = scanner.nextLine();
                        System.out.print("Ingrese el exponente: ");
                        numero2 = scanner.nextLine();

                        // imprime el resultado de la operacion
                        System.out.println(operacion.realizarOperacion(numero1, numero2, TiposOperaciones.EXPONENCIAR));
                    }
                    case 6 -> {
                        // captura el valor a operar
                        System.out.print("Ingrese el número: ");
                        numero1 = scanner.nextLine();

                        // imprime el resultado de la operacion
                        System.out.println(operacion.realizarOperacion(numero1, "0", TiposOperaciones.RAIZ));
                    }
                    case 7 -> {
                        System.out.println("Gracias por usar la calculadora. ¡Hasta pronto!");
                        // cambia la variable continuar a false terminando con el bucle
                        continuar = false;
                    }

                    // mensaje por default si se ingreso un valor numerico que no esta en las opciones
                    default -> System.out.println("Opción no válida. Intente de nuevo.");

                }
            } catch (Exception e){
                // mensaje de error en caso qe ingresarse un valor no numerico en opcion
                System.out.println("Error: Ingrese una opcion valida del menu (1 | 2 | 3 | 4 | 5 | 6 | 7)");
                scanner.nextLine(); // limpia el scanner
            }

            // agrega un salto de linea
            System.out.println();
        }
    }
}