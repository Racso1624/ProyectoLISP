/**
 * Interprete
 */
public class Interprete {

    //Stacks
    StackVector<String> stackVector = new StackVector<String>();//Vector del codigo principal
    StackVector<String> stackRecursivo = new StackVector<String>();//Vector que guarda resultado de recursividad
    StackVector<String> codigoRecursivo = new StackVector<String>();//Vector que guarda codigo recursivo
    //Instancias de las clases
    Aritmeticas aritmeticas = new Aritmeticas();
    Setq setq = new Setq();
    Quote quote = new Quote();
    PredicadosOperaciones predicados = new PredicadosOperaciones();
    StackArraylist<Funciones> stackArraylist = new StackArraylist<Funciones>();

    //Constructor
    public Interprete(){}

    //Metodo principal del Interprete
    public void Interpretar(String codigo){

        verificarSintaxis(codigo);//Se verifica el codigo y pasa al Stack

        //Variables para poder hacer la recursividad
        String nombreFuncion = "";
        String valorFuncion = "";
        int cantidadCiclo = -2;
        int ciclo = -1;
        boolean recursivo = false;
        boolean condicional = true;

        //Ciclo
        boolean var = false;
        while(var == false){
            
            //Se ve el primer caracter para la funcion de Quote(')
            char[] characters = codigo.toCharArray();
            char character = characters[0];
            String clave2 = Character.toString(character);

            //Si es recursivo y la variable se encuentra verdadera
            if(recursivo && condicional == true){
                stackVector = codigoRecursivo;//El codigo de recursividad se coloca en el Stack Principal
            }
            
            if(recursivo == true && condicional == false){//Si es recursivo y es falso el condicional
                String parametro = regresarParametro(nombreFuncion);//Encontrar el nombre del parametro
                String valor = String.valueOf(ciclo);//Encontrar el valor del parametro por medio del ciclo
                stackVector = cambiarParametro(stackVector, parametro, valor);//Cambiar el parametro por el valor
                int variablecantidad = 0;//Cantidad de variables a cambiar
                StackVector<String> valores = new StackVector<String>();//Se inicia nuevo stack
                int posicionfuncion = -5;//Iniciar posicion
                //For para recorrer todos los elementos en el stack
                for(int i = 0; i < stackVector.size(); i++) {//Se itera en stack vector
                    String llave = stackVector.get(i);//Se toma el valor de i
                    //Ver si uno de los elementos ya es una llave y remplazar la llave por el valor
                    if(llave.equals(nombreFuncion)) {//Buscar funcion
                        valores.push(stackRecursivo.get(variablecantidad));//Sacar e ingresa el valor del stack recursivo
                        posicionfuncion = i;
                        variablecantidad++;
                    }
                    //Si es  lo siguiente al nombre de la funcion no ingresa al nuevo Stack
                    if(i != (posicionfuncion + 1) && i != (posicionfuncion + 2) && i != (posicionfuncion + 3) && i != posicionfuncion){
                        valores.push(llave);
                    } 
                    
                }
                stackVector = valores;//El nuevo Stack se convierte en el Stack principal
            }

            //Se toma el valor 0 para saber el tipo de operacion
            String clave = stackVector.get(0);
            System.out.println(clave);

            //(defun factorial (n) (cond (= n 0) (1) (* n (factorial (- n 1)))))

            //(defun fibonacci (n) (cond (< n 2) (n) (+ (fibonacci (- n 1)) (fibonacci (- n 2)))))
            
            //Si es aritmetico
            if(clave.equals("-") || clave.equals("+") || clave.equals("*") || clave.equals("/")){

                //Se busca si hay algun Setq y se intercambia
                stackVector = setq.buscarValor(stackVector);
                //Se forma la expresion que se encuentra en el Stack
                String expresion = "";
                for(int i = 0; i < stackVector.size(); i++){
                    expresion += stackVector.get(i);   
                    expresion += " ";
                }

                //Si tiene espacios se utiliza Calculadora 2
                if(expresion.contains(" ")) {
                    String resultado = aritmeticas.Calculadora2(expresion);
                    System.out.println(resultado);//Se regresa el resultado

                    if(recursivo){//Si es recursivo
                        stackRecursivo.removeFirst();//Se remueve el primer valor del Stack de los resultados de recursividad
                        stackRecursivo.push(resultado);//Se ingresa el resultado nuevo al Stack de recursividad
                        condicional = true;//La condicional se vuelve verdadera
                    }
                    var = true;//Se vuelve verdadera la variable del ciclo
                }
                //Si no tiene espacios se usa Calculadora 1 
                else {
                    String resultado = aritmeticas.Calculadora1(expresion);
                    System.out.println(resultado);

                    if(recursivo){//Si es recursivo
                        stackRecursivo.removeFirst();//Se remueve el primer valor del Stack de los resultados de recursividad
                        stackRecursivo.push(resultado);//Se ingresa el resultado nuevo al Stack de recursividad
                        condicional = true;//La condicional se vuelve verdadera
                    }
                    var = true;//Se vuelve verdadera la variable del ciclo
                }
            }
            //Si es un Setq
            else if(clave.equals("setq")){
                //Se agregan los valores al Hashmap de Setq
                setq.agregarValor(stackVector.get(1), stackVector.get(2));
                var = true;//Variable del ciclo verdadera
            }
            //Si es una definicion de funcion
            else if(clave.equals("defun")){
                //Se guarda el codigo completo de la funcion
                String codigoFuncion = codigo;
                //Se toma el codigo de la funcion
                String expresion = "";
                for(int i = 3; i < stackVector.size(); i++){
                    expresion += stackVector.get(i);
                    expresion += " ";   
                }
                //Se guardan todas las variables de la clase funciones
                Funciones nuevaFuncion = new Funciones(stackVector.get(1), stackVector.get(2), expresion, codigoFuncion);
                //Se guarda la instancia de la Funcion en el Stack
                stackArraylist.push(nuevaFuncion);
                //Variable se hace verdadera
                var = true;
            }
            //Si el primer caracter es (')
            else if(clave2.equals("'")){
                //Se convierte en caracteres
                char[] charac = codigo.toCharArray();
                //Se toma la expresion de caracteres
                String expresion = "";
                for (char c : charac) {
                    String caracter = Character.toString(c);
                    if(!caracter.equals("'")){
                        expresion += c;
                    }       
                }
                //Se usa el Quote
                quote.DevolverQuote(expresion);
                var = true;
            }
            //Si es un Quote
            else if(clave.equalsIgnoreCase("QUOTE")){
                //Se toma la expresion
                String expresion = "";
                String[] lineasplit = codigo.split(" ");
                for(int i = 0; i < lineasplit.length; i++){
                    if(!lineasplit[i].equalsIgnoreCase("QUOTE")){
                        expresion += lineasplit[i];
                        expresion += " ";
                    }
                }
                //Se usa el Quote
                quote.DevolverQuote(expresion);
                var = true;
            }
            //Si es condicional
            else if(clave.equals("cond")){
                //Si es recursivo
                if(recursivo){
                    String parametro = regresarParametro(nombreFuncion);//Se revisa el parametro
                    stackVector = cambiarParametro(stackVector, parametro, String.valueOf(ciclo));//Se cambia por el ciclo
                }
                //Se toma la expresion condicional
                String expresion = "";
                for(int i = 1; i <= 3; i++){
                    expresion += stackVector.get(i);
                    expresion += " ";   
                }
                //Se hace la comparacion
                String respuesta = predicados.ProcesoMetodos(expresion);

                if(stackVector.size() == 4){//verificar si no hay codigo que correr
                    System.out.println(respuesta);
                    var = true;
                }
                else{//Si hay, se corre el codigo
                    if(respuesta.equals("true")){//Si es verdadero
                        cambiarTrue(codigoFuncion(nombreFuncion));//Se cambia por el codigo de true
                        if(stackVector.size() == 1){//Si es solo una variable se hace la operacion
                            String respuestafinal = stackVector.get(0);//Se toma la variable
                            if(esNumero(respuestafinal)){//Se revisa si es un numero
                                if(recursivo){//Si es recursivo
                                    System.out.println(respuestafinal);//Se imprime
                                    stackRecursivo.push(respuestafinal);//Y se ingresa al Stack de recursividad
                                    var = true;
                                }
                                else{
                                    System.out.println("La respuesta es: " + respuestafinal);//Si no, solo se imprime la respuesta
                                    var = true;
                                }
                            }
                            else{//Si es una variable o letra
                                if(respuestafinal.equals(regresarParametro(nombreFuncion))){//Se verifica que sea un parametro
                                    if(recursivo){//Si es recursivo se cambia el valor, por el valor del ciclo
                                        System.out.println(ciclo);
                                        stackRecursivo.push(String.valueOf(ciclo));
                                        var = true;
                                    }
                                    else{//Si no, solo se imprime
                                        System.out.println("La respuesta es: " + valorFuncion);
                                        var = true;//La variable se hace verdadera
                                    }
                                }
                            }
                        }
                    }
                    else if(respuesta.equals("false")){//Si es falso
                        cambiarFalse(codigoFuncion(nombreFuncion));//Se cambia el codigo por el codigo de False
                        condicional = false;//Se vuelve la condicional falsa
                    }
                }
            }
            //Si es list
            else if(clave.equals("list")){
                //Se toma la expresion
                String expresion = "";
                for(int i = 0; i < stackVector.size(); i++){
                    expresion += stackVector.get(i);
                    expresion += " ";   
                }
                //Se usa el metodo del predicado
                String respuesta = predicados.ProcesoMetodos(expresion);
                System.out.println(respuesta);//Se imprime
                var = true;//La variable se hace verdadera
            }
            //Si es una funcion definida anteriormente
            else if(!verificarFuncion(clave).equals("null")){
                nombreFuncion = clave;//El nombre de la funcion se guarda
                String valor = stackVector.get(1);//Se toma el parametro
                valorFuncion = valor;//Se guarda el parametro
                String nuevocodigo = verificarFuncion(clave);//Se obtiene el codigo de la funciom
                stackVector.clear();//Se limpia el Stack
                verificarSintaxis(nuevocodigo);//Se ingresa el nuevo codigo al Stack
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

            if(recursivo && (cantidadCiclo != ciclo) && (cantidadCiclo != -2)){
                var = false;
            }

            if(recursivo && (cantidadCiclo != ciclo) && (cantidadCiclo != -2) && condicional == true){
                //sumar el ciclo del parametro
                ciclo++;
            }
        }
        stackVector.clear();
        stackRecursivo.clear();
        codigoRecursivo.clear();
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

    public String codigoFuncion(String nombrefuncion){

        for(int i = 0; i < stackArraylist.size(); i++){
            if(nombrefuncion.equals(stackArraylist.get(i).getNombre())){
                return stackArraylist.get(i).getCodigoCompleto();
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

    public boolean esNumero(String string) {        
        try {
            int valor = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
        
    }

    public void cambiarTrue(String lineacodigo){

        stackVector.clear();
        String nuevoCodigo = "";

        String nuevaLinea = lineacodigo.replace("(", "( ");
        nuevaLinea = nuevaLinea.replace(")", " )");

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

            if(contadorParentesisAbierto == 5 && contadorParentesisCerrado != 5 && (llave.equals("(") == false) && (llave.equals(")") == false)){
                nuevoCodigo += llave;
                nuevoCodigo += " ";
            }
        }

        verificarSintaxis(nuevoCodigo);
    }

    public void cambiarFalse(String lineacodigo){

        stackVector.clear();
        String nuevoCodigo = "";

        String nuevaLinea = lineacodigo.replace("(", "( ");
        nuevaLinea = nuevaLinea.replace(")", " )");

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

            if(contadorParentesisAbierto >= 6 &&contadorParentesisCerrado != 6 && (llave.equals("(") == false) && (llave.equals(")") == false)){
                nuevoCodigo += llave;
                nuevoCodigo += " ";
            }
        }
        
        verificarSintaxis(nuevoCodigo);
    }   

}