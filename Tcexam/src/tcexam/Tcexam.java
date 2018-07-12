

package tcexam;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author javis
 */
public class Tcexam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cadena;
        Scanner cad=new Scanner(System.in);
        System.out.println("INTRODUCE LA CADENA A VALIDAR");
        cadena=cad.nextLine();
     Pattern pat = Pattern.compile("^NUTRA[0-9][0-9][0-9][0-9][0-9][0-9]$|^NUTRA-[0-9][0-9]-[0-9][0-9][0-9][0-9]$|^NUTRA#[0-9][0-9][0-9][0-9][0-9][0-9]$|^NUTRA#[0-9][0-9]-[0-9][0-9][0-9][0-9]$");
     Matcher mat = pat.matcher(cadena);
     if (mat.matches()) {
         System.out.println("SI ES VALIDA");
     } else {
         System.out.println("NO ES VALIDA");
     }
    }
    
}
