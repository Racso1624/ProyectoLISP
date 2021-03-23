/**
 * 
 */

/**
 * @author barre
 *
 */
public class Equal {

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
}