//Clase de Funciones
public class Funciones {
    //Propiedades de la clase Funciones
    private String nombre;
    private String parametro;
    private String codigo;
    private String codigoCompleto;

    //Metodo constructor que le da valor a las variables
    public Funciones(String nombre, String parametro, String codigo, String codigoCompleto){
        this.nombre = nombre;
        this.parametro = parametro;
        this.codigo = codigo;
        this.codigoCompleto = codigoCompleto;
    }

    //Regresar el nombre
    public String getNombre() {
        return nombre;
    }

    //Regresar el parametro
    public String getParametro() {
        return parametro;
    }

    //Regresar el codigo de la funcion
    public String getCodigo() {
        return codigo;
    }

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
