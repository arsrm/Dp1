/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Kari
 */
public class Validate 
{
    // Como usar Regex
    // http://www.mkyong.com/regular-expressions/how-to-validate-email-address-with-regular-expression/

    // Patrones
    // http://www.codeproject.com/Articles/13255/Validation-with-Regular-Expressions-Made-Simple
    
    public static boolean validarEmail(String cadena)
    {
        if (cadena.equals(""))
            return true;
        
        String patron = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        return validar(patron, cadena);
    }
    
    public static boolean validarEntero(String cadena)
    {
        if (cadena.equals(""))
            return true;
        
        String patron = "^[0-9]*$";
        return validar(patron,cadena);
    }
    
    public static boolean validarReal(String cadena)
    {
        if (cadena.equals(""))
            return true;
        
        String patron = "^[0-9]*\\.?[0-9]*$";
        return validar(patron,cadena);
    }
    
    public static boolean validarRealMg(String cadena)
    {
        if (cadena.equals(""))
            return false;
        
        String patron = "^[0-9]*\\.?[0-9]*$";
        return validar(patron,cadena);
    }
    
    public static boolean validarnRealMg(String cadena)
    {
        if (cadena.equals(""))
            return false;
        
        String patron = "^[0-9]*\\.?[0-9]*$-";
        return validar(patron,cadena);
    }
    
    public static boolean validarFecha(String cadena)
    {
        if (cadena.equals(""))
            return true;
        
        String patron = "^[0-3][0-9]/[0-1][0-9]/[1-2][0-9][0-9][0-9]$";
        return validar(patron,cadena);
    }
    
    public static boolean validarHora(String cadena)
    {
        if (cadena.equals(""))
            return true;
        
        String patron = "^[0-2][0-9][':'][0-5][0-9]$";
        return validar(patron,cadena);
    }
        
    public static boolean validarNombre(String cadena)
    {
        if (cadena.equals(""))
            return false;
        
        String patron = "^[A-Za-z][A-Za-z0-9]*$";
        return validar(patron,cadena);        
    }
        
    public static boolean validarRazonSocial(String cadena)
    {
        if (cadena.equals(""))
            return true;
        
        String patron = "^[A-Za-z0-9]*$";
        return validar(patron,cadena);        
    }
    
    private static boolean validar(String patron, String cadena)
    {
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(cadena);
        return matcher.matches(); 
    }
    
    public static boolean validarPlaca(String cadena, int tipo){
        if (cadena.equals(""))
            return false;
        String patron;
        if (tipo == 1){
                patron = "^([A-Z]{3}-\\d{3})$";
        }
            //            patron = "^[A-Za-z][A-Za-z][A-Za-z]-[0-9][0-9][0-9]$";}
        else {
                patron = "^([A-Z]{2}-\\d{3})$";
        }
            //            patron = "^[A-Za-z][A-Za-z]-[0-9][0-9][0-9]$";}
        return validar(patron,cadena);
    }
}
