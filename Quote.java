class Quote{

	public Quote(){}

	/**
	 *
	 * @param Instruccion que no se desea evaluar 
	 * @return La misma instruccion a utilizar en el interprete
	 */
	public String DevolverQuote(String Instruccion){
		System.out.println(Instruccion);
		return Instruccion;
	}
}