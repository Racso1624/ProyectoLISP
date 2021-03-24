/***************************************
 * @author 
 * 
 * Interface: Stack
 ***************************************/

//Se crea la interfaz de Stack
public interface Stack<E> {

    /** 
     * Pre: Se ingresa el dato
     * @param item se ingresa un dato para agregar al Vector
     * Post: Se guarda el dato en Stack
     */
    public void push(E data);

    /** 
     * Pre: Estan todos los datos en el Stack
     * @return E se regresa un item.
     * Post: Se regresa y elimina un dato del Stack
     */
    public E pop();

    /** 
     * Pre: Se encuentra el Stack con sus datos
     * @return E se regresa cualquier tipo de dato
     * @throws EmptyStackException regresa un error
     * Post: Se regresa el dato sobre la lista
     */
    public E peek();

    public E get(int i);

    /** 
     * Pre:Se encuentra el Stack
     * @return boolean se regresa un valor True o False
     * Post: Si el Stack se encuentra vacio este regresa True
     */
    public boolean empty();

    /** 
     * Pre:Se encuentra el Stack 
     * @return int se regrea cualquier numero
     * Post: Se devuelve el numero de objetos que tiene el Stack
     */
    public int size();

    public void clear();

}