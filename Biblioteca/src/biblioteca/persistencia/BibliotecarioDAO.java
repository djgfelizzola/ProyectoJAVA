
package biblioteca.persistencia;

import biblioteca.entidades.BibliotecarioEn;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class BibliotecarioDAO {
   
    
       public   List<BibliotecarioEn> findRegisters(String id) {
		// crea el flujo para leer desde el archivo
                 String ruta="src\\biblioteca\\persistencia\\Bibliotecarios.txt";
		File file = new File(ruta);
                List<BibliotecarioEn> result=new ArrayList<BibliotecarioEn>();
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
				BibliotecarioEn e= new BibliotecarioEn();
 				e.setUsuario(delimitar.next());
				e.setContraseña(delimitar.next());
                                
				if(e.getUsuario().equals(id)){
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
      
      public boolean ValidarUC(Iterator i,List<BibliotecarioEn> l,String u,String c){
        boolean estado=false;
        if(i.hasNext())
        {       
         BibliotecarioEn a=(BibliotecarioEn)i.next();
         if(a.getUsuario().equals(u) && a.getContraseña().equals(c))
         {
             estado=true;
         }
        }
        return estado;
    }
}
