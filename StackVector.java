/***************************************
 * @author Oscar Fernando López Barrios
 * Carné 20679
 * Algoritmos y Estructuras de Datos
 * 
 * Clase: StackVector
 ***************************************/

import java.util.EmptyStackException;
import java.util.Vector;

//Se crea la Clase StackVector
public class StackVector<E> implements Stack<E> {

    //Se crean las propiedades
    private Vector<E> data;

    //Se crea el metodo constructor
    public StackVector(){

        data = new Vector<E>();

    }

    
    /** 
     * Pre: Se ingresa el dato
     * @param item se ingresa un dato para agregar al Vector
     * Post: Se guarda el dato en Stack
     */
    @Override
    public void push(E item) {
        
        data.add(item); //Se agrega el item al Stack
        
    }

    
    /** 
     * Pre: Estan todos los datos en el Stack
     * @return E se regresa un item.
     * Post: Se regresa y elimina un dato del Stack
     */
    @Override
    public E pop() {
        
        return data.remove(size() - 1); //Se regresa el ultimo item

    }

    
    /** 
     * Pre: Se encuentra el Stack con sus datos
     * @return E se regresa cualquier tipo de dato
     * @throws EmptyStackException regresa un error
     * Post: Se regresa el dato sobre la lista
     */
    @Override
    public E peek() throws EmptyStackException {
        
        if(data.isEmpty()){
            throw new EmptyStackException();
        }

        return data.elementAt(data.size() - 1); //Se regresa un item

    }

    @Override
    public E get(int i) {

        return data.get(i);

    }

    
    /** 
     * Pre:Se encuentra el Stack
     * @return boolean se regresa un valor True o False
     * Post: Si el Stack se encuentra vacio este regresa True
     */
    @Override
    public boolean empty() {
        
        return data.isEmpty(); //Se regresa un booleano

    }

    
    /** 
     * Pre:Se encuentra el Stack 
     * @return int se regrea cualquier numero
     * Post: Se devuelve el numero de objetos que tiene el Stack
     */
    @Override
    public int size() {
        
        return data.size(); //Se regresa el tamaño 

    }

}