/*
 * bomba.java
 *
 * Created on 13 de septiembre de 2006, 07:49 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package filtros;
import javax.swing.filechooser.FileFilter;
import java.io.File.*;
/**
 *
 * @author ulacit
 */
public class bomba extends
javax.swing.filechooser.FileFilter 
{
    
  public String getDescription()
  {
      return "Busca Bombas";
  }

  /**nos indica cual es el tipo de archivo que debemos haceptar*/
  public boolean accept(final java.io.File archivo)
  {
    //if it is a directory -- we want to show it so return true.
    if (archivo.isDirectory())
      return true; 
    

    String extension = getExtension(archivo);
    //check to see if the extension is equal to "html" or "htm"
    if ((extension.equals("jbb")) || (extension.equals("JBB")))
       return true;
    
    return false;
  }
  
  /**este metodo nos permite obtener la extencion del arhcivo*/
   private String getExtension(java.io.File arhcivo)
  {
    String s = arhcivo.getName();
    int i = s.lastIndexOf('.');
    if (i > 0 &&  i < s.length() - 1)
      return s.substring(i+1).toLowerCase();
    
    return "";
  }    
}
