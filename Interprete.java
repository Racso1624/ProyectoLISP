/**
 * Interprete
 */
public class Interprete {

    StackVector<String> stackVector = new StackVector<String>();
    Aritmeticas aritmeticas = new Aritmeticas();
    Setq setq = new Setq();
    StackArraylist<Funciones> stackArraylist = new StackArraylist<Funciones>();

    public Interprete(){}

    public void Interpretar(String codigo){

        verificarSintaxis(codigo);

        String clave = stackVector.get(0);
        System.out.println(clave);

        if(clave.equals("-") || clave.equals("+") || clave.equals("*") || clave.equals("/")){

            stackVector = setq.buscarValor(stackVector);
            String expresion = "";
            for(int i = 0; i < stackVector.size(); i++){
                expresion += stackVector.get(i);   
                expresion += " ";
            }

            System.out.println(expresion);

            if(expresion.contains(" ")) {
                System.out.println(aritmeticas.Calculadora2(expresion));
            } else {
                System.out.println(aritmeticas.Calculadora1(expresion));
            }

        }
        else if(clave.equals("setq")){
            System.out.println(stackVector.get(1));
            System.out.println(stackVector.get(2));
            setq.agregarValor(stackVector.get(1), stackVector.get(2));
        }
        else if(clave.equals("defun")){
            String expresion = "";
            for(int i = 3; i < stackVector.size(); i++){
                expresion += stackVector.get(i);   
            }
            Funciones nuevaFuncion = new Funciones(stackVector.get(1), stackVector.get(2), expresion);
            stackArraylist.push(nuevaFuncion);
        }
        else if(!verificarFuncion(clave).equals("null")){
            
        }
        else{
            System.out.println("Codigo incorrecto, operaciones no validas");
        }

        stackVector.clear();

    }
    
    public void verificarSintaxis(String linea){

        String nuevaLinea = linea.replace("(", "");
        nuevaLinea = nuevaLinea.replace(")", "");

        System.out.println(nuevaLinea);

        String[] lineasplit = nuevaLinea.split(" ");

        for(int i = 0; i < lineasplit.length; i++){
            stackVector.push(lineasplit[i]);
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

    public String verificarFuncion(String nombrefuncion){

        for(int i = 0; i < stackArraylist.size(); i++){
            if(nombrefuncion.equals(stackArraylist.get(i).getNombre())){
                return stackArraylist.get(i).getCodigo();
            }
        }

        return "null";
    }

}