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
    HashMap<String, String> mapaLisp= new HashMap<String, String>();;


    /** 
     * Pre: Se ingresa el dato
     * @param item se ingresa un dato para agregar al Vector
     * Post: Se guarda el dato en Stack
     */
    public void agregarValor(String llave, String valor) {

        //agregando el valor y su llave al mapa
        mapaLisp.put(llave, valor);

    }


    /** 
     * Pre: Se ingresa el dato
     * @param item se ingresa un dato para agregar al Vector
     * Post: Se guarda el dato en Stack
     */
    public void buscarValor(String valor) {

    }



    /** 
     * Pre: Se ingresa el dato
     * @param item se ingresa un dato para agregar al Vector
     * Post: Se guarda el dato en Stack
     */
    public void cambiarValor(String valor) {

    }
    
}
