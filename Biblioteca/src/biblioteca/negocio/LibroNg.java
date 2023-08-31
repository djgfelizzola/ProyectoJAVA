
package biblioteca.negocio;

import biblioteca.entidades.LibroEn;
import biblioteca.persistencia.LibroDAO;
import java.util.Iterator;
import java.util.List;

public class LibroNg {
    LibroDAO libroDAO=new LibroDAO();
    
 public List<LibroEn> FindRegisters(String id){
        return libroDAO.findRegisters(id);
    }
 
  public List<LibroEn> CargarRegistros(String titulo,String autor,int j){
        return libroDAO.CargarRegistro(titulo,autor,j);
    }
  
  public String NombreLibro(Iterator i,List<LibroEn> listaLibros){
      return libroDAO.NombreLibro(i, listaLibros);
  }
  
  public boolean LibroDisponible(List<LibroEn> listaLibros,String id){
      return libroDAO.LibroDisponible(listaLibros,id);
  }
  
 public void ModificarEstadoLibro(String codigolibro,String estadoNew){
     libroDAO.ModificarEstadoLibro(codigolibro, estadoNew);
 }
}
