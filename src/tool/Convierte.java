package tool;

import java.util.regex.Pattern;

public class Convierte {

    public static Integer aInteger(String s) {
        Integer result = null;

        if (s != null) {
            try {
                result = Integer.valueOf(s);
            } catch (NumberFormatException ex) {
            }
        }

        return result;
    }

    public static Double aDouble(String s) {
        Double result = null;

        if (s != null) {
            try {
                result = Double.valueOf(s);
            } catch (NumberFormatException ex) {
            }
        }

        return result;
    }

    public Convierte() {
    }
    
    public static boolean esNumero(String cadena){
        return Pattern.matches("[0-9]+",cadena);
    }
    
    public static boolean esString(String cadena){
        return Pattern.matches("[a-zA-ZñÑ\\t\\n\\x0b\\r\\f]+",cadena);
    }
}
