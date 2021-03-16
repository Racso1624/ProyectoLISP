//importando clases externas
import java.util.*; 
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Reader {

    public String lectorArchivo() {

        //creando una lista para el ejemplo
        ArrayList<String> miLista = new ArrayList<String>();
        String stringObtenida = null;

        //se utiliza un try catch para aseguranos que el archivo pueda ser leido correctamente 
        try{

            //creando variables
            File archivoTexto = new File("datos.txt"); //creando nuestro nuevo archivo

            Scanner scan = new Scanner(archivoTexto); //instanciando la clase scanner con el archivo

            while(scan.hasNextInt()) { //while para que se lean todas las lineas en el archivo
            //se puede quitar el while si solo se quiere leer la linea de hasta arriba

                stringObtenida = scan.nextLine(); //guardando los elementos (de cada linea) como variables
                //estos pueden ser cualquier tipo de dato (int, String, float)
                
                
                //se pueden hacer operaciones normales con cada numero del archivo
                
                //como imprimir
                System.out.println(stringObtenida); //imprimiendo los numeros
                // o agregar a una lista (si es que la hay)
                miLista.add(stringObtenida); 
                scan.close();

            }

            //se hace un catch por si el archivo no se puede leer
        } catch (FileNotFoundException errorArchivoNoEncontrado) {
            // Se le advierte al usuario que el archivo no es existente, se termina el programa.
            System.out.println("El archivo de texto datos.txt no ha sido encontrado.");
        }
        
        return stringObtenida;
       

    }
    
}
