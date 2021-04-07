/***************************************
 * @author Oscar Fernando Lopez Barrios, Javier Mombiela y José Rodrigo Barrera García
 * Universidad del Valle de Guatemala
 * 
 * Clase Aritmeticas, funciona para poder
 * recibir operaciones prefix y sacar el
 * resultado.
 ***************************************/

public class Aritmeticas {

    /** 
     * Constructor
     */
    public Aritmeticas() { //agregando constructor
    }


    /** 
     * Pre: Se ingresa la expresion
     * @param expresion se ingresa una expresion para poder operarla
     * Post: retorna el valor de la expresion
     */
    public String Calculadora1(String expresion) {
    
        
         //creando la intancia de nuestra clase pilaArraylist<E>
         StackVector<Double> pila = new StackVector<Double>();
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
                 pila.push(Double.parseDouble(aString));         
             }
             catch (Exception e)  //separando los elementos que no son numeros
             { 
                double num1 = 0;
                double num2 = 0;
                //ya que hay una excecpcion, significa que tenemos un operador, por lo que tenemos que popear los dos numeros anteriores
                try {
                        num1 = pila.pop();
                        num2 = pila.pop();
                } catch (Exception exception) {
                        return "ERROR, Operacion Invalida";
                }

                if(aString.equals("+")) {//viendo si el operador es suma

                    double suma = num1 + num2; //realizando la suma
                    pila.push(suma); //pusheando el resultado a la pila
               
                } if(aString.equals("*")) {//viendo si el operador es multiplicacion
        
                    double multip = num1 * num2; //realizando la suma
                    pila.push(multip); //pusheando el resultado a la pila

                } if(aString.equals("-")) {//viendo si el operador es resta
        
                    double resta = num1 - num2; //realizando la suma
                    pila.push(resta); //pusheando el resultado a la pila

                } if(aString.equals("/")) {//viendo si el operador es division
        
                    double divis = num1 / num2; //realizando la suma
                    pila.push(divis); //pusheando el resultado a la pila

                }
                else{
                    return "ERROR, Operacion Invalida";
                }


             }  
        }

         //guardadno el peek como int asi tenemos el resultado final guardado
         double peek = pila.peek();
         //haciendo que el resultado se vuelva string y asi poder retornarlo
         resultado = Double.toString(peek);
 
         //se finalizan las operaciones pero el resultado esta hasta arriba de la pila
         //se hace un peek para poder obtener dicho resultado
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
        StackVector<Double> pila = new StackVector<Double>();
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
                pila.push(Double.parseDouble(aString));
            }
            catch (Exception e)  //separando los elementos que no son numeros
            { 
                double num1 = 0;
                double num2 = 0;
               //ya que hay una excecpcion, significa que tenemos un operador, por lo que tenemos que popear los dos numeros anteriores
                try {
                    num1 = pila.pop();
                    num2 = pila.pop();
                } catch (Exception exception) {
                    return "ERROR, Operacion Invalida";
                }
            

               if(aString.equals("+")) {//viendo si el operador es suma

                   double suma = num1 + num2; //realizando la suma
                   pila.push(suma); //pusheando el resultado a la pila

               } if(aString.equals("*")) {//viendo si el operador es multiplicacion
       
                   double multip = num1 * num2; //realizando la suma
                   pila.push(multip); //pusheando el resultado a la pila

               } if(aString.equals("-")) {//viendo si el operador es resta
       
                   double resta = num1 - num2; //realizando la suma
                   pila.push(resta); //pusheando el resultado a la pila
 
               } if(aString.equals("/")) {//viendo si el operador es division
       
                   double divis = num1 / num2; //realizando la suma
                   pila.push(divis); //pusheando el resultado a la pila
               } 
            }  
       }

        //guardadno el peek como int asi tenemos el resultado final guardado
        double peek = pila.peek();
        //haciendo que el resultado se vuelva string y asi poder retornarlo
        resultado = Double.toString(peek);

        //se finalizan las operaciones pero el resultado esta hasta arriba de la pila
        //se hace un peek para poder obtener dicho resultado
        //retornando el resultado
        return resultado;


   }
    
}