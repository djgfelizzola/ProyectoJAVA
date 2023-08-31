
package biblioteca.entidades;

public class EstudianteEn {

    private String nombre;
    private String carnet;
    private String estado;
    private String facultad;
    private String programa;
    private String usuario;
    private String contraseña;

    public EstudianteEn(String nombre, String carnet, String estado, String facultad, String programa, String usuario, String contraseña) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.estado = estado;
        this.facultad = facultad;
        this.programa = programa;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public EstudianteEn() {
   
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
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
