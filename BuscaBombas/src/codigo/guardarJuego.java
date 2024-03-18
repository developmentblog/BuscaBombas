/*
 * guardarJuego.java
 *
 * Created on March 13, 2005, 12:36 PM
 */
package codigo;
import javax.swing.JOptionPane; 
import java.io.RandomAccessFile;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.awt.Event.*;
import java.awt.*;
import java.util.*;
/**
 *
 * @author  jean carlos
 */ 
public class guardarJuego 
{
    
    /** Creates a new instance of guardarJuego */
    private RandomAccessFile archivo;/**variable que nos funciona para guardar los archivos*/
    private BufferedReader leerArchivo;/**se encarha de abriri el archivo que se esta utilizando*/
    private Frame interfaz;/**frame para poder montar el Flile*/
    private FileDialog buscador;/**este es el que se desplega en la busqueda*/
    private FileDialog guardar;/**este se engarga de cargar los archivos*/
    private String localidad;/**guarda la direccion del archivo*/
    private String contenidoArchivo;/**esta variable guarda lo que tiene el archivo*/
    private Date fecha = new Date();/**esta variable funciona para ver la hora*/
    private Calendar cl;/**esta varaiable es para el usu de fecha y hora*/
    private Abrir abrir;
    public guardarJuego()
    {
        interfaz = new Frame();
        buscador = new FileDialog(interfaz,"Cargar juego",FileDialog.LOAD);
        guardar= new FileDialog(interfaz,"Gurdar juego",FileDialog.SAVE);        
    }
    
    /**este metodo se encaraga de leer el archivo que el usuario guardo*/
    private void abrirJuego(String direccion)
    {
        String aux;
        contenidoArchivo="";
        try{
            leerArchivo = new BufferedReader(new FileReader(direccion));        
            aux=leerArchivo.readLine();
            while(aux!=null)
            {
                contenidoArchivo+=aux;
                aux=leerArchivo.readLine();
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Ocurrio algo con el archivo "+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        finally
        {
            try{
                     leerArchivo.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"El archivo no se puede serrar "+e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /**este metodo se encarga de abrir el dialogo que se encarga de guardar la informacion*/
    private void verDialog()
    {
        localidad="";
        abrir = new Abrir(true);
        //buscador.setVisible(true);    
        int valorDelDialog= abrir.abrir();
        //localidad = buscador.getDirectory()/*+System.getProperty("file.jbb")+*/+buscador.getFile();
        localidad = abrir.jLeer.getSelectedFile().getAbsolutePath();
         if (valorDelDialog==abrir.jLeer.APPROVE_OPTION){
            try{
                 if(darPunto())
                {
                    abrirJuego(localidad);
                }
                else 
                {
                    JOptionPane.showMessageDialog(null,"El archivo no es del juego busca bomas");
                   verDialog();  
                }
            }
            catch(NullPointerException e)
            {

            }
       }     
        
 
    }
    
    /**este metodo se encarga de verificar que el archivo que escogieron sea verdadero*/
    private boolean darPunto()
    {
        int punto=abrir.jLeer.getSelectedFile().getAbsolutePath().indexOf(".");//buscador.getFile().indexOf(".");        
        //return(buscador.getFile().substring(punto,buscador.getFile().length()).equals(".jbb"));
        return(abrir.jLeer.getSelectedFile().getAbsolutePath().substring(punto,abrir.jLeer.getSelectedFile().getAbsolutePath().length()).equals(".jbb"));       
    }
    
    /**este metodo nos ayuda a guardar el archivo que el usuario desea guardar*/
    public void verGuardar(String contenido)
    {
        try{
        guardar.setVisible(true);
        localidad="";
        localidad=guardar.getDirectory()+guardar.getFile();  
        guardarArchivo(localidad+".jbb",contenido);        
        }
        catch(NullPointerException e)
        {
            
        }
       
    }       
    
    /**este metodo se encarga de guardar los juegos del jugador*/
    private void guardarArchivo(String documento, String contenido)
    {
        try{
            contenido=obtenerFechaOra(contenido);
            archivo = new RandomAccessFile(documento,"rw");
            archivo.writeBytes(contenido);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"<-- html COLOR=RED -->Ocurrio un problema con el archivo "+e+"</html>","Problemas",JOptionPane.ERROR_MESSAGE);
        }
        finally{
            try{
                archivo.close();
            }
            catch(Exception e)
            {
              JOptionPane.showMessageDialog(null,"<-- html COLOR=RED -->Ocurrio un problema con el archivo "+e+"</html>","Problemas",JOptionPane.ERROR_MESSAGE);
            }            
        }        
    }
    
    /**este metodo se encarga de abrir el dialog que guarda el juego*/
    public void guardarJuego(String contenido)    
    {
        verGuardar(contenido);
    }
    
   public String verJuego()
    {
        verDialog();
        return contenidoArchivo;
    }
    
    /**este metodo nos da la fecha y la hora de toda la cadena*/
    private String obtenerFechaOra(String cadena)
    {        
        
        cl = Calendar.getInstance();
        cadena+="@"+Integer.toString(fecha.getHours())+" : "+Integer.toString(fecha.getMinutes())+"@"
        +Integer.toString(fecha.getDate())+" / "+Integer.toString(fecha.getMonth()+1)+" / "+Integer.toString((fecha.getYear()+1900));      
        return cadena;
    }
    
    /**este metodo se encaraga de dar la hora actual*/
    public String horaActual()
    {
        cl=Calendar.getInstance();
         return (Integer.toString(fecha.getHours())+":"+Integer.toString(fecha.getMinutes()));
    }   

    
    
}
