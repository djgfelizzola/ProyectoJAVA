
package biblioteca.entidades;

public class ReservaEn {
    private String nombreLibro;
    private String codigoLibro;
    private String codigoCliente;
    private String fechaReserva;

    public ReservaEn(String nombreLibro, String codigoLibro, String codigoCliente, String fechaReserva) {
        this.nombreLibro = nombreLibro;
        this.codigoLibro = codigoLibro;
        this.codigoCliente = codigoCliente;
        this.fechaReserva = fechaReserva;
    }

    public ReservaEn() {
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
    
    
}
