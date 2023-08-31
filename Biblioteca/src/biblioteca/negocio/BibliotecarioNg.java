
package biblioteca.negocio;

import biblioteca.entidades.BibliotecarioEn;
import biblioteca.persistencia.BibliotecarioDAO;
import java.util.Iterator;
import java.util.List;


public class BibliotecarioNg {
     BibliotecarioDAO biblioDAO=new BibliotecarioDAO();
    public List<BibliotecarioEn> FindRegisters(String id){
        return biblioDAO.findRegisters(id);
    }
    
    public boolean ValidarUC(Iterator i,List<BibliotecarioEn> l,String u,String c){ 
       return biblioDAO.ValidarUC(i, l, u, c);
   }
}
