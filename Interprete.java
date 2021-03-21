/**
 * Interprete
 */
public class Interprete {

    StackVector<String> stackVector = new StackVector<String>();

    public Interprete(){}

    public void Interpretar(){

        for(int i = 0; i < stackVector.size(); i++){
            String clave = stackVector.get(i);

            if(clave.equals("-") || clave.equals("+") || clave.equals("*") || clave.equals("/")){

                

            }

        }

        

    }

    public void verificarSintaxis(String linea){

        String[] lineasplit = linea.split(" ");

        for(int i = 0; i < lineasplit.length; i++){
            if(!lineasplit[i].equals("(") && !lineasplit[i].equals(")")){
                stackVector.push(lineasplit[i]);
            }
        }

    }

    public boolean verificarParentesis(String codigo){

        int contadora = 0;
        int contadorc = 0;

        for(int i = 0; i < codigo.length(); i++){
            if(codigo.charAt(i) == '('){
                contadora++;
            }
            else if(codigo.charAt(i) == ')'){
                contadorc++;
            }
        }

        if(contadora == contadorc){
            return true;
        }

        return false;

    }

}