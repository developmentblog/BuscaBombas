/*
 * Matriz.java 
 *
 * Created on 3 de marzo de 2005, 09:02 PM
 */
package codigo;
import javax.swing.JOptionPane; 
/**
 *
 * @author  Jean carlos Rojas Ramirez
 */
public class Matriz {
    
    public int[][] MAtriz;/**matriz que tine las minas del juego*/
    private int cantidadMinas;/**numero de minas que se pueden tener en la matriz*/
    private int x;/**posisicones en las cuales se pondra las minas*/
    private int y;/**posiciones  en las cuales se pondran las minas*/
    private int tamano;/**tamaño de la matriz*/
    /** Creates a new instance of Matriz */
    
    public Matriz(int tamano, int cantidadMinas) 
    {
        this.cantidadMinas=cantidadMinas;
        this.tamano=tamano;
        MAtriz = new int [tamano][tamano];
        llenarMinas();
       //  verMatriz();
        llenarCuantasMinas();        
    }
    
    /**este metodo se encarga de llenar las minas que el usuario pidio en posiciones estrategicas*/
    private  void llenarMinas()
    {
        for(int i=0;i<cantidadMinas; i++)
        {
           x=(int)(Math.random()*tamano);//nos da la mina en x
         // System.out.println(x);
          y=(int)(Math.random()*tamano);//posicion de la mina en y
          
              if(hayMina()==false)//si no hay minas se agrega una en esa poscion
              MAtriz[x][y]=-1;
              else//si hay minas se tiene que agregar un ciclo mas
              i--;
        }
    }
    
