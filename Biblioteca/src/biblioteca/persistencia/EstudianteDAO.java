
package biblioteca.persistencia;

import biblioteca.entidades.BibliotecarioEn;
import biblioteca.entidades.EstudianteEn;
import biblioteca.vista.ClientesV;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class EstudianteDAO {
     String ruta="src\\biblioteca\\persistencia\\Estudiantes.txt";
    
      public   List<EstudianteEn> BuscarEstudiante(String id) {
		// crea el flujo para leer desde el archivo
                
		File file = new File(ruta);
                List<EstudianteEn> resultado=new ArrayList<EstudianteEn>();
		Scanner scanner;
		try {
			//se pasa el flujo al objeto scanner
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				// el objeto scanner lee linea a linea desde el archivo
				String line = scanner.nextLine();
				Scanner delimitar = new Scanner(line);
				//se usa una expresión regular
				//que valida que antes o despues de una coma (,) exista cualquier cosa
				//parte la cadena recibida cada vez que encuentre una coma				
				delimitar.useDelimiter("\\s*,\\s*");
				EstudianteEn e= new EstudianteEn();
				e.setNombre(delimitar.next());
				e.setCarnet(delimitar.next());
				e.setEstado(delimitar.next());
                                e.setFacultad(delimitar.next());
                                e.setPrograma(delimitar.next());
                                e.setUsuario(delimitar.next());
                                e.setContraseña(delimitar.next());
				if(e.getCarnet().equals(id)){
                                resultado.add(e);
                                }
			}
			//se cierra el ojeto scanner
			scanner.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		return resultado;
	}
      
      
      
      
      public boolean ValidarExistenciaEstudiante(Iterator i,List<EstudianteEn> listaEstudiantes,String carnet){
        boolean estado=false;
        
        if(i.hasNext())
        {       
        EstudianteEn a=(EstudianteEn)i.next();
         if(a.getCarnet().equals(carnet))
         {
             JOptionPane.showMessageDialog(null , "Estudiante existe");
             estado=true;
              if(a.getEstado().equalsIgnoreCase("disponible")){
            JOptionPane.showMessageDialog(null , "Estudiante disponible para prestamo"); 
         }else{
                  estado=false;
             JOptionPane.showMessageDialog(null , "Estudiante encuentra "+ a.getEstado(),"Error",JOptionPane.ERROR_MESSAGE);      
              }
         }
        }
        
        return estado;
        }
     
      
            public boolean ValidarDisponibilidadEstudiante(List<EstudianteEn> listaEstudiantes,String carnet){
        boolean estado=false;
        Iterator<EstudianteEn> i = listaEstudiantes.iterator();
        if(i.hasNext()){       
        EstudianteEn a=(EstudianteEn)i.next();
         if(a.getCarnet().equals(carnet))
         {
         if(a.getEstado().equalsIgnoreCase("disponible")){
         estado=true;
         }
         }
                        }
        
        return estado;
        }
      
       public boolean ValidarUCEstudiante(Iterator i,List<EstudianteEn> l,String u,String c){
        boolean estado=false;
        if(i.hasNext())
        {       
            EstudianteEn e=(EstudianteEn)i.next();
         if(e.getUsuario().equals(u) && e.getContraseña().equals(c))
         {
             
             estado=true;
         }
        }
        return estado;
    }
     
      
       
       public   List<EstudianteEn> BuscarUsuarioLogin(String id) {
		// crea el flujo para leer desde el archivo
                
		File file = new File(ruta);
                List<EstudianteEn> resultado=new ArrayList<EstudianteEn>();
		Scanner scanner;
		try {
			//se pasa el flujo al objeto scanner
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				// el objeto scanner lee linea a linea desde el archivo
				String line = scanner.nextLine();
				Scanner delimitar = new Scanner(line);
				//se usa una expresión regular
				//que valida que antes o despues de una coma (,) exista cualquier cosa
				//parte la cadena recibida cada vez que encuentre una coma				
				delimitar.useDelimiter("\\s*,\\s*");
				EstudianteEn e= new EstudianteEn();
				e.setNombre(delimitar.next());
				e.setCarnet(delimitar.next());
				e.setEstado(delimitar.next());
                                e.setFacultad(delimitar.next());
                                e.setPrograma(delimitar.next());
                                e.setUsuario(delimitar.next());
                                e.setContraseña(delimitar.next());
				if(e.getUsuario().equals(id)){
                                resultado.add(e);
                                }
			}
			//se cierra el ojeto scanner
			scanner.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		return resultado;
	}
       
        //GUARDA LOGIN ACTUAL ESTUDIANTE
       String ruta2="src\\biblioteca\\persistencia\\LoginActual.txt";
       public void GuardarLoginActual(EstudianteEn e){
           FileWriter flwriter = null;
                    boolean result=false;
                    
                    try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 

            File file = new File(ruta2);

            flwriter = new FileWriter(ruta2, true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            bfwriter.write(e.getCarnet()+","+"1"+ "\n");
            bfwriter.close();
            

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {
                    flwriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
       }
        
       public EstudianteEn ObjectoEstudiante(String id) {
		// crea el flujo para leer desde el archivo
              EstudianteEn estudianteLogin=new EstudianteEn();
		File file = new File(ruta);
                List<EstudianteEn> resultado=new ArrayList<EstudianteEn>();
		Scanner scanner;
		try {
			//se pasa el flujo al objeto scanner
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				// el objeto scanner lee linea a linea desde el archivo
				String line = scanner.nextLine();
				Scanner delimitar = new Scanner(line);
				//se usa una expresión regular
				//que valida que antes o despues de una coma (,) exista cualquier cosa
				//parte la cadena recibida cada vez que encuentre una coma				
				delimitar.useDelimiter("\\s*,\\s*");
				EstudianteEn e= new EstudianteEn();
				e.setNombre(delimitar.next());
				e.setCarnet(delimitar.next());
				e.setEstado(delimitar.next());
                                e.setFacultad(delimitar.next());
                                e.setPrograma(delimitar.next());
                                e.setUsuario(delimitar.next());
                                e.setContraseña(delimitar.next());
				if(e.getUsuario().equals(id)){
                                    estudianteLogin=e;
                                }
			}
			//se cierra el ojeto scanner
			scanner.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		return estudianteLogin;
	}
        
      }
        

