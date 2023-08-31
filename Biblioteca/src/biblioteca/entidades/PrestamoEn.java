
package biblioteca.entidades;

public class PrestamoEn {

  

    public PrestamoEn() {
    }
private String codigoLibro;
private String identificacion;
private String fechaInicio;
private String fechaFinal;

    public PrestamoEn(String codigoLibro, String identificacion, String fechaInicio, String fechaFinal) {
        this.codigoLibro = codigoLibro;
        this.identificacion = identificacion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }


    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }



   



}
