
package biblioteca.persistencia;

import biblioteca.entidades.PrestamoEn;
import biblioteca.entidades.ReservaEn;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class PrestamoDAO {
    String ruta="src\\biblioteca\\persistencia\\Prestamos.txt";
    public boolean GuardarPrestamo(PrestamoEn r){
        FileWriter flwriter = null;
                    boolean result=false;
                    
                    try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 

            File file = new File(ruta);

            flwriter = new FileWriter(ruta, true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            bfwriter.write(r.getCodigoLibro()+","+r.getIdentificacion()+","+r.getFechaInicio()+","+r.getFechaFinal()+ "\n");
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
}
