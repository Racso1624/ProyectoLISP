public class Funciones {
    
    private String nombre;
    private String parametro;
    private String codigo;
    private String codigoCompleto;

    public Funciones(String nombre, String parametro, String codigo, String codigoCompleto){
        this.nombre = nombre;
        this.parametro = parametro;
        this.codigo = codigo;
        this.codigoCompleto = codigoCompleto;
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

    public String getCodigoCompleto() {
        return codigoCompleto;
    }

}
