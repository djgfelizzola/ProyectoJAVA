package biblioteca.negocio;

import biblioteca.entidades.PrestamoEn;
import biblioteca.persistencia.PrestamoDAO;

public class PrestamoNg {
    PrestamoDAO prestamoDAO=new PrestamoDAO();
    
    public boolean GuardarPrestamos(PrestamoEn r){
        return  prestamoDAO.GuardarPrestamo(r);
    }
    
    
}
