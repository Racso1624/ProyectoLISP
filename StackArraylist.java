//importando clases externas
import java.util.ArrayList;

/***************************************
 * @author Oscar Fernando Lopez Barrios, Javier Mombiela y José Rodrigo Barrera García
 * Universidad del Valle de Guatemala
 * 
 * Clase StackArraylist, encargada de 
 * manejar las operaciones del
 * Arraylist para almacenar la 
 * informacion.
 ***************************************/

public class StackArraylist<E> implements Stack<E> {

    //creando arraylist
    protected ArrayList<E> data;

    /** 
     * Constructor
     */
    //Se crea el arraylist
    public StackArraylist() {

        //instanciando la arraylist
        data = new ArrayList<E>();

    }

   /**
    * Pre: Se encuentra el stack
     * Metodo para agregar un nuevo item al tope del stack
     * @param item es el objeto a pushear
     * Post: Se agrega un nuevo objeto al stack
     */
    @Override
	public void push(E item)
	{
		data.add(item);
	}

    /**
     * Pre: Se encuentra el stack
     * @return el elemento que saco del stack
     * Post: Se saca el ultimo elemento
     */
    @Override
	public E pop()
	{
		return data.remove(size()-1);
	}

    /**
     * Pre: Se encuentra el stack
     * @return el elemento que saco del stack
     * Post: Se saca el ultimo elemento
     */
    @Override
	public E peek()
	{
		return data.get(size() - 1);
	}
    
    /** 
     * Pre:Se encuentra el Stack 
     * @return int se regrea cualquier numero
     * Post: Se devuelve el numero de objetos que tiene el Stack
     */
    @Override
	public int size()
	// para ver el numero de elemetnos en la lista
	{
		return data.size();
	}
  
    /** 
     * Pre:Se encuentra el Stack
     * @return boolean se regresa un valor True o False
     * Post: Si el Stack se encuentra vacio este regresa True
     */
    @Override
	public boolean empty()
	
	{
		return size() == 0;
    }

    
    /** 
     * Pre: Se ingresa la posicion del stack
     * @param i es la posicion del stack
     * @return E es el objecto que se regresa
     * Post: Se regresa el objeto en esa posicion
     */
    @Override
    public E get(int i) {
        return data.get(i);//Se devuelve la posicion requerida
    }

    /** 
     * Pre:Se encuentra el Stack con objetos
     * Post: Se limpia el stack
     */
    @Override
    public void clear() {
        data.clear();//Se limpia el stack
    }

    /** 
     * Pre: Se encuentra el stack con objetos
     * @param i es la posicion a remover
     * Post: Se remueve la posicion designada del stack
     */
    @Override
    public void remove(int i) {
        data.remove(i);//Se remueve el elemento de la posicion requerida
    }

    /** 
     * Pre: Se encuentra el stack con objetos
     * Post: Se remueve la posicion 0 del stack
     */
    @Override
    public void removeFirst() {
        data.remove(0);//Se remueve el primer elemento
    }
    
}
