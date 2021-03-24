/**
 * Interprete
 */
public class Interprete {

    StackVector<String> stackVector = new StackVector<String>();
    Aritmeticas aritmeticas = new Aritmeticas();
    Setq setq = new Setq();
    Quote quote = new Quote();
    StackArraylist<Funciones> stackArraylist = new StackArraylist<Funciones>();

    public Interprete(){}

    public void Interpretar(String codigo){

        verificarSintaxis(codigo);

        boolean var = false;
        while(var == false){
            
            String clave = stackVector.get(0);
            System.out.println(clave);

            char[] characters = codigo.toCharArray();
            char character = characters[0];
            String clave2 = Character.toString(character);

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
                    var = true;
                } else {
                    System.out.println(aritmeticas.Calculadora1(expresion));
                    var = true;
                }
            }
            else if(clave.equals("setq")){
                System.out.println(stackVector.get(1));
                System.out.println(stackVector.get(2));
                setq.agregarValor(stackVector.get(1), stackVector.get(2));
                var = true;
            }
            else if(clave.equals("defun")){
                String expresion = "";
                for(int i = 3; i < stackVector.size(); i++){
                    expresion += stackVector.get(i);
                    expresion += " ";   
                }
                Funciones nuevaFuncion = new Funciones(stackVector.get(1), stackVector.get(2), expresion);
                stackArraylist.push(nuevaFuncion);
                var = true;
            }
            else if(clave2.equals("'")){
                char[] charac = codigo.toCharArray();
                String expresion = "";
                for (char c : charac) {
                    String caracter = Character.toString(c);
                    if(!caracter.equals("'")){
                        expresion += c;
                    }       
                }
                System.out.println(expresion);
                quote.DevolverQuote(expresion);
                var = true;
            }
            else if(clave.toUpperCase().equalsIgnoreCase("QUOTE")){
                String expresion = "";
                String[] lineasplit = codigo.split(" ");

                for(int i = 0; i < lineasplit.length; i++){
                    if(!lineasplit[i].equalsIgnoreCase("QUOTE")){
                        expresion += lineasplit[i];
                        expresion += " ";
                    }
                }
                quote.DevolverQuote(expresion);
                var = true;
            }
            else if(!verificarFuncion(clave).equals("null")){
                String valor = stackVector.get(1);
                String nuevocodigo = verificarFuncion(clave);
                stackVector.clear();
                verificarSintaxis(nuevocodigo);
                String parametro = regresarParametro(clave);
                stackVector = cambiarParametro(stackVector, parametro, valor);
            }
            else{
                System.out.println("Codigo incorrecto, operaciones no validas");
                var = true;
            }
        }
        stackVector.clear();
    }
    
    public void verificarSintaxis(String linea){

        String nuevaLinea = linea.replace("(", "");
        nuevaLinea = nuevaLinea.replace(")", "");

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

    public String regresarParametro(String nombrefuncion){

        for(int i = 0; i < stackArraylist.size(); i++){
            if(nombrefuncion.equals(stackArraylist.get(i).getNombre())){
                return stackArraylist.get(i).getParametro();
            }
        }

        return "null";
    }
    
    public StackVector<String> cambiarParametro(StackVector<String> stackVector, String parametro, String valor) {

        StackVector<String> valores = new StackVector<String>();

        //for para recorrer todos los elementos en el stack
        for(int i = 0; i< stackVector.size(); i++) {
           
            String llave = stackVector.get(i);

            //ver si uno de los elementos ya es una llave y remplazar la llave por el valor
           if(llave.equals(parametro)) {
               valores.push(valor);
           } else{
               valores.push(llave);
           }
        }

        //retornando 
        return valores;

    }

}