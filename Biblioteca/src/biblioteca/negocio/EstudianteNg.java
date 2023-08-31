
package biblioteca.negocio;

import biblioteca.entidades.EstudianteEn;
import biblioteca.persistencia.EstudianteDAO;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;


public class EstudianteNg {
    
    EstudianteDAO estudianteDAO=new EstudianteDAO();
    public List<EstudianteEn> BuscarEstudiante(String Carnet){
        return estudianteDAO.BuscarEstudiante(Carnet);
    }
    
    
    public boolean ValidarExistenciaEstudiante(Iterator i,List<EstudianteEn> listaEstudiantes,String carnet){
        return estudianteDAO.ValidarExistenciaEstudiante(i, listaEstudiantes, carnet);
    } 
    
    public List<EstudianteEn> BuscarUsuarioLogin(String usuario){
        return estudianteDAO.BuscarUsuarioLogin(usuario);
    }  
    public boolean ValidarUCEstudiante(Iterator i,List<EstudianteEn> l,String u,String c){
        return estudianteDAO.ValidarUCEstudiante(i, l, u, c);
        
    }
public boolean ValidarDisponibilidadEstudiante(List<EstudianteEn> listaEstudiantes,String carnet){
        return estudianteDAO.ValidarDisponibilidadEstudiante(listaEstudiantes, carnet);
    } 
public EstudianteEn ObjetoEstudiante(String id){
    return estudianteDAO.ObjectoEstudiante(id);
}
public void EstudianteLogin(EstudianteEn e){
        estudianteDAO.GuardarLoginActual(e);
}
    
}
