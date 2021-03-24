public class Funciones {
    
    private String nombre;
    private String parametro;
    private String codigo;

    public Funciones(String nombre, String parametro, String codigo){
        this.nombre = nombre;
        this.parametro = parametro;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getParametro() {
        return parametro;
    }

    public String getCodigo() {
        return codigo;
    }

}
