
package biblioteca.entidades;

public class LibroEn {
    private String nombreLibro;
    private String autor;
    private String codigoLibro;
   private String estadoLibro;

    public LibroEn(String nombreLibro, String autor, String codigoLibro, String estadoLibro) {
        this.nombreLibro = nombreLibro;
        this.autor = autor;
        this.codigoLibro = codigoLibro;
        this.estadoLibro = estadoLibro;
    }

    public LibroEn() {
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getEstadoLibro() {
        return estadoLibro;
    }

    public void setEstadoLibro(String estadoLibro) {
        this.estadoLibro = estadoLibro;
    }

   
}