    /**este metodo se encaraga de ver cuantas minas tienen los vecinos de las minas*/
    private void llenarCuantasMinas()
    {
        try{           
                    llenarMinasAbajo();
                    llenarMinasArriba();
                    llenarMinasDerecha();
                    llenarMinasIzquierda();
                    llenarMinasArribaDerecha();
                    llenarMinasArribaIzquierda();
                   llenarMinasAbajoIzquierda();                  
                     llenarMinasAbajoDerecha();//*/
               
           
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null,"Ocurrio una falla con el programa "+e);
        }
    }
    
    /**este metodo se encarga de contar las minas que se encuentran abajo de la matriz*/
    private void llenarMinasAbajo()
    {
        for(int a=0; a<tamano;a++)
        {
            for(int b=0;b<tamano;b++)
            {
              //JOptionPane.showMessageDialog(null,""+a+" "+b);
                if(MAtriz[a][b]!=-1)
                {
                     if(a+1<tamano)//abajo
                        {
                            if(abajo(a,b)==true)
                            {
                                MAtriz[a][b]++;  
                               // JOptionPane.showMessageDialog(null,"se suma abajo");
                            }
                        }

                }
            }
        }
    }
    
     /**este metodo se encarga de contar las minas que se encuentran Arriba de la matriz*/
    private void llenarMinasArriba()
    {
        for(int i=0; i<tamano;i++)
        {
            for(int j=0;j<tamano;j++)
            {
               // JOptionPane.showMessageDialog(null,""+i+" "+j);
                if(MAtriz[i][j]!=-1)
                {
                      if(i-1>=0)//arriba
                        {
                            if(arriba(i,j)==true)
                                MAtriz[i][j]++;

                        }

                }
            }
        }
    }
    
     /**este metodo se encarga de contar las minas que se encuentran derecha de la matriz*/
    private void llenarMinasDerecha()
    {
        for(int c=0; c<tamano;c++)
        {
            for(int d=0;d<tamano;d++)
            {
              //JOptionPane.showMessageDialog(null,""+c+" "+d);
                if(MAtriz[c][d]!=-1)
                {
                      if(d+1<tamano)//derecha
                        {
                            if(derecha(c,d)==true)
                                MAtriz[c][d]++;
                        }
                }
            }
        }
    }
    
     /**este metodo se encarga de contar las minas que se encuentran Izquierda de la matriz*/
     private void llenarMinasIzquierda()
    {
        for(int e=0; e<tamano;e++)
        {
            for(int f=0;f<tamano;f++)
            {
              //JOptionPane.showMessageDialog(null,""+e+" "+f);
                if(MAtriz[e][f]!=-1)
                {
                     if(f-1>=0)//izquierda
                     {
                        if(izquierda(e,f)==true)
                         MAtriz[e][f]++;
                     }
                }
            }
        }
    }
    
      /**este metodo se encarga de contar las minas que se encuentran arribaDerecha de la matriz*/
    private void llenarMinasArribaDerecha()
    {
        for(int g=0; g<tamano;g++)
        {
            for(int h=0;h<tamano;h++)
            {
                if(MAtriz[g][h]!=-1)
                {
              // JOptionPane.showMessageDialog(null,""+g+" "+h);
                      if(g-1>=0&&h+1<tamano)//arriba derecha
                        {
                            if(derechaArriba(g,h)==true)
                                MAtriz[g][h]++;
                        }
                }
            }
        }
    }
     
      /**este metodo se encarga de contar las minas que se encuentran Arriba izquierda de la matriz*/
    private void llenarMinasArribaIzquierda()
    {
        for(int k=0; k<tamano;k++)
        {
            for(int o=0;o<tamano;o++)
            {
             //JOptionPane.showMessageDialog(null,""+k+" "+o);
                if(MAtriz[k][o]!=-1)
                {
                      if(k-1>=0&&o-1>=0)//arriba izquierda
                        {
                            if(izquierdaArriba(k,o)==true)
                            MAtriz[k][o]++;
                        }
                }
            }
        }
    }
    
     /**este metodo se encarga de contar las minas que se encuentran abajo izquierda de la matriz*/
    private void llenarMinasAbajoIzquierda()
    {
        for(int p=0; p<tamano;p++)
        {
            for(int q=0;q<tamano;q++)
            {
             // JOptionPane.showMessageDialog(null,""+p+" "+q);

                if(MAtriz[p][q]!=-1)
                {
                     
                        if(p+1<tamano&&q-1>=0)//abajo izquierda
                        {
                            if(izquierdaAbajo(p,q)==true)
                                MAtriz[p][q]++;
                        }
                }
            }
        }
    }
    
     /**este metodo se encarga de contar las minas que se encuentran abajo izquierda de la matriz*/
    private void llenarMinasAbajoDerecha()
    {
        for(int r=0; r<tamano;r++)
        {
            for(int s=0;s<tamano;s++)
            {
             // JOptionPane.showMessageDialog(null,""+r+" "+s);

                if(MAtriz[r][s]!=-1)
                {                                      
                        if(r+1<tamano&&s+1<tamano)//abajo derecha
                        {
                            if(derechaAbajo(r,s)==true)
                                MAtriz[r][s]++;
                        }
                }
            }
        }
    }
    
    
    /**este metodo nos dice que si hay una mina en la parte inferior de la posicion*/
    private boolean abajo(int p1, int p2)
    {
     // JOptionPane.showMessageDialog(null,"abajo:"+p1+" "+p2+"  "+MAtriz[p1][p2]+"  "+MAtriz[p1+1][p2]);
        return(MAtriz[p1+1][p2]==-1);//hay una mina
    }
    
    /**dice que existe una mina sobre la posicion determinada que se quiere buscar*/
    private boolean arriba(int p1, int p2)
    {
      // JOptionPane.showMessageDialog(null,"arriba:"+p1+" "+p2+"  "+MAtriz[p1][p2]+"  "+MAtriz[p1-1][p2]);
        return(MAtriz[p1-1][p2]==-1);//dice que hay una mina arriba
    }
    
    /**este nos indica si existe una mina al lado izquierdo de un vecino determinado*/
    private boolean izquierda(int p1, int p2)
    {
    //  JOptionPane.showMessageDialog(null,"izquierda:"+p1+" "+p2+"  "+MAtriz[p1][p2]+"  "+MAtriz[p1][p2-1]);
        return(MAtriz[p1][p2-1]==-1);//si hay una mina en esa pocicion
    }
    
    /**este metodo nos indica que hay una mina en la posicion derecha del vecino*/
    private boolean derecha(int p1, int p2)
    {
            //  JOptionPane.showMessageDialog(null,"derecha:"+p1+" "+p2+"  "+MAtriz[p1][p2]+"  "+MAtriz[p1][p2+1]);

        return(MAtriz[p1][p2+1]==-1);//hay vecinos a la derecah
    }    
    
    /**este metodo nos dice si exite una mina en la esquina de arriba izquierda*/
    private boolean izquierdaArriba(int p1, int p2)
    {
           //    JOptionPane.showMessageDialog(null,"izquiedaArriba:"+p1+" "+p2+"  "+MAtriz[p1][p2]+"  "+MAtriz[p1-1][p2-1]);

        return(MAtriz[p1-1][p2-1]==-1);//si existe mina
    }
    
    /**este metodo nos dice que exite mina en la parte de la esquina superior derecah*/
    private boolean derechaArriba(int p1, int p2)
    {
          //   JOptionPane.showMessageDialog(null,"derechaArriba:"+p1+" "+p2+"  "+MAtriz[p1][p2]+"  "+MAtriz[p1-1][p2+1]);

        return(MAtriz[p1-1][p2+1]==-1);//existe mina en esta posicion
    }
    
    /**este metodo nos dice que existe una mina en la esquina  inferior izquierda*/
    private boolean izquierdaAbajo(int p1, int p2)
    {
           //  JOptionPane.showMessageDialog(null,"izquierda Abajo:"+p1+" "+p2+"  "+MAtriz[p1][p2]+"  "+MAtriz[p1+1][p2-1]);

        return(MAtriz[p1+1][p2-1]==-1);//exiet mina
    }
    
    /**este metodo nos dice que existe una mina en la esquina inferiro derecha*/
    private boolean derechaAbajo(int p1, int p2)
    { 
            //  JOptionPane.showMessageDialog(null,"derecha abajo:"+p1+" "+p2+"  "+MAtriz[p1][p2]+"  "+MAtriz[p1+1][p2+1]);

        return(MAtriz[p1+1][p2+1]==-1);//existe mina
    }
    
    /**este metodo se encarga de imprimir la matriz*/
    public void verMatriz()
    {
        for(int i=0; i<tamano; i++)
        {
            for (int j=0; j<tamano;j++)
            {
                System.out.print(" "+MAtriz[i][j]+" ");
            }
            System.out.println();
        }
    }
  
    
    /**este metodo verifica que no existen minas en una misma posicion*/
    private boolean hayMina()
    {
        return(MAtriz[x][y]==-1);//existen minas en esta pocicion
    }    
    
   /* public static void main(String jean[])
    {
        Matriz m = new Matriz(8,30);
        
        m.verMatriz();       
        System.out.println();
        System.out.println();
        m.verMatriz();
    }//*/
    
}

