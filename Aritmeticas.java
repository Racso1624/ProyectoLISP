/***************************************
 * @author 
 * 
 * Clase Aritmeticas, funciona para poder
 * recibir operaciones prefix y sacar el
 * resultado.
 ***************************************/

public class Aritmeticas {


    public Aritmeticas() { //agregando constructor

    }


    /** 
     * Pre: Se ingresa la expresion
     * @param expresion se ingresa una expresion para poder operarla
     * Post: retorna el valor de la expresion
     */
    public String Calculadora1(String expresion) {
    
        
         //creando la intancia de nuestra clase pilaArraylist<E>
         StackVector<Integer> pila = new StackVector<Integer>();
         String resultado = "";
    
         //eliminando los espacios del postfix y guardandola como una nueva varaible
        // String nuevoPrefix = expresion.replace(" ", "");
         //eliminando los parentesis
         String nuevoPrefix = expresion.replace("(", "");
         nuevoPrefix = nuevoPrefix.replace(")", "");

          //creando un for loop para poder iterar toda la string y verificar los elementos dentro de la misma
        for(int i = nuevoPrefix.length() -1; i >= 0; i--) {
            
            

            String aString = Character.toString(nuevoPrefix.charAt(i)); //convirtiendo el char a string

             //haciendo un try catch para poder ver si los elementos son integers o no
             try 
             { 
                 //si el elemento es un entero, se pushea a la pila
                 pila.push(Integer.parseInt(aString));
                 if(i==nuevoPrefix.length() -1) {
                    System.out.println(aString + "                Push Operando                                    " + aString);
                 } else {
                    System.out.println(aString + "                Push Operando                                    "  +  Character.toString(nuevoPrefix.charAt(i+1)) + "," + aString);
                 }
                 
             }
             catch (Exception e)  //separando los elementos que no son numeros
             { 

                //ya que hay una excecpcion, significa que tenemos un operador, por lo que tenemos que popear los dos numeros anteriores
                int num1 = pila.pop();
                int num2 = pila.pop();

                if(aString.equals("+")) {//viendo si el operador es suma

                    int suma = num1 + num2; //realizando la suma
                    pila.push(suma); //pusheando el resultado a la pila
                    System.out.println("+                Sumar: pop, pop y push del resultado             " + suma);
                   // resultado = Double.valueOf(suma);
        
        
                } if(aString.equals("*")) {//viendo si el operador es multiplicacion
        
                    int multip = num1 * num2; //realizando la suma
                    pila.push(multip); //pusheando el resultado a la pila
                    System.out.println("*                Multiplicarar: pop, pop y push del resultado     " + multip);
                   // resultado = Double.valueOf(multip);
        
        
                } if(aString.equals("-")) {//viendo si el operador es resta
        
                    int resta = num1 - num2; //realizando la suma
                    pila.push(resta); //pusheando el resultado a la pila
                    System.out.println("-                Restar: pop, pop y push del resultado           " + resta);
                    //resultado = Double.valueOf(resta);
        
        
                } if(aString.equals("/")) {//viendo si el operador es division
        
                    int divis = num1 / num2; //realizando la suma
                    pila.push(divis); //pusheando el resultado a la pila
                    System.out.println("/                Dividir: pop, pop y push del resultado          " + divis);
                    //resultado = Double.valueOf(divis);
        
        
                } 


             }  
        }

         //guardadno el peek como int asi tenemos el resultado final guardado
         int peek = pila.peek();
         //haciendo que el resultado se vuelva string y asi poder retornarlo
         resultado = Integer.toString(peek);
 
         //se finalizan las operaciones pero el resultado esta hasta arriba de la pila
         //se hace un peek para poder obtener dicho resultado
         System.out.println("\nResultado de (" + expresion + ") es: " + resultado + "\n");
 
         //retornando el resultado
         return resultado;

    }


    
    /** 
     * Pre: Se ingresa la expresion
     * @param expresion se ingresa una expresion para poder operarla
     * Post: retorna el valor de la expresion
     */
    public String Calculadora2(String expresion) {

        
        //creando la intancia de nuestra clase pilaArraylist<E>
        StackVector<Integer> pila = new StackVector<Integer>();
        String resultado = "";
   
        //eliminando los espacios del postfix y guardandola como una nueva varaible
       // String nuevoPrefix = expresion.replace(" ", "");
        //eliminando los parentesis
        String nuevoPrefix = expresion.replace("(", "");
        nuevoPrefix = nuevoPrefix.replace(")", "");

       //separando los elementos de la expresion y almacenando en un array
        String[] lista = nuevoPrefix.split(" ");

         //creando un for loop para poder iterar toda la string y verificar los elementos dentro de la misma
       for(int i = lista.length -1; i >= 0; i--) { 

           String aString = lista[i]; //convirtiendo cada elemento de la lista a String por separado

            //haciendo un try catch para poder ver si los elementos son integers o no
            try 
            { 
                //si el elemento es un entero, se pushea a la pila
                pila.push(Integer.parseInt(aString));
                if(i==nuevoPrefix.length() -1) {
                   System.out.println(aString + "                Push Operando                                    " + aString);
                } else {
                   System.out.println(aString + "                Push Operando                                    "  +  Character.toString(nuevoPrefix.charAt(i+1)) + "," + aString);
                }
                
            }
            catch (Exception e)  //separando los elementos que no son numeros
            { 

               //ya que hay una excecpcion, significa que tenemos un operador, por lo que tenemos que popear los dos numeros anteriores
               int num1 = pila.pop();
               int num2 = pila.pop();

               if(aString.equals("+")) {//viendo si el operador es suma

                   int suma = num1 + num2; //realizando la suma
                   pila.push(suma); //pusheando el resultado a la pila
                   System.out.println("+                Sumar: pop, pop y push del resultado             " + suma);
                  // resultado = Double.valueOf(suma);
       
       
               } if(aString.equals("*")) {//viendo si el operador es multiplicacion
       
                   int multip = num1 * num2; //realizando la suma
                   pila.push(multip); //pusheando el resultado a la pila
                   System.out.println("*                Multiplicarar: pop, pop y push del resultado     " + multip);
                  // resultado = Double.valueOf(multip);
       
       
               } if(aString.equals("-")) {//viendo si el operador es resta
       
                   int resta = num1 - num2; //realizando la suma
                   pila.push(resta); //pusheando el resultado a la pila
                   System.out.println("-                Restar: pop, pop y push del resultado           " + resta);
                   //resultado = Double.valueOf(resta);
       
       
               } if(aString.equals("/")) {//viendo si el operador es division
       
                   int divis = num1 / num2; //realizando la suma
                   pila.push(divis); //pusheando el resultado a la pila
                   System.out.println("/                Dividir: pop, pop y push del resultado          " + divis);
                   //resultado = Double.valueOf(divis);
       
       
               } 


            }  
       }

        //guardadno el peek como int asi tenemos el resultado final guardado
        int peek = pila.peek();
        //haciendo que el resultado se vuelva string y asi poder retornarlo
        resultado = Integer.toString(peek);

        //se finalizan las operaciones pero el resultado esta hasta arriba de la pila
        //se hace un peek para poder obtener dicho resultado
        System.out.println("\nResultado de (" + expresion + ") es: " + resultado + "\n");

        //retornando el resultado
        return resultado;


   }
    
}