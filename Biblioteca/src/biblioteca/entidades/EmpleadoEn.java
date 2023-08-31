
package biblioteca.entidades;

public class EmpleadoEn {
    private String nombre;
    private String cedula;
    private String estado;
    private String usuario;
    private String contraseña;

  public EmpleadoEn() {
    }

    public EmpleadoEn(String nombre, String cedula, String estado, String usuario, String contraseña) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.estado = estado;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
  
  
}
