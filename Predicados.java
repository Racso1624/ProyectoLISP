/**
 * @author barre
 *
 */
public class Predicados {
	
	// instruccion de ejemplo: ( equal 'a 'b )
	public static boolean equal(String instruccion) {
		String[] instruccionSplit = instruccion.split(" ");
		if (instruccionSplit[2].equals(instruccionSplit[3])) {
			System.out.println("true");
			return true;
		} else {
			System.out.println("false");
			return false;
		}
	}
	
	
	public static void List(String instruccion) {
		String SaltosInstruccion []= instruccion.split(" ");
	for (int i = 2; i < (SaltosInstruccion.length - 1); i++) {
        if (i < (SaltosInstruccion.length - 2)) {
             System.out.print(SaltosInstruccion[i] + ", ");
        } else {
            System.out.print(SaltosInstruccion[i]);
        }
    }

    System.out.print(" )");
	}
	
	public static String MenorQue(String instruccion) {
		String SaltosInstruccion []=instruccion.split(" ");
		try {

            final int PrimerNumero = Integer.parseInt(SaltosInstruccion[2]);
            final int SegundoNumero = Integer.parseInt(SaltosInstruccion[3]);
            String ResultadoDelPrint = "";
            if(PrimerNumero<SegundoNumero) {
            	
            	ResultadoDelPrint="true";
            }
            
            else {
            	
            	ResultadoDelPrint="false";
            }
            return ResultadoDelPrint;

        } catch (NumberFormatException exception) {

            return "ERROR: Sintaxis incorrecta de la funcion \"<\"";
        }

		
	}
	
	public static String MayorQue(String instruccion) {
		
		String SaltosInstruccion []=instruccion.split(" ");
		try {

            final int PrimerNumero = Integer.parseInt(SaltosInstruccion[2]);
            final int SegundoNumero = Integer.parseInt(SaltosInstruccion[3]);
            String ResultadoDelPrint = "";
            if(PrimerNumero>SegundoNumero) {
            	
            	ResultadoDelPrint="true";
            }
            
            else {
            	
            	ResultadoDelPrint="false";
            }
            return ResultadoDelPrint;

        } catch (NumberFormatException exception) {

            return "ERROR: Sintaxis incorrecta de la funcion \">\"";
        }
		
		
	}
	
	
	
	
	
}