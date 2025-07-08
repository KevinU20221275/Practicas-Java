// clase calculadora
public class Calculadora {
    //metodo para sumar
    public float sumar(float numero1, float numero2 ){
        return numero1 + numero2;
    }

    // metodo para restar
    public float restar(float numero1, float numero2 ){
        return numero1 - numero2;
    }

    // metodo para dividir
    public float dividir(float dividendo, float divisor ){
        return dividendo / divisor;
    }

    // metodo para multiplicar
    public float multiplicar(float numero1, float numero2 ){
        return numero1 * numero2;
    }

    // metodo para exponenciar
    public float exponenciar(float base, float exponente ){
        return (float) Math.pow(base, exponente);
    }

    // metodo para obtnener raiz cuadrada
    public float raiz(float numero){
        return (float) Math.sqrt(numero);
    }
}
