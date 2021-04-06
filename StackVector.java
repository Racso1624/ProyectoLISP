/***************************************
 * @author 
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

        return data.get(i);//Se regresa el valor de la posicion requerida

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

    @Override
    public void clear() {
        data.clear();//Se limpia el stack
    }

    @Override
    public void remove(int i) {
        data.remove(i);//Se remueve la posicion deseada
    }

    @Override
    public void removeFirst() {
        data.remove(0);//Se remueve el primer elemento
    }

    public boolean isInStack(String value){
        for(int i = 0; i < data.size(); i++){
            if(data.get(i).equals(value)){
                return true;//Se verifica que el valor requerido se encuentre dentro del stack
            }
        }

        return false;//Si no, se regresa false
    }

    public int indexOf(String value){
        for(int i = 0; i < data.size(); i++){
            if(data.get(i).equals(value)){
                return i;//Regresa el index del valor requerido en el stack
            }
        }

        return -1;//Si no se regresa el -1
    }
}