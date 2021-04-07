//importando clases
import java.util.HashMap;
/***************************************
 * @author Oscar Fernando Lopez Barrios, Javier Mombiela y José Rodrigo Barrera García
 * Universidad del Valle de Guatemala
 * 
 * Clase SetQ, funciona para poder 
 * agregar valores a un diccionario 
 * y tambien para verificar si un String
 * ya es una variable o no.
 ***************************************/
public class Setq {

    //creando el hashmap tipo String, String
    HashMap<String, String> mapaLisp;

    /** 
    * Constructor
    */
    public Setq(){
        mapaLisp= new HashMap<String, String>();
    }

    /** 
     * Pre: Se ingresa la llave y el valor
     * @param llave es la llave del valor agragado
     * @param valor es el nombre del valor a agregar
     * Post: Se ingresan los valores al HashMap
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
     * Pre: Se ingresa el stack
     * @param stackVector es el stack principal
     * Post: Se retorna un nuevo stack
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

    /** 
     * Pre: Se ingresa la clave
     * @param clave es la clave que indica la operacion
     * Post: Se retorna un booleano
     */
    public boolean encontrarValor(String clave) {
        //Encontrar si la clave es una llave
        if(mapaLisp.containsKey(clave)) {
            return true;//se regresa verdadero
        } 
        //retornando 
        return false;
    }

}