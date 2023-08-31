/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.negocio;

import biblioteca.entidades.ReservaEn;
import biblioteca.persistencia.ReservaDAO;
import java.util.List;

/**
 *
 * @author DIOMEDES GUERRA
 */
public class ReservaNg {
    ReservaDAO reservaDAO=new ReservaDAO();
    public boolean GuardarReserva(ReservaEn r){
        return reservaDAO.GuardarReserva(r);
    }
    
    public void EliminarReserva(String codigoLibro){
        reservaDAO.EliminarReserva(codigoLibro);
    }
    
    public List<ReservaEn> BuscarReserva(String codigoLibro){
        return reservaDAO.BuscarReserva(codigoLibro);
    }
    
    public boolean ValidarEliminacionReserva(String codigoLibro,String id){
        return  reservaDAO.ValidarEliminarReserva(codigoLibro, id);
    }
     public String[] RetornarId(){
         return reservaDAO.RetornarId();
     }
     
     public void EliminarLoginActul(){
         reservaDAO.EliminarLoginActual();
     }
     
    
}
