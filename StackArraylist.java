//importando clases externas
import java.util.ArrayList;

/**
 * @author 
 */

public class StackArraylist<E> implements Stack<E> {

    //creando arraylist
    protected ArrayList<E> data;


    /**
     * Metodo para crear un arraylist vacio
     * @param 
     */
    public StackArraylist() {

        //instanciando la arraylist
        data = new ArrayList<E>();

    }

   /**
     * Metodo para agregar un nuevo item al tope del stack
     * @param item
     */
    @Override
	public void push(E item)
	{
		data.add(item);
	}

    /**
     * Metodo para remover el item de hasta arriba
     * @param 
     * @return el elemento que saco del vector
     */
    @Override
	public E pop()
	{
		return data.remove(size()-1);
	}

    /**
     * Metodo para ver el elemento de hasta arriba
     * @param 
     * @return el elemento de hasta arriba de la lista
     */
    @Override
	public E peek()
	{
		return data.get(size() - 1);
	}
    
    /**
     * Metodo para ver el tamano del stack
     * @param 
     * @return un int con el numero de elementos en la lista
     */
    @Override
	public int size()
	// para ver el numero de elemetnos en la lista
	{
		return data.size();
	}
  
    /**
     * Metodo para ver si el stack esta vacio o no
     * @param 
     * @return se retorna true si stack esta vacia
     */
    @Override
	public boolean empty()
	
	{
		return size() == 0;
    }
    
}
