import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Interprete interprete = new Interprete();
        Scanner scanner = new Scanner(System.in);
        Aritmeticas arit = new Aritmeticas();


        //estas 3 lineas son solo para probar la calculadora
        //"+ 9 * 12 6" probar calculadora2
        //"+9*26" probar con calculadora1
        //"(+ (* 78 4) 3)" con calcu2
        String expresion ="+9*26";

        if(expresion.contains(" ")) {
            arit.Calculadora2(expresion);
        } else {
            arit.Calculadora1(expresion);
        }
        

        System.out.println("Bienvenido al Interprete de Lisp");
        System.out.println("Ingrese el codigo de manera correcta para evitar errores y coloque los parentesis separados");

        boolean var  = false;
        while(var == false){

            String codigo = "";
            boolean verificador = false;
            System.out.print(">>>");

            while (verificador == false) {
                codigo += scanner.nextLine();

                verificador = interprete.verificarParentesis(codigo);
                if(!verificador){
                    codigo += " ";
                }

            }

            System.out.println(codigo);

        }

    }

}
