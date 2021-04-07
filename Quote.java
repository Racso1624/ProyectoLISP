/***************************************
 * @author Oscar Fernando Lopez Barrios, Javier Mombiela y José Rodrigo Barrera García
 * Universidad del Valle de Guatemala
 * 
 * Clase Quote, funciona para imprimir
 * la instruccion del Quote
 ***************************************/

 //Clase Quote
class Quote{

	/** 
     * Constructor
     */
	public Quote(){}

	/**
	 * Pre: Se ingresa la instruccion
	 * @param Instruccion que se desea evaluar 
	 * @return La misma instruccion a utilizar en el interprete
	 * Post: Se imprime y se regresa la instruccion 
	 */
	//Metodo DevolverQuote
	public String DevolverQuote(String Instruccion){
		System.out.println(Instruccion);//Se imprime la instruccion
		return Instruccion;//Se devuelve
	}
}