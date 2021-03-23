//importando clases
import java.util.HashMap;
import java.util.*;


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
    public StackVector<String> buscarValor(StackVector<String> stackVector) {

        StackVector<String> valores = new StackVector<String>();
        String llave = "";

        //for para recorrer todos los elementos en el stack
        for(int i = 0; i< stackVector.size(); i++) {
           
            llave = stackVector.get(i);

            //ver si uno de los elementos ya es una llave y remplazar la llave por el valor
           if(mapaLisp.containsKey(llave)) {
               valores.push(mapaLisp.get(llave));
           } else{
               valores.push(llave);
           }
        }

        //retornando 
        return valores;

    }

    
}
