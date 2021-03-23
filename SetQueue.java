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

    public void agregarValor(String llave, String valor) {


        //agregando el valor y su llave al mapa
        mapaLisp.put(llave, valor);

    }
    
}
