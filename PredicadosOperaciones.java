/***************************************
 * @author Oscar Fernando Lopez Barrios, Javier Mombiela y José Rodrigo Barrera García
 * Universidad del Valle de Guatemala
 * 
 * Clase PredicadosOperaciones, funciona para 
 * comparar las expresiones con los
 * diferentes predicados.
 ***************************************/

public class PredicadosOperaciones {

    /** 
     * Constructor
     */
    public PredicadosOperaciones(){}

    /**
     * Pre: Se ingresa la instruccion
     * @param instrucc
     * @return el tipo de operacion segun el predicado
     * Post: Se regresa el valor del predicado
     */
    //Metodo ProcesosMetodos
    public String ProcesoMetodos(String instrucc){
    	
        String respuest="";
        
        //Condicional para poder establecer cuando se mando a llamar a cierto predicado
        boolean atom=false;
        boolean equal=false;
        boolean list=false;
        boolean mayorQue=false;
        boolean menorQue=false;
        
        //Realizamos la separacion por secciones de nuestro string y lo ponemos en una lista
        String[] SaltoInstruccion = instrucc.split(" ");
        String expsplit="";
        
        //Con esto volvemos a juntar nuestra operacion 
        expsplit=String.join(" ",SaltoInstruccion);
        
        /**
         * Metodo que solo toma el primer digito de la instruccion que ingreso el usuario
         */
        String letra=expsplit.substring(0,1);
        
        //If que serviran para comparar el primer caracter de nuestra operacion

        if(letra.equalsIgnoreCase("a")){
        	atom=true;
        	}
        if(letra.equalsIgnoreCase("e")){
        	equal=true;
        	}
        if(letra.equalsIgnoreCase("l")){
        	list=true;
        	}
        if(letra.equals(">")){
        	mayorQue=true;
        	}
        if(letra.equals("<")){
        	menorQue=true;
        	}
        if(letra.equals("=")){
            equal = true;
        }

        //Cuando la operacion es del tipo Atom
        if(atom==true){
            String[] SaltoEspacio=expsplit.split(" ");

            if(SaltoEspacio.length<=2){
                respuest="true";
            }
            else{
                respuest="false";
            }
        }

        //Cuando la operacion es del tipo Equal
        if(equal==true){
            String[] SaltoEspacio=expsplit.split(" ");
            if(SaltoEspacio.length<=2){
                System.out.println("No hay suficientes parametros");
            }
            else {
                if(SaltoEspacio[1].equals(SaltoEspacio[2])){
                    respuest="true";
                }
                else{
                    respuest="false";
                }
            }
        }

        //Cuando la operacion es del tipo list
        if(list==true){
            System.out.print("( ");

            for (int i = 1; i <= (SaltoInstruccion.length - 1); i++) {
                if (i < (SaltoInstruccion.length - 1)) {
                    System.out.print(SaltoInstruccion[i] + ", ");
                } else {
                    System.out.print(SaltoInstruccion[i]);
                }
            }

            System.out.print(" )");
        }

        //Cuando la operacion es mayor que
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
                        respuest = "true";
                    } else {
                        respuest = "false";
                    }
                }
                catch (Exception e){
                    System.out.println("No es un dato numerico");
                }
            }
        }

        //Cuando la operacion es menor que
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
                        respuest = "true";
                    } else {
                        respuest= "false";
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