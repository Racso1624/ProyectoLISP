import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author José Rodrigo Barrera García
 * Carnet:20807
 * Universidad del Valle de Guatemala
 *
 */
/***********************
 * 
 * Predicados
 * 
 * *************/
public class PredicadosOperaciones {
	//Establecemos un arraylist con los operadores reservados
    private final List<String> operadoresReservados = Arrays.asList("atom", "equal", "list", ">", "<");
    //Instancia de aritmeticas
    Aritmeticas operacionesAritmeticas = new Aritmeticas();
    /**
     * 
     * @param instrucc
     * @return el tipo de operacion segun el predicado
     */
    public String Process(String instrucc){
        Aritmeticas aritmetics = new Aritmeticas();
        String respuest="";
        
        //Condicional para poder establecer cuando se mando a llamar a cierto predicado
        boolean atom=false;
        boolean equal=false;
        boolean list=false;
        boolean mayorQue=false;
        boolean menorQue=false;

        String[] SaltoInstruccion = instrucc.split("\\(|\\)");
        String expsplit="";

        expsplit=String.join("",SaltoInstruccion);

        String letra=expsplit.substring(0,1);

        if(letra.equals("a")){atom=true;}
        if(letra.equals("e")){equal=true;}
        if(letra.equals("l")){list=true;}
        if(letra.equals(">")){mayorQue=true;}
        if(letra.equals("<")){menorQue=true;}

        //Cuando la operación es del tipo Atom
        if(atom==true){
            String[] SaltoEspacio=expsplit.split(" ");

            if(SaltoEspacio.length<=2){
                respuest="t";
            }
            else{
                respuest="nil";
            }
        }

        //Cuando la operación es del tipo Equal
        if(equal==true){
            String[] SaltoEspacio=expsplit.split(" ");
            if(SaltoEspacio.length<=2){
                System.out.println("No hay suficientes parametros");
            }
            else {
                if(SaltoEspacio[1].equals(SaltoEspacio[2])){
                    respuest="t";
                }
                else{
                    respuest="nil";
                }
            }
        }

        //Cuando la operación es del tipo list
        if(list==true){
            String[] palabras=SaltoInstruccion[2].split(" ");
            if(palabras.length>1){
                respuest="t";
            }
            else{
                respuest="nil";
            }
        }

        //Cuando la operación es mayor que
        if(mayorQue==true){
            String[] SaltoEspacio=expsplit.split(" ");
            if(SaltoEspacio.length<=2){
                System.out.println("No hay suficientes parametros");
            }
            else {
                try{
                    int primerNumero = Integer.parseInt(SaltoEspacio[1]);
                    int segundoNumero = Integer.parseInt(SaltoEspacio[2]);

                    if (primerNumero > segundoNumero) {
                        respuest = "t";
                    } else {
                        respuest = "nil";
                    }
                }
                catch (Exception e){
                    System.out.println("No es un dato numerico");
                }
            }
        }

        //Cuando la operación es menor que
        if(menorQue==true){
            String[] SaltoEspacio=expsplit.split(" ");
            if(SaltoEspacio.length<=2){
                System.out.println("No es un dato numerico");
            }
            else {
                try{
                    int primerNumero = Integer.parseInt(SaltoEspacio[1]);
                    int segundoNumero = Integer.parseInt(SaltoEspacio[2]);

                    if (primerNumero < segundoNumero) {
                        respuest = "t";
                    } else {
                        respuest= "nil";
                    }
                }
                catch (Exception e){
                    System.out.println("No es un dato numerico");
                }
            }
        }

        return respuest;
    }

}
