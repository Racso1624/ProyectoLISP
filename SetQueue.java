//importando clases
import java.util.HashMap;


/***************************************
 * @author 
 * 
 * Clase SetQueue, funciona para poder 
 * agregar valores a un diccionario 
 * y tambien para verificar si un String
 * ya es una variable o no.
 ***************************************/
public class SetQueue {

    //creando el hashmap tipo String, String
    HashMap<String, String> mapaLisp= new HashMap<String, String>();


    /** 
     * Pre: Se ingresa la llave y el valor
     * @param llave es la llave del valor agragado
     * @param valor es el nombre del valor a agregar
     */
    public void agregarValor(String llave, String valor) {

        //agregando el valor y su llave al mapa
        mapaLisp.put(llave, valor);

    }


    /** 
     * Pre: Se ingresa la llave
     * @param llave es el nombre de la llave para poder buscar el valor
     * Post: retorna el valor de la llave dada
     */
    public String buscarValor(String llave) {

        //agarrando el valor con la llave dada
        return mapaLisp.get(llave);

    }

    
}
