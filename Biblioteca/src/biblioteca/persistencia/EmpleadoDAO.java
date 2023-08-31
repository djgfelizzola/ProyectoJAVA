
package biblioteca.persistencia;

import biblioteca.entidades.EmpleadoEn;
import biblioteca.entidades.EstudianteEn;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class EmpleadoDAO {
    String ruta="src\\biblioteca\\persistencia\\Empleados.txt";
    //BUSCA UN EMPLEADO POR LA CEDULA Y RETORNA LA LISTA CON EL EMPLEADO
          public   List<EmpleadoEn> BuscarEmpleado(String id) {
		// crea el flujo para leer desde el archivo
                
		File file = new File(ruta);
                List<EmpleadoEn> resultado=new ArrayList<EmpleadoEn>();
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
				EmpleadoEn e= new EmpleadoEn();
				e.setNombre(delimitar.next());
				e.setCedula(delimitar.next());
				e.setEstado(delimitar.next());
                               e.setUsuario(delimitar.next());
                               e.setContraseña(delimitar.next());
				if(e.getCedula().equals(id)){
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
          
   //VALIDA QUE EL EMPLEADO ESTE DISPONIBLE PARA REALIZAR PRESTAMOS       
public boolean ValidarDisponibilidadEmpleado(List<EmpleadoEn> listaEmpleados,String cedula){
        boolean estado=false;
        Iterator<EmpleadoEn> i = listaEmpleados.iterator();
        if(i.hasNext()){       
        EmpleadoEn a=(EmpleadoEn)i.next();
         if(a.getCedula().equals(cedula))
         {
         if(a.getEstado().equalsIgnoreCase("disponible")){
         estado=true;
         }
         }
                        }
        
        return estado;
        }
      

//VALIDA USUARIO Y CONRASEÑA PARA EL LOGIN
        public boolean ValidarUCEmpleado(Iterator i,List<EmpleadoEn> l,String u,String c){
        boolean estado=false;
        if(i.hasNext())
        {       
            EmpleadoEn e=(EmpleadoEn)i.next();
         if(e.getUsuario().equals(u) && e.getContraseña().equals(c))
         {
             estado=true;
         }
        }
        return estado;
    }
       
       
       public   List<EmpleadoEn> BuscarUsuarioLogin(String id) {
		// crea el flujo para leer desde el archivo
		File file = new File(ruta);
                List<EmpleadoEn> resultado=new ArrayList<EmpleadoEn>();
		Scanner scanner;
		try{
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
				EmpleadoEn e= new EmpleadoEn();
				e.setNombre(delimitar.next());
				e.setCedula(delimitar.next());
				e.setEstado(delimitar.next());
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
       public void GuardarLoginActual(EmpleadoEn e){
           FileWriter flwriter = null;
                    boolean result=false;
                    
                    try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 

            File file = new File(ruta2);

            flwriter = new FileWriter(ruta2, true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            bfwriter.write(e.getCedula()+","+"2"+ "\n");
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
       
        public EmpleadoEn ObjectoEmpleado(String id) {
		// crea el flujo para leer desde el archivo
              EmpleadoEn empleadoLogin=new EmpleadoEn();
		File file = new File(ruta);
                List<EmpleadoEn> resultado=new ArrayList<EmpleadoEn>();
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
				EmpleadoEn e= new EmpleadoEn();
				e.setNombre(delimitar.next());
				e.setCedula(delimitar.next());
				e.setEstado(delimitar.next());
                                e.setUsuario(delimitar.next());
                                e.setContraseña(delimitar.next());
				if(e.getUsuario().equals(id)){
                                    empleadoLogin=e;
                                }
			}
			//se cierra el ojeto scanner
			scanner.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		return empleadoLogin;
	}
       
       
      
}
