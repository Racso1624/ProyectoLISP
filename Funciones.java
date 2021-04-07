/***************************************
 * @author Oscar Fernando Lopez Barrios, Javier Mombiela y José Rodrigo Barrera García
 * Universidad del Valle de Guatemala
 * 
 * Clase Funciones, encargada de guardar
 * y manejar los datos de las 
 * funciones que el usuario define.
 ***************************************/
//Clase de Funciones
public class Funciones {
    //Propiedades de la clase Funciones
    private String nombre;
    private String parametro;
    private String codigo;
    private String codigoCompleto;

    /** 
     * Constructor
     */
    //Metodo constructor que le da valor a las variables
    public Funciones(String nombre, String parametro, String codigo, String codigoCompleto){
        this.nombre = nombre;
        this.parametro = parametro;
        this.codigo = codigo;
        this.codigoCompleto = codigoCompleto;
    }

    
    /** 
     * Pre: Se pide el nombre de la funcion
     * @return String es el nombre de la funcion
     * Post: Se regresa el nombre de la funcion
     */
    //Regresar el nombre
    public String getNombre() {
        return nombre;
    }

    
    /** 
     * Pre: Se pide el parametro de la funcion
     * @return String es el parametro de la funcion
     * Post: Se regresa el parametro de la funcion
     */
    //Regresar el parametro
    public String getParametro() {
        return parametro;
    }

    
    /** 
     * Pre: Se pide el codigo de la funcion
     * @return String es el codigo de la funcion
     * Post: Se regresa el codigo de la funcion
     */
    //Regresar el codigo de la funcion
    public String getCodigo() {
        return codigo;
    }

    
    /** 
     * Pre: Se pide el codigo completo de la funcion
     * @return String es el codigo completo de la funcion
     * Post: Se regresa el codigo completo de la funcion
     */
    //Regresar el codigo completo de la funcion
    public String getCodigoCompleto() {
        return codigoCompleto;
    }

    //Aclaracion: La diferencia entre codigo y codigo completo es que, el codigo es el que se desea correr con la definicion de la funcion
    //y el codigo completo, es el codigo con el que se define la funcion.
    //Ejemplo: 
    //-Codigo:(cond (< n 2) (n) (+ (fibonacci (- n 1)) (fibonacci (- n 2))))
    //-Codigo Completo:(defun fibonacci (n) (cond (< n 2) (n) (+ (fibonacci (- n 1)) (fibonacci (- n 2)))))
}
