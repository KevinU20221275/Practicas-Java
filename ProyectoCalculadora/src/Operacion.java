public class Operacion {
    // propiedades de la clase para guardar los valores ingresados si son de tipo numerico
    private float numero1;
    private float numero2;

    // crea una instancia de la clase calculadora
    private final Calculadora calculadora = new Calculadora();

    // metodo publico para ejecutar las operaciones segun el tipo de operacion
    public String realizarOperacion(String a, String b, TiposOperaciones operacion){

        if (operacion == TiposOperaciones.RAIZ){
            // valida que el numero para raiz cuadrada sea numerico
            if (!Numero.isNumber(a)) return "Error: Ingrese un valor numerico";

            // combierte el numero a float y lo asigna a la propiedad numero1
            numero1 = Float.parseFloat(a);

            // valida que el numero sea mayor a 0
            if (numero1 < 0) return "Error: No se puede calcular la raiz de un numero negativo";
            return "La raíz cuadrada de " + a + " es igual a " + calculadora.raiz(numero1);
        }

        // valida que ambos valores sean numericos
        boolean areNumber = (Numero.isNumber(a) && Numero.isNumber(b));

        // si uno de los dos o ambos no son numericos retorna un menaje de error y no realiza ninguna operacion
        if (!areNumber) return  "Error: Por favor ingrese valores numericos";

        // si pasa la validacion asingna los valores a las propieades numero1 y numero2
        numero1 = Float.parseFloat(a);
        numero2 = Float.parseFloat(b);

        // switch para ejecutar las operacion segun el caso retornando un string con los resultados de cada operacion
        switch (operacion){
            case SUMAR -> {
                return "La suma de " + a + " + " + b + " es igual a " + calculadora.sumar(numero1, numero2);
            }
            case RESTAR -> {
                return  "La resta de " + a + " - " + b + " es igual a " + calculadora.restar(numero1, numero2);
            }
            case MULTIPLICAR -> {
                return  "La multiplicacion de " + a + " * " + b + " es igual a " + calculadora.multiplicar(numero1, numero2);
            }
            case DIVIDIR -> {
                // en el caso de la operacion dividir verifica que el divisor no sea 0 si lo es retorna un mensaje de error
                if (numero2 == 0){
                    return "Error no se puede dividir por 0";
                } else {
                    return  "La divicion de " + a + " / " + b + " es igual a " + calculadora.dividir(numero1, numero2);
                }
            }
            case EXPONENCIAR -> {
                return  "La exponenciacion de " + a + " elevado a " + b + " es igual a " + calculadora.exponenciar(numero1, numero2);
            }
            default -> {
                return "Error: Operacion no valida";
            }
        }
    }
}
