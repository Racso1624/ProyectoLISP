/***************************************
 * @author Oscar Fernando Lopez Barrios, Javier Mombiela y José Rodrigo Barrera García
 * Universidad del Valle de Guatemala
 * 
 * Interfaz Stack, encargada de definir 
 * metodos para los stacks
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

    /** 
     * Pre: Se ingresa la posicion del stack
     * @param i es la posicion del stack
     * @return E es el objecto que se regresa
     * Post: Se regresa el objeto en esa posicion
     */
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

    /** 
     * Pre:Se encuentra el Stack con objetos
     * Post: Se limpia el stack
     */
    public void clear();

    /** 
     * Pre: Se encuentra el stack con objetos
     * @param i es la posicion a remover
     * Post: Se remueve la posicion designada del stack
     */
    public void remove(int i);

    /** 
     * Pre: Se encuentra el stack con objetos
     * Post: Se remueve la posicion 0 del stack
     */
    public void removeFirst();

}