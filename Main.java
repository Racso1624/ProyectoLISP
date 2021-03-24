import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Interprete interprete = new Interprete();
        Scanner scanner = new Scanner(System.in);
              
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

            interprete.Interpretar(codigo);

        }

    }

}
