/**
 * Interprete
 */
public class Interprete {

    StackVector<String> stackVector = new StackVector<String>();
    StackVector<String> stackRecursivo = new StackVector<String>();
    StackVector<String> codigoRecursivo = new StackVector<String>();
    Aritmeticas aritmeticas = new Aritmeticas();
    Setq setq = new Setq();
    Quote quote = new Quote();
    PredicadosOperaciones predicados = new PredicadosOperaciones();
    StackArraylist<Funciones> stackArraylist = new StackArraylist<Funciones>();
    String codigoFuncion = "";

    public Interprete(){}

    public void Interpretar(String codigo){

        verificarSintaxis(codigo);
        String nombreFuncion = "";
        int cantidadCiclo = -1;
        int ciclo = 0;
        boolean recursivo = false;

        boolean var = false;
        while(var == false){
            
            String clave = stackVector.get(0);
            System.out.println(clave);

            char[] characters = codigo.toCharArray();
            char character = characters[0];
            String clave2 = Character.toString(character);

            if(ciclo == 1){
                int cantidadFunciones = cantidadFuncion(nombreFuncion);//inicializar el stack con la cantidad correcta
                System.out.println("cantidad " + cantidadFunciones);
                if(cantidadFunciones == 2){
                    for(int i = 0; i < cantidadFunciones; i++){//fibonacci
                        stackRecursivo.push(String.valueOf(i));
                    }
                }
                else{
                    stackRecursivo.push("1");//factorial
                }
            }
            
            if(nombreFuncion != "" && recursivo == true){//ver si es recursivo
                stackVector = codigoRecursivo;
                String parametro = regresarParametro(nombreFuncion);//Encontrar el nombre del parametro
                String valor = String.valueOf(ciclo);//Encontrar el valor del parametro
                stackVector = cambiarParametro(stackVector, parametro, valor);//Cambiar el parametro por el valor
                int variablecantidad = 0;//cantidad de variables a cambiar
                StackVector<String> valores = new StackVector<String>();//se inicia nuevo stack
                int posicionfuncion = -5;//iniciar posicion
                //for para recorrer todos los elementos en el stack
                for(int i = 0; i < stackVector.size(); i++) {//se itera en stack vector
                    String llave = stackVector.get(i);//se agarra el valor de i
                    //ver si uno de los elementos ya es una llave y remplazar la llave por el valor
                    if(llave.equals(nombreFuncion)) {//buscar funcion
                        valores.push(stackRecursivo.get(variablecantidad));//sacar se ingresa el valor del stack recursivo
                        String expresion3 = "";
                        for(int k = 0; k < stackVector.size(); k++){
                            expresion3 += stackVector.get(k);
                            expresion3 += " ";   
                        }
                        System.out.println("prro");
                        System.out.println(expresion3);
                        posicionfuncion = i;
                        variablecantidad++;
                    }

                    if(i != (posicionfuncion + 1) && i != (posicionfuncion + 2) && i != (posicionfuncion + 3) && i != posicionfuncion){
                        valores.push(llave);
                    } 
                    
                }
                stackVector = valores;
                String expresion4 = "";
                for(int j = 0; j < stackVector.size(); j++){
                    expresion4 += stackVector.get(j);
                    expresion4 += " ";   
                }
                System.out.println("Cantidad stack" + stackVector.size());
                System.out.println("Stack ya");
                System.out.println(expresion4);
            }


            //(defun factorial (n) (cond (= n 0) (1) (* n (factorial(- n 1 )))))
            //(defun factorial (n) (* n (factorial (- n 1))))
            //(* n (factorial (- n 1)))
            //(* n numeroanterior)
            //(fibonacci 5)

            //* n factorial - n 1
            //* 2 factorial - n 1
            //* 2 1

            //(defun fibonacci (n) (if (< n 2) n (+ (fibonacci (- n 1)) (fibonacci (- n 2)))))
            //(defun fibonacci (n) (+ (fibonacci (- n 1)) (fibonacci (- n 2))))

            
            
            if(clave.equals("-") || clave.equals("+") || clave.equals("*") || clave.equals("/")){

                stackVector = setq.buscarValor(stackVector);
                System.out.println("Cantidad stack" + stackVector.size());
                String expresion = "";
                for(int i = 0; i < stackVector.size(); i++){
                    expresion += stackVector.get(i);   
                    expresion += " ";
                }

                if(expresion.contains(" ")) {
                    String resultado = aritmeticas.Calculadora2(expresion);
                    System.out.println(resultado);

                    if(ciclo != 0){
                        stackRecursivo.removeFirst();
                        stackRecursivo.push(resultado);
                    }
                    System.out.println("Cantidad stack" + stackVector.size());
                    var = true;
                } else {
                    String resultado = aritmeticas.Calculadora1(expresion);
                    System.out.println(resultado);

                    if(ciclo != 0){
                        stackRecursivo.removeFirst();
                        stackRecursivo.push(resultado);
                    }
                    System.out.println("Cantidad stack" + stackVector.size());
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
                codigoFuncion = codigo;
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
            else if(clave.equalsIgnoreCase("QUOTE")){
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
            else if(clave.equals("cond")){
                String expresion = "";
                for(int i = 1; i <= 3; i++){
                    expresion += stackVector.get(i);
                    expresion += " ";   
                }
                String respuesta = predicados.ProcesoMetodos(expresion);
                cambiarTrue(codigoFuncion);
                //if(recursivo){
                    
                //}
                System.out.println(respuesta);
                var = true;
            }
            else if(clave.equals("list")){
                String expresion = "";
                for(int i = 0; i < stackVector.size(); i++){
                    expresion += stackVector.get(i);
                    expresion += " ";   
                }
                String respuesta = predicados.ProcesoMetodos(expresion);
                System.out.println(respuesta);
                var = true;
            }
            else if(!verificarFuncion(clave).equals("null")){
                nombreFuncion = clave;
                String valor = stackVector.get(1);
                String nuevocodigo = verificarFuncion(clave);
                stackVector.clear();
                verificarSintaxis(nuevocodigo);
                if(!stackVector.isInStack(nombreFuncion)){
                    String parametro = regresarParametro(clave);   
                    stackVector = cambiarParametro(stackVector, parametro, valor);
                }
                else{
                    recursivo = true;
                    codigoRecursivo = stackVector; 
                    cantidadCiclo = Integer.parseInt(valor);
                }            
            }
            else{
                System.out.println("Codigo incorrecto, operaciones no validas");
                var = true;
            }

            System.out.println("Cantidad stack" + stackVector.size());
            System.out.println(cantidadCiclo);

            if(nombreFuncion != "" && (cantidadCiclo != ciclo) && (cantidadCiclo != -1)){
                //sumar el ciclo del parametro
                ciclo++;
                var = false;
            }
            else if(cantidadCiclo == ciclo && ciclo != 0){
                //System.out.println("El resultado de la operacion es " + stackRecursivo.pop());
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

    public int cantidadFuncion(String nombrefuncion){

        int cantidad = 0;

        for(int i = 0; i < stackVector.size(); i++){
            if(nombrefuncion.equals(stackVector.get(i))){
                cantidad++;
            }
        }

        return cantidad;
    }

    public StackVector<Integer> posicionesFuncion(String nombrefuncion){

        StackVector<Integer> posiciones = new StackVector<Integer>();

        for(int i = 0; i < stackVector.size(); i++){
            if(nombrefuncion.equals(stackVector.get(i))){
                posiciones.push(i);
            }
        }

        return posiciones;
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

    public StackVector<String> cambiarCodigo(StackVector<String> stackVector, String funcion, String codigo) {

        StackVector<String> valores = new StackVector<String>();
        //for para recorrer todos los elementos en el stack
        for(int i = 0; i< stackVector.size(); i++) {
           
            String llave = stackVector.get(i);

            //ver si uno de los elementos ya es una llave y remplazar la llave por el valor
           if(llave.equals(funcion)) {
               valores.push(codigo);
           } else{
               valores.push(llave);
           }
        }
        //retornando 
        return valores;
    }

    public void cambiarTrue(String lineacodigo){

        String nuevoCodigo = "";

        String nuevaLinea = lineacodigo.replace("(", "( ");
        nuevaLinea = nuevaLinea.replace(")", " )");

        System.out.println(nuevaLinea);

        String[] lineasplit = nuevaLinea.split(" ");

        StackVector<String> nuevoVector = new StackVector<String>();

        for(int i = 0; i < lineasplit.length; i++){
            nuevoVector.push(lineasplit[i]);
        }

        int contadorParentesisAbierto = 0; 
        int contadorParentesisCerrado = 0; 

        for(int i = 0; i< nuevoVector.size(); i++) {
           
            String llave = nuevoVector.get(i);

            //ver si uno de los elementos ya es una llave y remplazar la llave por el valor
            if(llave.equals("(")) {
                contadorParentesisAbierto++;
            }
            else if(llave.equals(")")){
                contadorParentesisCerrado++;
            }

            if(contadorParentesisAbierto == 3 && contadorParentesisCerrado != 3 && (llave.equals("(") == false) && (llave.equals(")") == false)){
                nuevoCodigo += llave;
                nuevoCodigo += " ";
            }
        }

        System.out.println(nuevoCodigo);
    }

    public void cambiarFalse(String lineacodigo){
        String nuevoCodigo = "";

        String nuevaLinea = lineacodigo.replace("(", "( ");
        nuevaLinea = nuevaLinea.replace(")", " )");

        System.out.println(nuevaLinea);

        String[] lineasplit = nuevaLinea.split(" ");

        StackVector<String> nuevoVector = new StackVector<String>();

        for(int i = 0; i < lineasplit.length; i++){
            nuevoVector.push(lineasplit[i]);
        }

        int contadorParentesisAbierto = 0; 
        int contadorParentesisCerrado = 0; 

        for(int i = 0; i< nuevoVector.size(); i++) {
           
            String llave = nuevoVector.get(i);

            //ver si uno de los elementos ya es una llave y remplazar la llave por el valor
            if(llave.equals("(")) {
                contadorParentesisAbierto++;
            }
            else if(llave.equals(")")){
                contadorParentesisCerrado++;
            }

            if(contadorParentesisAbierto == 4 && contadorParentesisCerrado != 4 && (llave.equals("(") == false) && (llave.equals(")") == false)){
                nuevoCodigo += llave;
                nuevoCodigo += " ";
            }
        }    
    }   

}