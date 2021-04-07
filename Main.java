import java.util.Scanner;

/***************************************
 * @author Oscar Fernando Lopez Barrios, Javier Mombiela y José Rodrigo Barrera García
 * Universidad del Valle de Guatemala
 * 
 * Clase Main, es la clase donde se
 * ingresan las expresiones de ccodigo
 * y donde se imprime el resultado.
 ***************************************/

//Clase Main
public class Main {
 
    //Funciones para probar el Interprete:
    //(defun factorial (n) (cond (= n 0) (1) (* n (factorial (- n 1)))))
    //(defun fibonacci (n) (cond (< n 2) (n) (+ (fibonacci (- n 1)) (fibonacci (- n 2)))))
    //(defun conversion (fahrenheit) (* (- fahrenheit 32) 0.55555))
    //(defun sumar (n) (+ n n))
    
    /** 
     * Pre: Se ingresa el codigo
     * @param args es el main
     * Post: Se interpreta
     */
    //Se hace el Main
    public static void main(String[] args) {
        //Iniciar las instancias
        Interprete interprete = new Interprete();
        Scanner scanner = new Scanner(System.in);
        //Mensaje de bienvenida    
        System.out.println("Bienvenido al Interprete de Lisp");
        System.out.println("Ingrese el codigo de manera correcta para evitar errores y coloque los parentesis separados");
        System.out.println("Si desea salir del Interprete ingrese el comando SALIR");
        //Ciclo para ingresar el codigo
        boolean var  = false;
        while(var == false){
            //Se inicia la variable del codigo y el verificador de parentesis
            String codigo = "";
            boolean verificador = false;
            System.out.print(">>>");
            //Mientras el verificador sea falso, se puede seguir ingresando codigo
            while (verificador == false) {
                codigo += scanner.nextLine();
                
                verificador = interprete.verificarParentesis(codigo);
                if(!verificador){
                    codigo += " ";
                }

            }
            //Se revisa que el comando de Salir se ha ingresado
            if(codigo.equalsIgnoreCase("SALIR")){
                var = true;
            }
            else{
                interprete.Interpretar(codigo);//Si no, el codigo se interpreta
            }

        }

    }

}
