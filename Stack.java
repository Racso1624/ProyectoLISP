/**
 * @author 
 */

public interface Stack<E> 
{

    /**
     * Metodo push
     * @param item Parametro para ver que item se agrega a la fila
     */
   public void push(E item);
   
   
    /**
     * Metodo pop, para remover el item de arriba del stack
     * @param 
     */
   public E pop();
   
    /**
     * Metodo peek, para ver el item de arriba del stack
     * @param 
     */
   public E peek();
  
    /**
     * Metodo empty, para ver si el stack esta vacio o no
     * @param 
     */
   public boolean empty();
   
    /**
     * Metodo size, para ver el tamano del stack
     * @param 
     */
   public int size();
   

}