import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

/**********************************************
 * @author Oscar Fernando Lopez Barrios, Javier Mombiela y José Rodrigo Barrera García
 * Universidad del Valle de Guatemala
 * 
 * PruebasJUnits
 **********************************************/

//Clase Pruebas Unitarias
public class PruebasJUnits {
    //Instancias de las clases
    Interprete interprete = new Interprete();
    Aritmeticas aritmeticas = new Aritmeticas();
    Setq Setq = new Setq();

    //Se hace el Test de la recursividad
    @Test
    public void pruebaFactorial(){
        String expresion = "(defun factorial (n) (cond (= n 0) (1) (* n (factorial (- n 1)))))";
        interprete.Interpretar(expresion);
        String expresion2 = "(factorial 5)";
        String resultado = interprete.Interpretar(expresion2);
        assertEquals("120.0", resultado);
    }

    //Se hace un Test a la calculadora
    @Test
    public void pruebaAritmetica(){
        String expresion2 = "(+ 2 3)";
        String resultado = interprete.Interpretar(expresion2);
        assertEquals("5.0", resultado);
    }

    //Se hace un test al Arraylist de las funciones
    @Test
    public void pruebaFuncionGuardada(){
        String resultado = interprete.verificarFuncion("factorial");
        assertEquals("null", resultado);
    }

    //Se hace un test al Arraylist de las funciones
    @Test
    public void pruebaParametroFuncion(){
        String expresion = "(defun factorial (n) (cond (= n 0) (1) (* n (factorial (- n 1)))))";
        interprete.Interpretar(expresion);
        String resultado = interprete.regresarParametro("factorial");
        assertEquals("n", resultado);
    }

    //Se hace un test a Setq, que incluye HashMap
    @Test
    public void pruebaSetq(){
        String expresion = "(setq var 10)";
        interprete.Interpretar(expresion);
        String resultado = interprete.Interpretar("var");
        assertEquals("10 ", resultado);
    }

    //Se prueban las condicionales
    @Test
    public void pruebaCondicional(){
        String expresion = "(cond (< 5 10))";
        String resultado = interprete.Interpretar(expresion);
        assertEquals("true", resultado);
    }

    //Se prueba QUOTE
    @Test
    public void pruebaQuote(){
        String expresion = "(Quote hola)";
        String resultado = interprete.Interpretar(expresion);
        assertEquals("hola ", resultado);
    }

}
