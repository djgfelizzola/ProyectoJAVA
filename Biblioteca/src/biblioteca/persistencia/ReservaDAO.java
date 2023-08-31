
package biblioteca.persistencia;

import biblioteca.entidades.EmpleadoEn;
import biblioteca.entidades.EstudianteEn;
import biblioteca.entidades.ReservaEn;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservaDAO {
   String ruta="src\\biblioteca\\persistencia\\Reservas.txt";
    public boolean GuardarReserva(ReservaEn r){
        FileWriter flwriter = null;
                    boolean result=false;
                    
                    try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 

            File file = new File(ruta);

            flwriter = new FileWriter(ruta, true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            bfwriter.write(r.getNombreLibro()+","+r.getCodigoLibro()+","+r.getCodigoCliente()+","+r.getFechaReserva()+ "\n");
            bfwriter.close();
            result = true;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    
    public void EliminarReserva(String codigoLibro) {
		// crea el flujo para leer desde el archivo
		File file = new File(ruta);
                List<ReservaEn> resultado=new ArrayList<ReservaEn>();
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
				ReservaEn e= new ReservaEn();
				e.setNombreLibro(delimitar.next());
				e.setCodigoLibro(delimitar.next());
                                e.setCodigoCliente(delimitar.next());
                                e.setFechaReserva(delimitar.next());
				if(!e.getCodigoLibro().equals(codigoLibro)){
                                resultado.add(e);
                                }
                                
			}
                        
			//se cierra el ojeto scanner
			scanner.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
                
                file.delete();
                
                for(ReservaEn r:resultado){
                    GuardarReserva(r);
                }
	
	}
    
public   List<ReservaEn> BuscarReserva(String codigoLibro) {
		// crea el flujo para leer desde el archivo
                
		File file = new File(ruta);
                List<ReservaEn> resultado=new ArrayList<ReservaEn>();
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
				ReservaEn e= new ReservaEn();
				e.setNombreLibro(delimitar.next());
				e.setCodigoLibro(delimitar.next());
				e.setCodigoCliente(delimitar.next());
                                e.setFechaReserva(delimitar.next());
                              
				if(e.getCodigoLibro().equals(codigoLibro)){
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
public boolean ValidarEliminarReserva(String codigoLibro,String id) {
    boolean vali=false;
		// crea el flujo para leer desde el archivo
		File file = new File(ruta);
                List<ReservaEn> resultado=new ArrayList<ReservaEn>();
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
				ReservaEn e= new ReservaEn();
				e.setNombreLibro(delimitar.next());
				e.setCodigoLibro(delimitar.next());
                                e.setCodigoCliente(delimitar.next());
                                e.setFechaReserva(delimitar.next());
				if(e.getCodigoLibro().equals(codigoLibro) && e.getCodigoCliente().equals(id)){
                                vali=true;
                                }
                                
			}
                        
			//se cierra el ojeto scanner
			scanner.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
                
               return vali;
	}
String ruta2="src\\biblioteca\\persistencia\\LoginActual.txt";
public String[] RetornarId(){
    String vec[]=new String[2];
    String id="";
    String sw="0";  
    // crea el flujo para leer desde el archivo
		File file = new File(ruta2);
                List<ReservaEn> resultado=new ArrayList<ReservaEn>();
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
				id=delimitar.next();
                                sw=delimitar.next();
                                
			}
                        vec[0]=id;
                        vec[1]=sw;
			//se cierra el ojeto scanner
			scanner.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
            return vec;    
}

public void EliminarLoginActual(){
   File file=new File(ruta2);
   file.delete();
}

}
