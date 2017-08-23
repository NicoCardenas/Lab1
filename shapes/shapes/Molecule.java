import java.awt.*;

/**
 * Write a description of class Molecule here.
 * 
 * @author  Paola Cuellar y Nicolás Cárdenas
 * @version 1.0  (22 August 2017)
 */

public class Molecule{
    private Rectangle back;
    private String cadena;
    private boolean isVisible;
    
    /**
     * Constructor for objects of class Molecule
     */
    public Molecule(String datos){
        back = new Rectangle();
        back.changeSize(50,50);
        back.changeColor("yellow");
        isVisible = false;
        cadena = datos;
        System.out.println(cadena.charAt(6));
        //cadena.toCharArray();
        //cadena.split(cadena);
    }
    public void makeVisible(){
        back.makeVisible();
        isVisible = true;
    }
    public void makeInvisible(){
        back.makeInvisible();
        isVisible = false;
    }

}
