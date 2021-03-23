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


        //if para ver si la llave ya esta en la lista o no y asi poder remplazar el valor
        if(mapaLisp.containsKey(llave)) {

            //eliminando el valor que ya tenemos
            mapaLisp.remove(llave);

            //remplazando el nuevo valor
            mapaLisp.put(llave, valor);


        } else{

            //agregando el valor y su llave al mapa
            mapaLisp.put(llave, valor);

        }


    }


    /** 
     * Pre: Se ingresa la llave
     * @param llave es el nombre de la llave para poder buscar el valor
     * Post: retorna el valor de la llave dada
     */
    public String buscarValor(String llave) {

        //agarrando el valor con la llave dada y retornandolo
        return mapaLisp.get(llave);

    }

    
}
