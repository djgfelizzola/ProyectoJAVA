package biblioteca.entidades;

public class BibliotecarioEn {
 private String usuario;
 private String contraseña;

    public BibliotecarioEn(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "BibliotecarioEn{" + "usuario=" + usuario + ", contrase\u00f1a=" + contraseña + '}';
    }

    public BibliotecarioEn() {
        
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
