
package biblioteca.persistencia;

import biblioteca.entidades.EstudianteEn;
import biblioteca.entidades.LibroEn;
import biblioteca.entidades.ReservaEn;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LibroDAO {
     public   List<LibroEn> findRegisters(String id) {
		// crea el flujo para leer desde el archivo
                 String ruta="src\\biblioteca\\persistencia\\Libros.txt";
		File file = new File(ruta);
                List<LibroEn> result=new ArrayList<LibroEn>();
		//se puede estar buscando la tex delimitado y guardando los datos de el persona por capas
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
				LibroEn e= new LibroEn();
 				e.setNombreLibro(delimitar.next());
                                e.setAutor(delimitar.next());
				e.setCodigoLibro(delimitar.next());
                                e.setEstadoLibro(delimitar.next());
				if(e.getCodigoLibro().equals(id)){
                                    result.add(e);
                                }       
			}
			//se cierra el ojeto scanner
			scanner.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
            
		return result;
	}
     
 //busca por titulo o autor
         public   List<LibroEn> CargarRegistro(String titulo,String autor,int j) {
		// crea el flujo para leer desde el archivo
                 String ruta="src\\biblioteca\\persistencia\\Libros.txt";
		File file = new File(ruta);
                List<LibroEn> result=new ArrayList<LibroEn>();
		//se puede estar buscando la tex delimitado y guardando los datos de el persona por capas
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
				LibroEn e= new LibroEn();
 				e.setNombreLibro(delimitar.next());
                                e.setAutor(delimitar.next());
				e.setCodigoLibro(delimitar.next());
                                e.setEstadoLibro(delimitar.next());
                                
                                 if(j==1){   
				if(e.getNombreLibro().contains(titulo.toUpperCase())){
                                    result.add(e);
                                } 
                                 }else{
                                   if(e.getAutor().contains(autor.toUpperCase())){
                                    result.add(e);
                                }  
                                 }
                                
                                
			}
			//se cierra el ojeto scanner
			scanner.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
            
		return result;
	}
         
         
        public String NombreLibro(Iterator i,List<LibroEn> l){
        String nombre="";
        if(i.hasNext())
        {       
            LibroEn e=(LibroEn)i.next();
         nombre=e.getNombreLibro();
        }
        return nombre;
    }
        
        public   boolean LibroDisponible(List<LibroEn> listaLibros,String id) {
		boolean estado=false;
        Iterator<LibroEn> i = listaLibros.iterator();
        if(i.hasNext()){       
        LibroEn a=(LibroEn)i.next();
         if(a.getCodigoLibro().equalsIgnoreCase(id))
         {
         if(a.getEstadoLibro().equalsIgnoreCase("disponible")){
         estado=true;
         }
         }
                        }
        
        return estado;
	}
        
        public void ModificarEstadoLibro(String codigoLibro,String estadoNew){
            String ruta="src\\biblioteca\\persistencia\\Libros.txt";
		// crea el flujo para leer desde el archivo
		File file = new File(ruta);
                List<LibroEn> resultado=new ArrayList<LibroEn>();
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
				LibroEn e= new LibroEn();
				e.setNombreLibro(delimitar.next());
				e.setAutor(delimitar.next());
                                e.setCodigoLibro(delimitar.next());
                                e.setEstadoLibro(delimitar.next());
				if(e.getCodigoLibro().equals(codigoLibro)){
                                e.setEstadoLibro(estadoNew);
                                }
                                resultado.add(e);
                                
			}
                        
			//se cierra el ojeto scanner
			scanner.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
                
                file.delete();
                
                for(LibroEn l:resultado){
                    GuardarLibro(l);
                }
        }
        
        public void GuardarLibro(LibroEn l){
              String ruta="src\\biblioteca\\persistencia\\Libros.txt";
        FileWriter flwriter = null;
                    boolean result=false;
                    
                    try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 

            File file = new File(ruta);

            flwriter = new FileWriter(ruta, true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            bfwriter.write(l.getNombreLibro()+","+l.getAutor()+","+l.getCodigoLibro()+","+l.getEstadoLibro()+ "\n");
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

    }
}
