// clase Numero para validar que el valor es numerico
public class Numero {
    public static boolean isNumber(String num){
        try {
            Float.parseFloat(num);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
