/*
 * cambiarInterfaz.java
 *
 * Created on December 9, 2005, 7:23 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package lookAndFeel;
import javax.swing.UIManager;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;

/**
 *
 * @author jean carlos
 */
public class cambiarInterfaz {
    
    /**nos ayuda a combiar la vista para java */
    public void JavaLook(javax.swing.JFrame pantalla)
    {
        try{
             if(Existe("javax.swing.plaf.metal.MetalLookAndFeel")==true){
                 UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                 SwingUtilities.updateComponentTreeUI(pantalla);
              }
              else
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch(Exception e)
        {
            javax.swing.JOptionPane.showMessageDialog(null,"No Se puede cambiar vista ","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**actualiza las vistas en forma de windows*/
    public void WindowsLook(javax.swing.JFrame pantalla)
    {
         try{
              if(Existe("com.sun.java.swing.plaf.windows.WindowsLookAndFeel")==true){
                 UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                 SwingUtilities.updateComponentTreeUI(pantalla);
           }
            else
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch(Exception e)
        {
            javax.swing.JOptionPane.showMessageDialog(null,"No Se puede cambiar vista ","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**actualiza las vistar en forma de metal*/
    public void MetalLook(javax.swing.JFrame pantalla)
    {
        try{
            if(Existe("com.sun.java.swing.plaf.motif.MotifLookAndFeel")==true){
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                SwingUtilities.updateComponentTreeUI(pantalla);
            }
            else
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch(Exception e)
        {
            javax.swing.JOptionPane.showMessageDialog(null,"No Se puede cambiar vista ","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**cambia los componentes de tipo GTK*/
    public void GTKLook(javax.swing.JFrame pantalla)
    {
        try{
            if(Existe( "com.sun.java.swing.plaf.gtk.GTKLookAndFeel")==true){
                UIManager.setLookAndFeel( "com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
                SwingUtilities.updateComponentTreeUI(pantalla);
            }
            else
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch(Exception e)
        {
            javax.swing.JOptionPane.showMessageDialog(null,"No Se puede cambiar vista ","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**cambia el look and feel de la mac*/
    public void MacLook(javax.swing.JFrame pantalla)
    {
        
        try{
            if(Existe( "com.sun.java.swing.plaf.mac.MacLookAndFeel")==true){
                UIManager.setLookAndFeel( "com.sun.java.swing.plaf.mac.MacLookAndFeel");
                SwingUtilities.updateComponentTreeUI(pantalla);
            }
            else
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());                
            
        }
        catch(Exception e)
        {
            javax.swing.JOptionPane.showMessageDialog(null,"No Se puede cambiar vista ","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**nos ayuda a ver si existe el look and feel escogido por el usuario*/
    private boolean Existe(String look)
    {
         try { 
             Class pedida = Class.forName(look);
             LookAndFeel verificarLK = (LookAndFeel)(pedida.newInstance());
             return verificarLK.isSupportedLookAndFeel();
         } catch (Exception e) { 
             return false;
         }
    }   
   
    
    /**tiene la informacion del escritor de esta clase
     *que ayuda a cambiar la vista o apariencia del programa
     */
    public void autor()
    {
        javax.swing.JOptionPane.showMessageDialog(null,"Jean Carlos Rojas Rammirez \n Costa Rica","Autor",javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
}