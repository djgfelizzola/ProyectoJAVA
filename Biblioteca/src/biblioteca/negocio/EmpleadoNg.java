
package biblioteca.negocio;

import biblioteca.entidades.EmpleadoEn;
import biblioteca.entidades.EstudianteEn;


import biblioteca.persistencia.EmpleadoDAO;
import java.util.Iterator;
import java.util.List;

public class EmpleadoNg {
    EmpleadoDAO empleadoDAO=new EmpleadoDAO();
    
    public List<EmpleadoEn> BuscarEmpleado(String id){
        return empleadoDAO.BuscarEmpleado(id);
    }
    
    public boolean ValidarDisponibilidadEmpleado(List<EmpleadoEn> listaEmpleados,String cedula){
      return   empleadoDAO.ValidarDisponibilidadEmpleado(listaEmpleados, cedula);
    }
    
     public List<EmpleadoEn> BuscarUsuarioLogin(String usuario){
        return empleadoDAO.BuscarUsuarioLogin(usuario);
    }  
    public boolean ValidarUCEmpleado (Iterator i,List<EmpleadoEn> l,String u,String c){
        return empleadoDAO.ValidarUCEmpleado(i, l, u, c);
    }
    
    public EmpleadoEn ObjetoEmpleado(String id){
    return empleadoDAO.ObjectoEmpleado(id);
}
public void EmpleadoLogin(EmpleadoEn e){
        empleadoDAO.GuardarLoginActual(e);
}
}
